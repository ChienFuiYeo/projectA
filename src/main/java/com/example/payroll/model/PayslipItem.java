package com.example.payroll.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yeo on 5/10/2017.
 */
@Document
public class PayslipItem {

	@Id
	private Long payslipItemId;

	@Indexed(unique = true)
	private Payslip payslip;

	@Indexed(unique = true)
	private Job job;

	@Indexed(unique = true)
	private BigDecimal unit;

	private String category;

	public PayslipItem() {
	}

	public Long getPayslipItemId() {
		return payslipItemId;
	}

	public void setPayslipItemId(Long payslipItemId) {
		this.payslipItemId = payslipItemId;
	}

	public Payslip getPayslip() {
		return payslip;
	}

	public void setPayslip(Payslip payslip) {
		this.payslip = payslip;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public BigDecimal getUnit() {
		return unit;
	}

	public void setUnit(BigDecimal unit) {
		this.unit = unit;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
