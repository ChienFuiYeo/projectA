package com.example.payroll.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by yeo on 5/10/2017.
 */
@Document
public class Sequence {

	@Id
	private String id;

	private Long seq;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}
}
