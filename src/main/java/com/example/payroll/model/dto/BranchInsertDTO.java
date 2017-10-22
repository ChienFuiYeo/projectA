package com.example.payroll.model.dto;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Created by yeo on 5/10/2017.
 */
public class BranchInsertDTO {

	@Indexed(unique = true)
	private String branchCode;

	private String branchName;

	private String branchDescription;

	public BranchInsertDTO() {
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchDescription() {
		return branchDescription;
	}

	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
}
