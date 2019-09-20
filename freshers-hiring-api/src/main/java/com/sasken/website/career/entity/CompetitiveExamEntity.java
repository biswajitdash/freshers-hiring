package com.sasken.website.career.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETITIVE_EXAMS")
public class CompetitiveExamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPETITIVE_EXAM_ID")
	private long competitiveExamId;

	@Column(name = "EXAM_NAME")
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
		return "CompetitiveExamEntity [competitiveExamId=" + competitiveExamId + ", examName=" + examName + "]";
	}

	
}
