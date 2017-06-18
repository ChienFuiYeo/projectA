package com.example.payroll.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by yeo on 5/10/2017.
 */
@Document
public class Payslip {

	@Id
	private Long payslipId;

	@Indexed(unique = true)
	private String payslipNo;

	@Indexed(unique = true)
	private Branch branch;

	@Indexed(unique = true)
	private Staff staff;

	public Payslip() {
	}

	public Long getPayslipId() {
		return payslipId;
	}

	public void setPayslipId(Long payslipId) {
		this.payslipId = payslipId;
	}

	public String getPayslipNo() {
		return payslipNo;
	}

	public void setPayslipNo(String payslipNo) {
		this.payslipNo = payslipNo;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}
