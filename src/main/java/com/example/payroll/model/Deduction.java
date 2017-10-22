package com.example.payroll.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by yeo on 5/10/2017.
 */
@Document
public class Deduction {

	@Id
	private Long deductionId;

	@Indexed(unique = true)
	private String code;

	@NotNull(message = "Deduction's name must not be blank.")
	private String name;

	private String description;

	private String invoiceNo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	private String invoiceDate;

	public Deduction() {
	}

	public Long getDeductionId() {
		return deductionId;
	}

	public void setDeductionId(Long deductionId) {
		this.deductionId = deductionId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
}
