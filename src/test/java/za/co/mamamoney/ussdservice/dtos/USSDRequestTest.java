package za.co.mamamoney.ussdservice.dtos;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class USSDRequestTest{

	private USSDRequest ussdRequest;
	
	@Before
	public void setup() {
		ussdRequest = new USSDRequest();
	}
	
	@After
	public void teardown() {
		ussdRequest = null;
	}
	
	@Test
	public void testInitialization() throws Exception{
		assertNotNull(ussdRequest);
	}
}
