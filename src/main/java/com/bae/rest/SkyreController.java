package com.bae.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.service.SkyreCoreServiceImpl;

@RestController
@RequestMapping("/core")
public class SkyreController {
	
	private SkyreCoreServiceImpl skyreCoreService;
	
	@Autowired
	public SkyreController(SkyreCoreServiceImpl skyreCoreService) {
		this.skyreCoreService=skyreCoreService;
	}
	
	@GetMapping("/{appender}")
	public ResponseEntity<String> getCitizen(@PathVariable("appender") String appender){
		return skyreCoreService.getCitizens(appender);
	}

}
