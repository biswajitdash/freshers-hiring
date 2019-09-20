package com.sasken.website.career.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FRESHER_COMPETITIVES")
public class CompetitivesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "MARKS_SCORE_PERCENTAGE")
	private String marksScorePercentage;

	@Column(name = "EXAM_RANK")
	private String examRank;

	@Column(name = "YEAR_APPEARED")
	private String yearAppeared;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "COMPETITIVE_EXAM_ID")
	private CompetitiveExamEntity competitiveExam;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public CompetitiveExamEntity getCompetitiveExam() {
		return competitiveExam;
	}

	public void setCompetitiveExam(CompetitiveExamEntity competitiveExam) {
		this.competitiveExam = competitiveExam;
	}

	@Override
	public String toString() {
		return "CompetitivesEntity [id=" + id + ", marksScorePercentage=" + marksScorePercentage + ", examRank="
				+ examRank + ", yearAppeared=" + yearAppeared + ", competitiveExam=" + competitiveExam + "]";
	}
	
}
