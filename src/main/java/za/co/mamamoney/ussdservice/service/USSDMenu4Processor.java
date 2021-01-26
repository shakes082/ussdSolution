package za.co.mamamoney.ussdservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USSDMenu4Processor extends USSDMenuProcessor{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(
					USSDMenu4Processor.class);
	
	public USSDMenu4Processor(USSDMenuExecutor ussdMenuExecutor) {
		super(ussdMenuExecutor);
		LOGGER.info("Initialized USSDMenu4Processor->USSDMenu4Processor()");
		LOGGER.info("Exited USSDMenu4Processor->USSDMenu4Processor()");
	}

}
