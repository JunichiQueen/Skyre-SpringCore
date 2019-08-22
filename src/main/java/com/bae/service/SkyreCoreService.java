package com.bae.service;

import org.springframework.http.ResponseEntity;

public interface SkyreCoreService {
	
	public ResponseEntity<String> getCitizens(String appender);
	
	public ResponseEntity<String> getFinance(String appender);
	
	public ResponseEntity<String> getMobile(String appender);
	
	public ResponseEntity<String> getANPR(String appender);
	
	public ResponseEntity<String> getAssociates(String appender);
	
	
}
