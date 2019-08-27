package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.SearchInfo;
import com.bae.entity.SentInfo;
import com.bae.util.URLC;

@Service
public class SkyreCoreServiceImpl implements SkyreCoreService {

	private JmsTemplate jmsTemplate;

	private RestTemplate restTemplate;

	private URLC urlc;
  
	@Autowired
	public SkyreCoreServiceImpl(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public ResponseEntity<String> getCitizens(String appender) {
		
		ResponseEntity<String> citizenList = restTemplate.exchange(urlc.CITIZEN_URL + "/Citizen/getCitizens?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("Citizen");
		sendToQueue(newSearch);
		return citizenList;
	}

	@Override
	public ResponseEntity<String> getFinance(String appender) {

		ResponseEntity<String> financeList = restTemplate.exchange(urlc.FINANCE_URL + "/Finance/getFinance?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("Finance");
		sendToQueue(newSearch);
		return financeList;
	}
  
	@Override
	public ResponseEntity<String> getMobile(String appender) {
		ResponseEntity<String> mobileList = restTemplate.exchange(urlc.MOBILE_URL + "/Mobile/getMobile?" + appender, HttpMethod.GET, null, String.class);

		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("Mobile");
		sendToQueue(newSearch);
		return mobileList;
	}

	@Override
	public ResponseEntity<String> getANPR(String appender) {

		ResponseEntity<String> anprList = restTemplate.exchange(urlc.VEHICLE_URL+ "/ANPR/getANPR?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("ANPR");
		sendToQueue(newSearch);
		return anprList;
	}
	
	@Override
	public ResponseEntity<String> getAssociates(String appender) {
		ResponseEntity<String> associateList = restTemplate.exchange("http://localhost:8084/Mobile/getAssociates?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("Associates");
		sendToQueue(newSearch);
		return associateList;
	}
	
	@Override
	public ResponseEntity<String> getVehicleLocation(String appender) {
		ResponseEntity<String> vehicleLocationList = restTemplate.exchange("http://localhost:8082/ANPR/getVehicleLocation?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("VehicleLocation");
		sendToQueue(newSearch);
		return vehicleLocationList;
	}
	
	@Override
	public ResponseEntity<String> getTransactions(String appender) {
		ResponseEntity<String> transactionList = restTemplate.exchange("http://localhost:8083/Finance/getTransactions?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("Transactions");
		sendToQueue(newSearch);
		return transactionList;
	}

	@Override
	public ResponseEntity<String> getCitizenFromRegistrationNo(String appender) {
		ResponseEntity<String> citizenRegList = restTemplate.exchange("http://localhost:8082/ANPR/getCitizenFromRegistration?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		newSearch.setRequestType("Citizen(Reg)");
		sendToQueue(newSearch);
		return citizenRegList;
	}

	private void sendToQueue(SearchInfo searchinfo) {
		SentInfo userToStore = new SentInfo(searchinfo);
		System.out.println(searchinfo);
		jmsTemplate.convertAndSend("AccountQueue", userToStore);
	}

}
