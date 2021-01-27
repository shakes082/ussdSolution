package za.co.mamamoney.ussdservice.dtos;
import static org.junit.Assert.assertNotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class USSDRequestTest{

	@Autowired
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
