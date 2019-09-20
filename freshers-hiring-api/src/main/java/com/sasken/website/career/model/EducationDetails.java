package com.sasken.website.career.model;

public class EducationDetails {

	private long id;
	private String marks;
	private String marksPercentage;
	private String gradeSystem;
	private String yearPassing;
	private Exam exam;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Override
	public String toString() {
		return "EducationDetails [id=" + id + ", marks=" + marks + ", marksPercentage=" + marksPercentage
				+ ", gradeSystem=" + gradeSystem + ", yearPassing=" + yearPassing + ", exam=" + exam + "]";
	}
	
	

}
