package za.co.mamamoney.ussdservice.dtos;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class USSDResponseTest{
	
	private USSDResponse ussdResponse;
	
	@Before
	public void setup() {
		ussdResponse = new USSDResponse();
	}
	
	@After
	public void teardown() {
		ussdResponse = null;
	}
	
	@Test
	public void testInitialization() throws Exception{
		assertNotNull(ussdResponse);
	}
	
	
	
}
