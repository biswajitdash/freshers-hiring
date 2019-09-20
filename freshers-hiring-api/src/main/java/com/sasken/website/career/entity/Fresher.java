package com.sasken.website.career.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FRESHERS")
public class Fresher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRESHER_ID")
	private long fresherId;

	@Column(name = "FIRST_NAME", length = 200)
	private String name;

	@Column(name = "LAST_NAME", length = 200)
	private String surname;

	@Column(name = "DATE_OF_BIRTH", length = 50)
	private String dateOfBirth;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@Column(name = "MOBILE_NO", length = 20)
	private String mobileNo;

	@Lob
	@Column(name = "PROJECT_DESC")
	private String projectDescription;

	@Column(name = "RESUME", length = 200)
	private String resume;

	@Column(name = "LEGAL_CONSENT")
	private boolean legalConsent;
	
	@Column(name = "HIGHEST_QUALIFICATION")
	private String highestQualification;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FRESHER_ID")
	private Set<EducationDetailsEntity> educationDetails = new HashSet<EducationDetailsEntity>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FRESHER_ID",  nullable = true)
	private Set<CompetitivesEntity> competitives = new HashSet<CompetitivesEntity>();

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

	public Set<EducationDetailsEntity> getEducationDetails() {
		return educationDetails;
	}

	public void setEducationDetails(Set<EducationDetailsEntity> educationDetails) {
		this.educationDetails = educationDetails;
	}

	public Set<CompetitivesEntity> getCompetitives() {
		return competitives;
	}

	public void setCompetitives(Set<CompetitivesEntity> competitives) {
		this.competitives = competitives;
	}

	@Override
	public String toString() {
		return "Fresher [fresherId=" + fresherId + ", name=" + name + ", surname=" + surname + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", mobileNo=" + mobileNo + ", projectDescription="
				+ projectDescription + ", resume=" + resume + ", legalConsent=" + legalConsent
				+ ", highestQualification=" + highestQualification + ", educationDetails=" + educationDetails
				+ ", competitives=" + competitives + "]";
	}


}
