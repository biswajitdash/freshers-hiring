package com.sasken.website.career.model;

public class CompetitiveExam {

	private long competitiveExamId;

	private String examName;

	public long getCompetitiveExamId() {
		return competitiveExamId;
	}

	public void setCompetitiveExamId(long competitiveExamId) {
		this.competitiveExamId = competitiveExamId;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "CompetitiveExam [competitiveExamId=" + competitiveExamId + ", examName=" + examName + "]";
	}


}
