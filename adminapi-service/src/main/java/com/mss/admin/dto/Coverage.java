package com.mss.admin.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coverage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String code;
	private String value;
	private String coverageType;
	private String innerLimit;
	private String outerLimit;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getInnerLimit() {
		return innerLimit;
	}
	public void setInnerLimit(String innerLimit) {
		this.innerLimit = innerLimit;
	}
	public String getOuterLimit() {
		return outerLimit;
	}
	public void setOuterLimit(String outerLimit) {
		this.outerLimit = outerLimit;
	}
	public String getCoverageType() {
		return coverageType;
	}
	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}
	
}
