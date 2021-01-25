package za.co.mamamoney.ussdservice.service;
import java.util.HashMap;
import java.util.Map;

import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public class USSDMenu1Executor implements USSDMenuExecutor{

	@Override
	public USSDResponse execute(USSDRequest ussdRequest){
		
		Map<String, String> responseData = new HashMap<String, String>();
		responseData.put("01","Kenya");
		responseData.put("02","Malawi");
		
		USSDResponse ussdResponse = new USSDResponse();
		ussdResponse.setResponseData(responseData);
	
		return ussdResponse;
	}
	
	private boolean validateUSSDRequest(USSDRequest ussdRequest) {
		return true;
	}
}
