package com.sasken.website.career.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXAMS")
public class ExamEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EXAM_ID")
	private long examId;

	@Column(name = "EXAM_NAME")
	private String examName;
	
	@Column(name = "LABEL")
	private String label;


	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}


	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "ExamEntity [examId=" + examId + ", examName=" + examName + ", label=" + label + "]";
	}

	
	
}
