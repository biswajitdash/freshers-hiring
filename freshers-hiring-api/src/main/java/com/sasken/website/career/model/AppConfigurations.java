package com.sasken.website.career.model;

import java.util.List;

public class AppConfigurations {

	List<Exam> exams;
	List<CompetitiveExam> competitiveExams;
	List<Exam> highestQualifications;
	int initialYear;
	int maxYears;

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<CompetitiveExam> getCompetitiveExams() {
		return competitiveExams;
	}

	public void setCompetitiveExams(List<CompetitiveExam> competitiveExams) {
		this.competitiveExams = competitiveExams;
	}

	public List<Exam> getHighestQualifications() {
		return highestQualifications;
	}

	public void setHighestQualifications(List<Exam> highestQualifications) {
		this.highestQualifications = highestQualifications;
	}

	public int getInitialYear() {
		return initialYear;
	}

	public void setInitialYear(int initialYear) {
		this.initialYear = initialYear;
	}

	public int getMaxYears() {
		return maxYears;
	}

	public void setMaxYears(int maxYears) {
		this.maxYears = maxYears;
	}
	
	

}
