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
public class USSDMenu2ExecutorTest {
	
	@Autowired
	private USSDMenu2Executor uSSDMenu2Executor;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(uSSDMenu2Executor).isNotNull();
	}
	
	@Test
	public void testExecute01() throws Exception{
		
		Map<String, String> requestOptions = new HashMap<String, String>();
		requestOptions.put("countryCode", "01");
		requestOptions.put("amount", "100.00");
		
		USSDRequest ussdRequest = new USSDRequest();
		ussdRequest.setMsisdn("27829611111");
		ussdRequest.setUserEntry(1);
		ussdRequest.setRequestOptions(requestOptions);
		
		USSDResponse ussdResponse = uSSDMenu2Executor.execute(ussdRequest);
		assertEquals(1, ussdResponse.getResponseData().size());
	}

}
