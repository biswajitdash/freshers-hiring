package com.sasken.website.career.model;

public class Competitives {

	private long id;
	private String examName;
	private String marksScorePercentage;
	private String examRank;
	private String yearAppeared;
	private CompetitiveExam competitiveExam;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getMarksScorePercentage() {
		return marksScorePercentage;
	}

	public void setMarksScorePercentage(String marksScorePercentage) {
		this.marksScorePercentage = marksScorePercentage;
	}

	public String getExamRank() {
		return examRank;
	}

	public void setExamRank(String examRank) {
		this.examRank = examRank;
	}

	public String getYearAppeared() {
		return yearAppeared;
	}

	public void setYearAppeared(String yearAppeared) {
		this.yearAppeared = yearAppeared;
	}

	public CompetitiveExam getCompetitiveExam() {
		return competitiveExam;
	}

	public void setCompetitiveExam(CompetitiveExam competitiveExam) {
		this.competitiveExam = competitiveExam;
	}

	@Override
	public String toString() {
		return "Competitives [id=" + id + ", examName=" + examName + ", marksScorePercentage=" + marksScorePercentage
				+ ", examRank=" + examRank + ", yearAppeared=" + yearAppeared + ", competitiveExam=" + competitiveExam
				+ "]";
	}



}
