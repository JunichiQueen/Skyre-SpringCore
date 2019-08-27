package com.bae.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

import com.bae.entity.Citizen;
import com.bae.entity.SearchInfo;


@RunWith(MockitoJUnitRunner.Silent.class) 
public class SkyreCoreServiceImplTests {
	
	@InjectMocks
	SkyreCoreServiceImpl skyreCore;
	
	@Mock
	RestTemplate restTemplate;
	
	@Mock
	JmsTemplate jmsTemplate;
	
	private static final Citizen MOCK_CITIZEN = new Citizen((long) 1, "Bob", "Smith", "2 Dud Lane", "12/01/23", "Uganda", "Female");
	
	private static final String MOCK_APPENDER = "forenames=Bob";
	
	@Test
	public void getCitizensTest() {
		String citizenList = "{ name: Bob, surname: Smith }";
		ResponseEntity<String> response = new ResponseEntity<String>(citizenList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8081/Citizen/getCitizens?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getCitizens(MOCK_APPENDER);
		assertEquals(response, something);
	}
	
	@Test
	public void getFinanceTest() {
		String financeList = "{ accountName: BobAccount, bank: HSBC }";
		ResponseEntity<String> response = new ResponseEntity<String>(financeList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8083/Finance/getFinance?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getFinance(MOCK_APPENDER);
		assertEquals(response, something);
	}
	
	@Test
	public void getMobileTest() {
		String mobileList = "{ phoneNumber: 01452865786, network: O2 }";
		ResponseEntity<String> response = new ResponseEntity<String>(mobileList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8084/Mobile/getMobile?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getMobile(MOCK_APPENDER);
		assertEquals(response, something);
	}
	
	@Test
	public void getANPRTest() {
		String anprList = "{ vehicleRegistrationNo: 213, make: Bugatti }";
		ResponseEntity<String> response = new ResponseEntity<String>(anprList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8082/ANPR/getANPR?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getANPR(MOCK_APPENDER);
		assertEquals(response, something);
	}
	
	@Test
	public void getAssociatesTest() {
		String associatesList = "{ name: Delvin, surname: Mallory }";
		ResponseEntity<String> response = new ResponseEntity<String>(associatesList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8084/Mobile/getAssociates?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getAssociates(MOCK_APPENDER);
		assertEquals(response, something);
	}
	
	@Test
	public void getVehicleLocationTest() {
		String vehicleLocationList = "{ latitude: 1863, longitude: 7853 }";
		ResponseEntity<String> response = new ResponseEntity<String>(vehicleLocationList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8082/ANPR/getVehicleLocation?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getVehicleLocation(MOCK_APPENDER);
		assertEquals(response, something);
	}
	
	@Test
	public void getTransactionsTest() {
		String transactionsList = "{ latitude: 1342, longitude: 7659 }";
		ResponseEntity<String> response = new ResponseEntity<String>(transactionsList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8083/Finance/getTransactions?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getTransactions(MOCK_APPENDER);
		assertEquals(response, something);
	}
	
	@Test
	public void getCitizenFromRegistrationNoTest() {
		String citizenList = "{ name: Bob, surname: Smith }";
		ResponseEntity<String> response = new ResponseEntity<String>(citizenList, HttpStatus.OK);
		doReturn(response)
		.when(restTemplate).exchange("http://localhost:8082/ANPR/getCitizenFromRegistration?" + MOCK_APPENDER, HttpMethod.GET, null, String.class);
		doThrow(NullPointerException.class).when(jmsTemplate).convertAndSend(MOCK_CITIZEN);
		ResponseEntity<String> something = skyreCore.getCitizenFromRegistrationNo(MOCK_APPENDER);
		assertEquals(response, something);
	}

}
