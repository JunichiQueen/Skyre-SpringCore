package com.bae.entity;

public class SentInfo {
	
	private String name;
	
	private String time;
	
	public SentInfo(SearchInfo searchinfo) {
		this.name=searchinfo.getName();
		this.time=searchinfo.getTime();
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

}
