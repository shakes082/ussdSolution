package za.co.mamamoney.ussdservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

@SpringBootTest
public class USSDMenu2ProcessorTest {

	@Autowired
	private USSDMenu2Processor uSSDMenu2Processor;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(uSSDMenu2Processor).isNotNull();
	}
	
	@Test
	public void testExecute01() throws Exception{
		Map<String, String> requestOptions = new HashMap<String, String>();
		requestOptions.put("countryCode", "01");
		requestOptions.put("amount", "100.00");
		
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(2);
		ussdRequest.setRequestOptions(requestOptions);
		
		USSDResponse ussdResponse = uSSDMenu2Processor.processRequest(ussdRequest);
		assertEquals(1, ussdResponse.getResponseData().size());
	}

}
