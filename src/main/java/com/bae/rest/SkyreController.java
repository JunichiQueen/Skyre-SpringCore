package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.entity.Cases;
import com.bae.service.SkyreCoreServiceImpl;

@RestController
@RequestMapping("/core")
public class SkyreController {

	private SkyreCoreServiceImpl skyreCoreService;

	@Autowired
	public SkyreController(SkyreCoreServiceImpl skyreCoreService) {
		this.skyreCoreService = skyreCoreService;
	}

	@GetMapping("citizen/{appender}")
	public ResponseEntity<String> getCitizen(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		System.out.println(header);
		return skyreCoreService.getCitizens(appender, header);
	}

	@GetMapping("finance/{appender}")
	public ResponseEntity<String> getFinance(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		return skyreCoreService.getFinance(appender, header);
	}

	@GetMapping("mobile/{appender}")
	public ResponseEntity<String> getMobile(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		return skyreCoreService.getMobile(appender, header);
	}

	@GetMapping("anpr/{appender}")
	public ResponseEntity<String> getANPR(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		return skyreCoreService.getANPR(appender, header);
	}

	@GetMapping("associate/{appender}")
	public ResponseEntity<String> getAssociate(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		return skyreCoreService.getAssociates(appender, header);
	}

	@GetMapping("vehicleLocation/{appender}")
	public ResponseEntity<String> getVehicleLocation(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		return skyreCoreService.getVehicleLocation(appender, header);
	}

	@GetMapping("transactions/{appender}")
	public ResponseEntity<String> getTransactions(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		return skyreCoreService.getTransactions(appender, header);
	}

	@GetMapping("citizenFromRegistration/{appender}")
	public ResponseEntity<String> getCitizenFromRegistration(@PathVariable("appender") String appender,
			@RequestHeader("username") String header) {
		return skyreCoreService.getCitizenFromRegistrationNo(appender, header);
	}
	
	@GetMapping("cases")
	public ResponseEntity<String> getCases() {
		return skyreCoreService.getCases();
	}
	
	@PostMapping("postCase")
	public ResponseEntity<String> postCase(@RequestBody Cases cases,
			@RequestHeader("username") String header) {
		return skyreCoreService.postCases(cases, header);
	}

}
