package com.example.payroll.model.dto;

import com.example.payroll.model.PayslipItem;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.payroll.model.Branch;
import com.example.payroll.model.Staff;

import java.util.List;

/**
 * Created by yeo on 5/10/2017.
 */
public class PayslipInsertDTO {

	private String payslipNo;
	private Branch branch;
	private Staff staff;

	public PayslipInsertDTO() {
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
