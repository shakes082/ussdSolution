package za.co.mamamoney.ussdservice.service;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public abstract class USSDMenuProcessor{

	private USSDMenuExecutor ussdMenuExecutor;
	
	public USSDMenuProcessor(USSDMenuExecutor ussdMenuExecutor) {
	      this.ussdMenuExecutor = ussdMenuExecutor;
	}
	
	public USSDResponse processRequest(USSDRequest ussdRequest) {
		return ussdMenuExecutor.execute(ussdRequest);
	}
}
