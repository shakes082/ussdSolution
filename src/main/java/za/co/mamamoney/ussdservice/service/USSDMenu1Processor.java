package za.co.mamamoney.ussdservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class USSDMenu1Processor extends USSDMenuProcessor{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(
					USSDMenu2Processor.class);
	
	public USSDMenu1Processor(USSDMenuExecutor ussdMenuExecutor){
		super(ussdMenuExecutor);
		LOGGER.info("Initialized USSDMenu1Processor->USSDMenu1Processor()");
		LOGGER.info("Exited USSDMenu1Processor->USSDMenu1Processor()");
	}
}
