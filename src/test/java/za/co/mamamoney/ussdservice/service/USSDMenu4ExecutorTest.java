package za.co.mamamoney.ussdservice.service;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

@SpringBootTest
public class USSDMenu4ExecutorTest {

	/**
	 * 
	 */
	@Autowired
	private USSDMenu4Executor uSSDMenu4Executor;
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void contextLoads() throws Exception {
		assertThat(uSSDMenu4Executor).isNotNull();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testExecute01() throws Exception{
		
		Map<String, String> requestOptions = new HashMap<String, String>();
		requestOptions.put("trackingRef", "01");
		
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(4);
		ussdRequest.setRequestOptions(requestOptions);
		
		USSDResponse ussdResponse = uSSDMenu4Executor.execute(ussdRequest);
		assertEquals(1, ussdResponse.getResponseData().size());
	}
	
	
}
