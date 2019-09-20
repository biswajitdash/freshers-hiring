package com.sasken.website.career.service;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sasken.website.SaskenWebApplication;
import com.sasken.website.career.dao.CompetitivesRepository;
import com.sasken.website.career.dao.ExamsRepository;
import com.sasken.website.career.dao.FreshersHiringDao;
import com.sasken.website.career.dao.FreshersHiringRepository;
import com.sasken.website.career.dao.PercentageRuleRepository;
import com.sasken.website.career.dao.WeightageRepository;
import com.sasken.website.career.entity.CompetitiveExamEntity;
import com.sasken.website.career.entity.CompetitivesEntity;
import com.sasken.website.career.entity.ExamEntity;
import com.sasken.website.career.entity.Fresher;
import com.sasken.website.career.entity.PercentageRules;
import com.sasken.website.career.entity.QualificationWeightage;
import com.sasken.website.career.model.Competitives;
import com.sasken.website.career.model.AppConfigurations;
import com.sasken.website.career.model.CompetitiveExam;
import com.sasken.website.career.model.EducationDetails;
import com.sasken.website.career.model.Exam;
import com.sasken.website.career.model.FresherDetails;
import com.sasken.website.career.model.ResponseDataBo;
import com.sasken.website.common.FresherMapper;
import com.sasken.website.common.GlobalProperties;
import com.sasken.website.common.StorageService;
import com.sasken.website.mail.EmailService;
import com.sasken.website.mail.Mail;
import com.udojava.evalex.Expression;

import freemarker.core.ParseException;

@Service
public class FresherHiringServiceImpl implements FresherHiringService {

	private static Logger log = LoggerFactory.getLogger(SaskenWebApplication.class);

	@Autowired
	private FreshersHiringRepository fresherRepository;

	@Autowired
	private EmailService emailService;

	@Autowired
	StorageService storageService;

	@Autowired
	private WeightageRepository weightageRepository;

	@Autowired
	private PercentageRuleRepository rangeRepository;

	@Autowired
	private GlobalProperties globalProperties;

	@Autowired
	private FresherMapper mapper;

	@Autowired
	private ResponseDataBo response;

	@Autowired
	private ExamsRepository examRepository;

	@Autowired
	private CompetitivesRepository compRepository;

	@Override
	public ResponseDataBo processFresherDetails(FresherDetails fresherDetails) {

		try {
			Set<EducationDetails> education = fresherDetails.getEducationDetails();
			Iterator<EducationDetails> itr = education.iterator();
			while (itr.hasNext()) {
				EducationDetails educationDtls = itr.next();

				if (educationDtls.getMarks() != null && !educationDtls.getMarks().equals("")) {
					String gradingSystem = educationDtls.getGradeSystem();
					if (gradingSystem.equalsIgnoreCase("cgpa")) {
						double marksVal = Double.parseDouble(educationDtls.getMarks());
						double percentsTemp = marksVal * 9.5;
						educationDtls.setMarksPercentage(String.valueOf(percentsTemp));
					} else if (gradingSystem.equalsIgnoreCase("percentage")) {
						educationDtls.setMarksPercentage(educationDtls.getMarks());
					} else {
						log.error("Grade is not valid :" + gradingSystem);
						response.setCode(500);
						response.setMessage("Provided Grading System is not valid");
						return response;
					}
				}
			}
			Fresher fresher = mapper.convertToEntity(fresherDetails);
			addFresher(fresher);

			if (fresher.getFresherId() > 0) {
				new Thread(() -> {
					try {
						MultipartFile file = fresherDetails.getUploadedResume();
						if (file != null && !file.isEmpty() && fresher.getFresherId() != 0) {
							storageService.store(file, String.valueOf(fresher.getFresherId()));
						}
					} catch (Exception e) {
						log.error("Error while storing resume\n " + e);
					}

					try {
						if (validateFresherHireCriteria(fresherDetails)) {
							sendMailToHr(fresherDetails);
							sendMailToSelectedCandidate(fresherDetails);
						} else {
							sendMailToRejectedCandidate(fresherDetails);
						}

					} catch (Exception e) {
						log.error("Error while sending email\n " + e);
					}
				}).start();

			}

			response.setCode(201);
			response.setMessage("Success");

		} catch (ParseException e) {
			log.error("Error while parsing" + e);
			response.setCode(500);
			response.setMessage("Error");
		} catch (Exception e) {
			log.error("Error in procession fresher details" + e);
			response.setCode(500);
			response.setMessage("Error");
		}

		return response;
	}

	@Override
	public Fresher addFresher(Fresher fresher) {

		return fresherRepository.save(fresher);
	}

	@Override
	public List<Fresher> findAllFreshers() {

		return fresherRepository.findAll();
	}

	public boolean sendMailToHr(FresherDetails fresherDetails) {

		Mail mail = new Mail();
		mail.setFrom(globalProperties.getFromEmailId());
		System.out.println("From EmailId " + globalProperties.getFromEmailId());
		mail.setTo(globalProperties.getToEmailIdsHr());
		mail.setSubject(globalProperties.getEmailSubHr());

		Map<String, Object> model = new HashMap<>();
		model.put("name", "HR Team");
		model.put("candidateName", fresherDetails.getName());
		model.put("candidateEmail", fresherDetails.getEmail());
		model.put("candidatePhone", fresherDetails.getMobileNo());
		mail.setModel(model);
		mail.setAttachment(fresherDetails.getUploadedResume());
		mail.setTemplateName("hr-email-template.ftl");
		try {
			emailService.sendEmail(mail);
			return true;
		} catch (Exception e) {
			log.error("Error while sending email to HR team " + e.getMessage());
		}
		return false;
	}

