package com.sasken.website.career.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FRESHER_EDUCATIONS")
public class EducationDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name= "EXAM_ID")
	private ExamEntity exam;
	
	private String marks;
	private String marksPercentage;
	private String gradeSystem;
	private String yearPassing;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public ExamEntity getExam() {
		return exam;
	}

	public void setExam(ExamEntity exam) {
		this.exam = exam;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getMarksPercentage() {
		return marksPercentage;
	}

	public void setMarksPercentage(String marksPercentage) {
		this.marksPercentage = marksPercentage;
	}

	public String getGradeSystem() {
		return gradeSystem;
	}

	public void setGradeSystem(String gradeSystem) {
		this.gradeSystem = gradeSystem;
	}

	public String getYearPassing() {
		return yearPassing;
	}

	public void setYearPassing(String yearPassing) {
		this.yearPassing = yearPassing;
	}

	@Override
	public String toString() {
		return "EducationDetailsEntity [id=" + id + ", exam=" + exam + ", marks=" + marks + ", marksPercentage="
				+ marksPercentage + ", gradeSystem=" + gradeSystem + ", yearPassing=" + yearPassing + "]";
	}


	

}
