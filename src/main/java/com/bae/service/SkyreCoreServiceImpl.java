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
	
	public static final String CITIZEN_URL = "http://localhost:8081";
	public static final String FINANCE_URL = "http://localhost:8083";
	public static final String MOBILE_URL = "http://localhost:8084";
	public static final String VEHICLE_URL = "http://localhost:8082";
	
	@Autowired
	public SkyreCoreServiceImpl (RestTemplate restTemplate, JmsTemplate jmsTemplate){
		this.restTemplate=restTemplate;
		this.jmsTemplate=jmsTemplate;
	}

	@Override
	public ResponseEntity<String> getCitizens(String appender) {
		
		ResponseEntity<String> citizenList = restTemplate.exchange(CITIZEN_URL + "/Citizen/getCitizens?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return citizenList;
	}

	@Override
	public ResponseEntity<String> getFinance(String appender) {
		ResponseEntity<String> financeList = restTemplate.exchange(FINANCE_URL + "/Finance/getFinance?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return financeList;
	}
	
	@Override
	public ResponseEntity<String> getMobile(String appender) {
		ResponseEntity<String> mobileList = restTemplate.exchange(MOBILE_URL + "/Mobile/getMobile?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return mobileList;
	}

	@Override
	public ResponseEntity<String> getANPR(String appender) {
		ResponseEntity<String> anprList = restTemplate.exchange(VEHICLE_URL+ "/ANPR/getANPR?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return anprList;
	}
	
    private void sendToQueue(SearchInfo searchinfo){
        SentInfo userToStore =  new SentInfo(searchinfo);
        System.out.println(searchinfo);
        jmsTemplate.convertAndSend("AccountQueue", userToStore);
    }

}