	public boolean sendMailToSelectedCandidate(FresherDetails fresherDetails) {
		Mail mail = new Mail();
		mail.setFrom(globalProperties.getFromEmailId());
		mail.setTo(fresherDetails.getEmail());
		mail.setSubject(globalProperties.getEmailSubCandidate());

		Map<String, Object> model = new HashMap<>();
		model.put("name", fresherDetails.getName());
		mail.setModel(model);
		mail.setTemplateName("selected-candidate-email.ftl");
		try {
			emailService.sendEmail(mail);
			return true;
		} catch (Exception e) {
			log.error("Error while sending email to candidate " + e.getMessage());
		}
		return false;
	}

	public boolean sendMailToRejectedCandidate(FresherDetails fresherDetails) {
		Mail mail = new Mail();
		mail.setFrom(globalProperties.getFromEmailId());
		mail.setTo(fresherDetails.getEmail());
		mail.setSubject(globalProperties.getEmailSubCandidate());

		Map<String, Object> model = new HashMap<>();
		model.put("name", fresherDetails.getName());
		mail.setModel(model);
		mail.setTemplateName("rejected-candidate-email.ftl");
		try {
			emailService.sendEmail(mail);
			return true;
		} catch (Exception e) {
			log.error("Error while sending email to candidate " + e.getMessage());
		}
		return false;
	}

	public boolean validateFresherHireCriteria(FresherDetails fresherDetails) {

		List<PercentageRules> rules = rangeRepository.findAll();
		List<QualificationWeightage> weightageList = weightageRepository.findAll();

		// String hieghQualification = "MTECH";
		String hieghQualification = fresherDetails.getHighestQualification();
		List<QualificationWeightage> weightageListFilter = weightageList.stream()
				.filter(p -> p.getHighQualification().equals(hieghQualification)).collect(Collectors.toList());
		Map<String, Float> weightageMap = mapQualificationWeight(weightageListFilter);

		Set<EducationDetails> educationDetails = fresherDetails.getEducationDetails();
		Set<Competitives> comptitiveExams = fresherDetails.getCompetitives();

		Double totalPoints = 0d;
		for (EducationDetails eDetails : educationDetails) {

			float percentage = 0;
			try {
				percentage = Float.parseFloat(eDetails.getMarksPercentage());
			} catch (Exception e) {
			}
			if (percentage > 0) {
				float points = getPoints(eDetails.getMarksPercentage(), rules);
				Float weightage = weightageMap.get(eDetails.getExam().getExamName());
				if (weightage != null) {

					totalPoints = totalPoints + (weightage * points);
					log.info(" Exam name    : " + eDetails.getExam().getExamName() + " With %       : "
							+ eDetails.getMarksPercentage() + " Points       :" + points + " Wt Point     :"
							+ (weightage * points) + " Total Points : " + totalPoints);
				}

			}

		}

		for (Competitives comptiton : comptitiveExams) {
			float percentage = 0;
			try {
				percentage = Float.parseFloat(comptiton.getMarksScorePercentage());
			} catch (Exception e) {
			}
			if (percentage > 0) {
				float points = getPoints(comptiton.getMarksScorePercentage(), rules);
				Float weightage = weightageMap.get(comptiton.getExamName());
				if (weightage != null) {
					totalPoints = totalPoints + weightage * points;

					log.info(" Exam name    : " + comptiton.getExamName() + "      With %       : "
							+ comptiton.getMarksScorePercentage() + "      Points       :" + points
							+ "      Wt Point     :" + (weightage * points) + "      Total Points : " + totalPoints);
				}

			}

		}
		log.info("------Total Points------" + totalPoints);

		if (totalPoints >= Integer.parseInt(globalProperties.getPercentageCutoff())) {
			return true;
		}

		return false;
	}

	private float getPoints(String marksPercentage, List<PercentageRules> rules) {
		float points = 0;
		BigDecimal percentage = new BigDecimal("0");
		if (marksPercentage != null && !marksPercentage.equals("")) {
			percentage = new BigDecimal(marksPercentage);
		}

		for (PercentageRules rule : rules) {
			Expression expression = new Expression(rule.getRule()).with("percentage", percentage);
			BigDecimal result = expression.eval();
			if (result.intValue() == 1) {
				points = rule.getPoints();
			}
		}
		return points;
	}

	public Map<String, Float> mapQualificationWeight(List<QualificationWeightage> list) {
		Map<String, Float> result = new HashMap<String, Float>();
		for (QualificationWeightage weightage : list) {
			result.put(weightage.getQualification(), weightage.getWeightage());
		}
		return result;
	}

	@Override
	public AppConfigurations getConfigurations() {

		AppConfigurations config = new AppConfigurations();

		List<ExamEntity> exams = examRepository.findAll();
		List<CompetitiveExamEntity> compExams = compRepository.findAll();

		List<Exam> examsList = exams.stream().map(temp -> {
			Exam eObj = new Exam();
			eObj.setExamId(temp.getExamId());
			eObj.setExamName(temp.getExamName());
			eObj.setLabel(temp.getLabel());
			return eObj;
		}).collect(Collectors.toList());

		List<CompetitiveExam> compExamList = compExams.stream().map(temp -> {
			CompetitiveExam ceObj = new CompetitiveExam();
			ceObj.setCompetitiveExamId(temp.getCompetitiveExamId());
			ceObj.setExamName(temp.getExamName());
			return ceObj;
		}).collect(Collectors.toList());

		config.setExams(examsList);
		config.setCompetitiveExams(compExamList);
		config.setHighestQualifications(examsList);
		config.setInitialYear(1980);
		config.setMaxYears(50);

		return config;
	}

}
