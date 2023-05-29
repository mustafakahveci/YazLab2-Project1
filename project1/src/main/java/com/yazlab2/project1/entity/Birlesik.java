package com.yazlab2.project1.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class Birlesik {
	
	@MongoId
	private String id;
	private String text;
	private Double seconds;
	
	public Birlesik() {
		super();
	}

	public Birlesik(String id, String text,Double seconds) {
		super();
		this.id = id;
		this.text = text;
		this.seconds = seconds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getSeconds() {
		return seconds;
	}

	public void setSeconds(double seconds) {
		this.seconds = seconds;
	}
	
	
	
	
	
	
}
