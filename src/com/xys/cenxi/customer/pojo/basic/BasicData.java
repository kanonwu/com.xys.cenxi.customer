package com.xys.cenxi.customer.pojo.basic;

public class BasicData {

	private String code;
	
	private String name;
	
	private String value;
	
	public BasicData(String code, String name){
		this.code = code;
		this.name = name;
	}
	
	public BasicData() {
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
