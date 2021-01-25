package za.co.mamamoney.ussdservice.service;
import java.util.HashMap;
import java.util.Map;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public class USSDMenu2Executor implements USSDMenuExecutor {

	/**
	 * @param countryCode
	 * @param localAmount
	 * @return
	 */
	private float convertAmount(int countryCode, float localAmount){
		
	    float convertedAmount = 0.00f;
	    
		if(countryCode == 01) {
			convertedAmount = (localAmount/6.10f);
		}
		else if(countryCode == 02) {
			convertedAmount = (localAmount/42.50f);
		}
		
		return convertedAmount;
	}

	@Override
	public USSDResponse execute(USSDRequest ussdRequest) {
		final Map<String, String> iRequestOptions = ussdRequest.getRequestOptions();
		final int countryCode = Integer.valueOf(iRequestOptions.get("countryCode"));
		final float amount = Float.valueOf(iRequestOptions.get("amount"));
		
		float convertedAmount = convertAmount(countryCode, amount);
		
		Map<String, String> responseData = new HashMap<String, String>();
		responseData.put("convertedAmount", String.valueOf(convertedAmount));
		
		USSDResponse ussdResponse = new USSDResponse();
		ussdResponse.setResponseData(responseData);
		return ussdResponse;
	}

}
