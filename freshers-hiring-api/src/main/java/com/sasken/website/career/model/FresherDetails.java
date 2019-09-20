package com.sasken.website.career.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

public class FresherDetails {

	private long fresherId;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	private String surname;
	private String dateOfBirth;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@NotBlank(message = "Mobile Number is mandatory")
	private String mobileNo;
	
	@NotBlank(message = "Project is mandatory")
	private String projectDescription;
	private String resume;
	
	@NotNull(message = "Accept Privacy Policy")
	private boolean legalConsent;
	
	@NotBlank(message = "Highest Qualification is mandatory")
	private String highestQualification;
	
	private Set<EducationDetails> educationDetails = new HashSet<EducationDetails>();
	private Set<Competitives> competitives = new HashSet<Competitives>();
	MultipartFile uploadedResume;

	public long getFresherId() {
		return fresherId;
	}

	public void setFresherId(long fresherId) {
		this.fresherId = fresherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public boolean isLegalConsent() {
		return legalConsent;
	}

	public void setLegalConsent(boolean legalConsent) {
		this.legalConsent = legalConsent;
	}

	
	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public Set<EducationDetails> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(Set<EducationDetails> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public Set<Competitives> getCompetitives() {
		return competitives;
	}

	public void setCompetitives(Set<Competitives> competitives) {
		this.competitives = competitives;
	}

	public MultipartFile getUploadedResume() {
		return uploadedResume;
	}

	public void setUploadedResume(MultipartFile uploadedResume) {
		this.uploadedResume = uploadedResume;
	}

	@Override
	public String toString() {
		return "FresherDetails [fresherId=" + fresherId + ", name=" + name + ", surname=" + surname + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", mobileNo=" + mobileNo + ", projectDescription="
				+ projectDescription + ", resume=" + resume + ", legalConsent=" + legalConsent
				+ ", highestQualification=" + highestQualification + ", educationDetails=" + educationDetails
				+ ", competitives=" + competitives + ", uploadedResume=" + uploadedResume + "]";
	}


	

}
