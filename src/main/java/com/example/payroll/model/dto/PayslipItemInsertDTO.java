package com.example.payroll.model.dto;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.payroll.model.Job;
import com.example.payroll.model.Payslip;

/**
 * Created by yeo on 5/10/2017.
 */
public class PayslipItemInsertDTO {

	private Payslip payslip;
	private Job job;
	private BigDecimal unit;
	private String category;

	public PayslipItemInsertDTO() {
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
