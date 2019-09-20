package com.sasken.website.career.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUALIFICATION_WEIGHTAGE")
public class QualificationWeightage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name ="QUALIFICATION")
	private String qualification;

	@Column(name = "WEIGHTAGE")
	private float weightage;
	
	@Column(name = "HIEGHTEST_QUALIFICATION")
	private String highQualification;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public float getWeightage() {
		return weightage;
	}

	public void setWeightage(float weightage) {
		this.weightage = weightage;
	}

	public String getHighQualification() {
		return highQualification;
	}

	public void setHighQualification(String highQualification) {
		this.highQualification = highQualification;
	}

	@Override
	public String toString() {
		return "QualificationWeightage [id=" + id + ", qualification=" + qualification + ", weightage=" + weightage
				+ ", highQualification=" + highQualification + "]";
	}
	
}
