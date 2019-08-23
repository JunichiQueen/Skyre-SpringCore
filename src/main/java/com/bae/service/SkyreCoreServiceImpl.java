package com.bae.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.SentInfo;
import com.bae.entity.SearchInfo;

@Service
public class SkyreCoreServiceImpl implements SkyreCoreService {

	private JmsTemplate jmsTemplate;

	private RestTemplate restTemplate;

	@Autowired
	public SkyreCoreServiceImpl(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public ResponseEntity<String> getCitizens(String appender) {

		ResponseEntity<String> citizenList = restTemplate
				.exchange("http://localhost:8081/Citizen/getCitizens?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return citizenList;
	}

	@Override
	public ResponseEntity<String> getFinance(String appender) {
		ResponseEntity<String> financeList = restTemplate
				.exchange("http://localhost:8083/Finance/getFinance?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return financeList;
	}

	@Override
	public ResponseEntity<String> getMobile(String appender) {
		ResponseEntity<String> mobileList = restTemplate.exchange("http://localhost:8084/Mobile/getMobile?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return mobileList;
	}

	@Override
	public ResponseEntity<String> getANPR(String appender) {
		ResponseEntity<String> anprList = restTemplate.exchange("http://localhost:8082/ANPR/getANPR?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return anprList;
	}
	
	@Override
	public ResponseEntity<String> getAssociates(String appender) {
		ResponseEntity<String> associateList = restTemplate.exchange("http://localhost:8084/Mobile/getAssociates?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return associateList;
	}
	
	@Override
	public ResponseEntity<String> getVehicleLocation(String appender) {
		ResponseEntity<String> vehicleLocationList = restTemplate.exchange("http://localhost:8082/ANPR/getVehicleLocation?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return vehicleLocationList;
	}

	private void sendToQueue(SearchInfo searchinfo) {
		SentInfo userToStore = new SentInfo(searchinfo);
		System.out.println(searchinfo);
		jmsTemplate.convertAndSend("AccountQueue", userToStore);
	}

	@Override
	public ResponseEntity<String> getTransactions(String appender) {
		ResponseEntity<String> transactionList = restTemplate.exchange("http://localhost:8083/Finance/getTransactions?" + appender,
				HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return transactionList;
	}


}
