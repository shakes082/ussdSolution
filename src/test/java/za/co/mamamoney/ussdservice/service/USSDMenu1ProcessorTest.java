package za.co.mamamoney.ussdservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

@SpringBootTest
public class USSDMenu1ProcessorTest {
	
	@Autowired
	private USSDMenu1Processor uSSDMenu1Processor;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(uSSDMenu1Processor).isNotNull();
	}
	
	@Test
	public void testExecute01() throws Exception{
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(1);
		ussdRequest.setRequestOptions(new HashMap<String, String>());
		
		USSDResponse ussdResponse = uSSDMenu1Processor.processRequest(ussdRequest);
		assertEquals(2, ussdResponse.getResponseData().size());
	}

}
