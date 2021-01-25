package za.co.mamamoney.ussdservice.dtos;
import java.util.HashMap;
import java.util.Map;

public final class USSDResponse{

	Map<String, String> responseData = new HashMap<String, String>();
	
	public USSDResponse(){
	}

	public Map<String, String> getResponseData() {
		return responseData;
	}

	public void setResponseData(Map<String, String> responseData) {
		this.responseData = responseData;
	}
	
}
