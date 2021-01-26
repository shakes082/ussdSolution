package za.co.mamamoney.ussdservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

public abstract class USSDMenuProcessor{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(
					USSDMenuProcessor.class);
	
	private USSDMenuExecutor ussdMenuExecutor;
	
	public USSDMenuProcessor(USSDMenuExecutor ussdMenuExecutor) {
		LOGGER.info("Initialized USSDMenuProcessor->USSDMenuProcessor()");
		this.ussdMenuExecutor = ussdMenuExecutor;
		LOGGER.info("Exited USSDMenuProcessor->USSDMenuProcessor()");
	}
	
	public USSDResponse processRequest(USSDRequest ussdRequest) {
		LOGGER.info("Initialized USSDMenuProcessor->processRequest()");
		LOGGER.info("Exited USSDMenuProcessor->processRequest()");
		return ussdMenuExecutor.execute(ussdRequest);
	}
}
