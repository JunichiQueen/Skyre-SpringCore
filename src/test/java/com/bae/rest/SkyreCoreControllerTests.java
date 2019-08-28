package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bae.entity.Cases;
import com.bae.service.SkyreCoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SkyreCoreControllerTests {
	
	@InjectMocks
	SkyreController skyreController;
	
	@Mock
	SkyreCoreServiceImpl skyreCoreServiceImpl;
	
	private static final String MOCK_APPENDER = "forenames=Bob";
	
	@Test
	public void getCitizenTest() {
		String citizenList = "{ name: Bob, surname: Smith }";
		ResponseEntity<String> response = new ResponseEntity<String>(citizenList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getCitizens(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getCitizen(MOCK_APPENDER,"");
		assertEquals(response, something);
	}
	
	@Test
	public void getFinanceTest() {
		String financeList = "{ accountName: BobAccount, bank: HSBC }";
		ResponseEntity<String> response = new ResponseEntity<String>(financeList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getFinance(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getFinance(MOCK_APPENDER, "");
		assertEquals(response, something);
	}
	
	@Test
	public void getMobileTest() {
		String mobileList = "{ phoneNumber: 01452865786, network: O2 }";
		ResponseEntity<String> response = new ResponseEntity<String>(mobileList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getMobile(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getMobile(MOCK_APPENDER, "");
		assertEquals(response, something);
	}
	
	@Test
	public void getANPRTest() {
		String anprList = "{ vehicleRegistrationNo: 213, make: Bugatti }";
		ResponseEntity<String> response = new ResponseEntity<String>(anprList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getANPR(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getANPR(MOCK_APPENDER, "");
		assertEquals(response, something);
	}
	
	@Test
	public void getAssociatesTest() {
		String associatesList = "{ name: Delvin, surname: Mallory }";
		ResponseEntity<String> response = new ResponseEntity<String>(associatesList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getAssociates(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getAssociate(MOCK_APPENDER, "");
		assertEquals(response, something);
	}
	
	@Test
	public void getVehicleLocation() {
		String vehicleLocationList = "{ latitude: 1863, longitude: 7853 }";
		ResponseEntity<String> response = new ResponseEntity<String>(vehicleLocationList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getVehicleLocation(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getVehicleLocation(MOCK_APPENDER, "");
		assertEquals(response, something);
	}
	
	@Test
	public void getTransactions() {
		String transactionsList = "{ latitude: 1342, longitude: 7659 }";
		ResponseEntity<String> response = new ResponseEntity<String>(transactionsList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getTransactions(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getTransactions(MOCK_APPENDER, "");
		assertEquals(response, something);
	}
	
	@Test
	public void getCitizenFromRegistration() {
		String citizenList = "{ name: Bob, surname: Smith }";
		ResponseEntity<String> response = new ResponseEntity<String>(citizenList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getCitizenFromRegistrationNo(MOCK_APPENDER, "");
		ResponseEntity<String> something = skyreController.getCitizenFromRegistration(MOCK_APPENDER, "");
		assertEquals(response, something);
	}
	
	@Test
	public void getCasesTest() {
		String casesList = "{ name: Steven, surname: Stevenson }";
		ResponseEntity<String> response = new ResponseEntity<String>(casesList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).getCases();
		ResponseEntity<String> something = skyreController.getCases();
		assertEquals(response, something);
	}
	
	@Test
	public void postCaseTest() {
		String casesList = "{ name: Steven, surname: Stevenson }";
		Cases cases1 = new Cases();
		ResponseEntity<String> response = new ResponseEntity<String>(casesList, HttpStatus.OK);
		doReturn(response)
		.when(skyreCoreServiceImpl).postCases(cases1, "");
		ResponseEntity<String> something = skyreController.postCase(cases1, "");
		assertEquals(response, something);
	}

}
