package za.co.mamamoney.ussdservice.dtos;
import java.util.Map;


public final class USSDResponse{

	Map<String, String> responseData;
	
	public USSDResponse() {
	}

	public USSDResponse(Map<String, String> responseData) {
		super();
		this.responseData = responseData;
	}

	public Map<String, String> getResponseData() {
		return responseData;
	}

	public void setResponseData(Map<String, String> responseData) {
		this.responseData = responseData;
	}
}
