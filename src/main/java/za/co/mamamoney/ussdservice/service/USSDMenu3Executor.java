package za.co.mamamoney.ussdservice.service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public class USSDMenu3Executor implements USSDMenuExecutor{

	@Override
	public USSDResponse execute(USSDRequest ussdRequest){
		
		final Map<String, String> iRequestOptions = ussdRequest.getRequestOptions();
		final String senderMSISDN  = ussdRequest.getMsisdn();
		final int countryCode = Integer.valueOf(iRequestOptions.get("countryCode"));
		final float amount = Float.valueOf(iRequestOptions.get("amount"));
		final String recipientMSISDN = iRequestOptions.get("recipientMSISDN");
		final String uuid = UUID.randomUUID().toString();
		
		sendAmountToMSISDN(senderMSISDN, countryCode, amount, recipientMSISDN, uuid);
		
		Map<String, String> responseData = new HashMap<String, String>();
		responseData.put("trackingRef", uuid);
		
		USSDResponse ussdResponse = new USSDResponse();
		ussdResponse.setResponseData(responseData);
		
		return ussdResponse;
	}
	
	private void sendAmountToMSISDN(String senderMSISDN, int countryCode, float amount, String recipientMSISDN, String uuid){
	}
}
