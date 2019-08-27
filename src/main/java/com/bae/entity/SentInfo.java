package com.bae.entity;

public class SentInfo {
	
	private String name;
	
	private String time;
	
	private String requestType;
	
	public SentInfo(SearchInfo searchinfo) {
		this.name=searchinfo.getName();
		this.time=searchinfo.getTime();
		this.requestType=searchinfo.getRequestType();
	}
	
	public SentInfo() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

}
