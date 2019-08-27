package com.bae.entity;

import java.text.SimpleDateFormat;

public class SearchInfo {
	
	private String name;
	
	private String time;
	
	private String requestType;
	
	public SearchInfo(String name, String time, String requestType) {
		this.name=name;
		this.time=time;
		this.requestType=requestType;
	}
	
	public SearchInfo() {
		
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

	public void setTime() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd:HH.mm.ss").format(new java.util.Date());
		this.time = timeStamp;
	}
	
	public String getRequestType() {
		return requestType;
	}
	
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
}
