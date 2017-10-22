package com.example.payroll.exception;

/**
 * Created by yeo on 9/17/2017.
 */
public class ErrorMessage {

	private String code;
	private String description;

    public ErrorMessage(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
