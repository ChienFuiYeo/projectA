package com.example.payroll.model.dto;

import java.math.BigDecimal;

/**
 * Created by yeo on 5/14/2017.
 */
public class JobInsertDTO {

	private String jobCode;
	private String jobDescription;
	private BigDecimal rate;
	private BigDecimal oum;
	private String remarks;

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getOum() {
		return oum;
	}

	public void setOum(BigDecimal oum) {
		this.oum = oum;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
