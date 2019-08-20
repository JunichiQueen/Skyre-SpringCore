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
	public SkyreCoreServiceImpl (RestTemplate restTemplate, JmsTemplate jmsTemplate){
		this.restTemplate=restTemplate;
		this.jmsTemplate=jmsTemplate;
	}

	@Override
	public ResponseEntity<String> getCitizens(String appender) {
		
		ResponseEntity<String> citizenList = restTemplate.exchange("http://localhost:8081/Citizen/getCitizens?" + appender, HttpMethod.GET, null, String.class);
		SearchInfo newSearch = new SearchInfo();
		newSearch.setTime();
		sendToQueue(newSearch);
		return citizenList;
	}
	
    private void sendToQueue(SearchInfo searchinfo){
        SentInfo userToStore =  new SentInfo(searchinfo);
        System.out.println(searchinfo);
        jmsTemplate.convertAndSend("AccountQueue", userToStore);
    }

}
