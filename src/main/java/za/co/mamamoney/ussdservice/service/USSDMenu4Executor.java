package za.co.mamamoney.ussdservice.service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public class USSDMenu4Executor implements USSDMenuExecutor{

	@Override
	public USSDResponse execute(USSDRequest ussdRequest){
		final Map<String, String> iRequestOptions = ussdRequest.getRequestOptions();
		final String senderMSISDN  = ussdRequest.getMsisdn();
		final String trackingRef = iRequestOptions.get("trackingRef");
		
		String trackingStatus = getRemittanceStatus(senderMSISDN, trackingRef);
		
		Map<String, String> responseData = new HashMap<String, String>();
		responseData.put("remittanceStatus",trackingStatus);
		
		USSDResponse ussdResponse = new USSDResponse();
		ussdResponse.setResponseData(responseData);
		
		return ussdResponse;
	}
	
	String getRemittanceStatus(String senderMSISDN, String trackingRef) {
		return "Processing Request";
	}

}
