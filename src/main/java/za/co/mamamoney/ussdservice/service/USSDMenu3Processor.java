package za.co.mamamoney.ussdservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USSDMenu3Processor extends USSDMenuProcessor{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(
					USSDMenu3Processor.class);

	public USSDMenu3Processor(USSDMenuExecutor ussdMenuExecutor) {
		super(ussdMenuExecutor);
		LOGGER.info("Initialized USSDMenu3Processor->USSDMenu3Processor()");
		LOGGER.info("Exited USSDMenu3Processor->USSDMenu3Processor()");
	}

}
