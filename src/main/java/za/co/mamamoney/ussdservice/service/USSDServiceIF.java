package za.co.mamamoney.ussdservice.service;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public interface USSDServiceIF{
	
	public USSDResponse processRequest(USSDRequest ussdRequest);

}
