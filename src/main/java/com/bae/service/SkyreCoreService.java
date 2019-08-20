package com.bae.service;

import org.springframework.http.ResponseEntity;

public interface SkyreCoreService {
	
	public ResponseEntity<String> getCitizens(String appender);

}
