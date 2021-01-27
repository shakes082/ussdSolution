package za.co.mamamoney.ussdservice.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

@SpringBootTest
public class MamaMoneyServiceImplTest {
	
	@Autowired
	@Qualifier("mamaMoneyServiceImpl")
	private MamaMoneyServiceIF mamaMoneyServiceImpl;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(mamaMoneyServiceImpl).isNotNull();
	}
	
	@Test
	public void testProcessRequest_01() throws Exception{
		
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(1);
		ussdRequest.setRequestOptions(new HashMap<String, String>());
		
		USSDResponse ussdResponse = mamaMoneyServiceImpl.processRequest(ussdRequest);
		assertEquals(2, ussdResponse.getResponseData().size());
	}
	
	@Test
	public void testProcessRequest_02() throws Exception{
		
		Map<String, String> requestOptions = new HashMap<String, String>();
		requestOptions.put("countryCode", "01");
		requestOptions.put("amount", "100.00");
		
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(2);
		ussdRequest.setRequestOptions(requestOptions);
		
		USSDResponse ussdResponse = mamaMoneyServiceImpl.processRequest(ussdRequest);
		assertEquals(1, ussdResponse.getResponseData().size());
	}
	
	@Test
	public void testProcessRequest_03() throws Exception{
		
		Map<String, String> requestOptions = new HashMap<String, String>();
		requestOptions.put("countryCode", "01");
		requestOptions.put("amount", "100.00");
		requestOptions.put("recipientMSISDN", "27829622222");
		
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(3);
		ussdRequest.setRequestOptions(requestOptions);
		
		USSDResponse ussdResponse = mamaMoneyServiceImpl.processRequest(ussdRequest);
		assertEquals(1, ussdResponse.getResponseData().size());
	}
	
	@Test
	public void testProcessRequest_04() throws Exception{
		
		Map<String, String> requestOptions = new HashMap<String, String>();
		requestOptions.put("trackingRef", "01");
		
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(4);
		ussdRequest.setRequestOptions(requestOptions);
		
		USSDResponse ussdResponse = mamaMoneyServiceImpl.processRequest(ussdRequest);
		assertEquals(1, ussdResponse.getResponseData().size());
	}

}
