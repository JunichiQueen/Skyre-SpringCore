package com.bae.service;

import org.springframework.http.ResponseEntity;

import com.bae.entity.Cases;

public interface SkyreCoreService {
	
	public ResponseEntity<String> getCitizens(String appender, String header);
	
	public ResponseEntity<String> getFinance(String appender, String header);
	
	public ResponseEntity<String> getMobile(String appender, String header);
	
	public ResponseEntity<String> getANPR(String appender, String header);
	
	public ResponseEntity<String> getAssociates(String appender, String header);
	
	public ResponseEntity<String> getVehicleLocation(String appender, String header);
	
	public ResponseEntity<String> getTransactions(String appender, String header);
	
	public ResponseEntity<String> getCitizenFromRegistrationNo(String appender, String header);
	
	public ResponseEntity<String> getCases();
	
	public ResponseEntity<String> postCases(Cases cases,  String header);
}
