package za.co.mamamoney.ussdservice.service;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public class USSDMenu1Executor implements USSDMenuExecutor{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(USSDMenu1Executor.class);

	@Override
	public USSDResponse execute(USSDRequest ussdRequest){
		
		LOGGER.info("Initialized USSDMenu1Executor->execute()");
		
		Map<String, String> responseData = new HashMap<String, String>();
		responseData.put("01","Kenya");
		responseData.put("02","Malawi");
		
		USSDResponse ussdResponse = new USSDResponse();
		ussdResponse.setResponseData(responseData);
		
		LOGGER.info("Exited USSDMenu1Executor->execute()");
		return ussdResponse;
	}
	
}
