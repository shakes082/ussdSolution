package za.co.mamamoney.ussdservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USSDMenu2Processor extends USSDMenuProcessor{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(
					USSDMenu2Processor.class);
	
	public USSDMenu2Processor(USSDMenuExecutor ussdMenuExecutor) {
		super(ussdMenuExecutor);
		LOGGER.info("Initialized USSDMenu2Processor->USSDMenu2Processor()");
		LOGGER.info("Exited USSDMenu2Processor->USSDMenu2Processor()");
	}

}
