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
	
	@GetMapping("citizen/{appender}")
	public ResponseEntity<String> getCitizen(@PathVariable("appender") String appender){
		return skyreCoreService.getCitizens(appender);
	}
	
	@GetMapping("finance/{appender}")
	public ResponseEntity<String> getFinance(@PathVariable("appender") String appender){
		return skyreCoreService.getFinance(appender);
	}
	
	@GetMapping("mobile/{appender}")
	public ResponseEntity<String> getMobile(@PathVariable("appender") String appender){
		return skyreCoreService.getMobile(appender);
	}
	
	@GetMapping("anpr/{appender}")
	public ResponseEntity<String> getANPR(@PathVariable("appender") String appender){
		return skyreCoreService.getANPR(appender);
	}
	
	@GetMapping("associate/{appender}")
	public ResponseEntity<String> getAssociate(@PathVariable("appender") String appender){
		return skyreCoreService.getAssociates(appender);
	}
	
	@GetMapping("vehicleLocation/{appender}")
	public ResponseEntity<String> getVehicleLocation(@PathVariable("appender") String appender){
		return skyreCoreService.getVehicleLocation(appender);
	}
	
	@GetMapping("transactions/{appender}")
	public ResponseEntity<String> getTransactions(@PathVariable("appender") String appender){
		return skyreCoreService.getTransactions(appender);
	}
	
	@GetMapping("citizenFromRegistration/{appender}")
	public ResponseEntity<String> getCitizenFromRegistration(@PathVariable("appender") String appender){
		return skyreCoreService.getCitizenFromRegistrationNo(appender);
	}


}
