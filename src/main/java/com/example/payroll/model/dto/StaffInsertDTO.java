package com.example.payroll.model.dto;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yeo on 5/10/2017.
 */
public class StaffInsertDTO {
	private String icNo;
	private String staffCode;
	private String name;
	private BigDecimal basicPay;
	private String epfNo;
	private BigDecimal epfRate;
	private String joinDate;
	private String terminationDate;
	private String workExp;
	private String status;

	public StaffInsertDTO() {
	}

	public String getIcNo() {
		return icNo;
	}

	public void setIcNo(String icNo) {
		this.icNo = icNo;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(BigDecimal basicPay) {
		this.basicPay = basicPay;
	}

	public String getEpfNo() {
		return epfNo;
	}

	public void setEpfNo(String epfNo) {
		this.epfNo = epfNo;
	}

	public BigDecimal getEpfRate() {
		return epfRate;
	}

	public void setEpfRate(BigDecimal epfRate) {
		this.epfRate = epfRate;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(String terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getWorkExp() {
		return workExp;
	}

	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
