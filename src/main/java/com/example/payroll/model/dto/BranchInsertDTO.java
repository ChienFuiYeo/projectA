package com.example.payroll.model.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yeo on 5/10/2017.
 */
public class BranchInsertDTO {

	@Indexed(unique = true)
	private String branchCode;

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
}
