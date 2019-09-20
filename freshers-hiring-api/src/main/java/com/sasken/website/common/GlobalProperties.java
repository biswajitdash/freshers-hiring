package com.sasken.website.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:global.properties")
public class GlobalProperties {

	@Value("${percentage-cutoff}")
	private String percentageCutoff;
	
	@Value("${to-email-ids-hr}")
	private String toEmailIdsHr;
	
	@Value("${cc-email-ids-hr}")
	private String ccEmailIdsHr;
	
	@Value("${from-email-id}")
	private String fromEmailId;
	
	@Value("${email-subject-hr}")
	private String emailSubHr;
	
	@Value("${email-subject-candidate}")
	private String emailSubCandidate;
	
	@Value("${resume-upload-dir}")
	private String resumeUploadDir;


	public String getPercentageCutoff() {
		return percentageCutoff;
	}

	public void setPercentageCutoff(String percentageCutoff) {
		this.percentageCutoff = percentageCutoff;
	}

	public String getToEmailIdsHr() {
		return toEmailIdsHr;
	}

	public void setToEmailIdsHr(String toEmailIdsHr) {
		this.toEmailIdsHr = toEmailIdsHr;
	}

	public String getCcEmailIdsHr() {
		return ccEmailIdsHr;
	}

	public void setCcEmailIdsHr(String ccEmailIdsHr) {
		this.ccEmailIdsHr = ccEmailIdsHr;
	}

	public String getFromEmailId() {
		return fromEmailId;
	}

	public void setFromEmailId(String fromEmailId) {
		this.fromEmailId = fromEmailId;
	}

	public String getEmailSubHr() {
		return emailSubHr;
	}

	public void setEmailSubHr(String emailSubHr) {
		this.emailSubHr = emailSubHr;
	}

	public String getEmailSubCandidate() {
		return emailSubCandidate;
	}

	public void setEmailSubCandidate(String emailSubCandidate) {
		this.emailSubCandidate = emailSubCandidate;
	}

	public String getResumeUploadDir() {
		return resumeUploadDir;
	}

	public void setResumeUploadDir(String resumeUploadDir) {
		this.resumeUploadDir = resumeUploadDir;
	}


	
	
	
}
