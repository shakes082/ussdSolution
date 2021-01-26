package za.co.mamamoney.ussdservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

@Service("mamaMoneyServiceImpl")
public class MamaMoneyServiceImpl implements MamaMoneyServiceIF{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MamaMoneyServiceImpl.class);
	
	public MamaMoneyServiceImpl() {
		LOGGER.info("Initialized MamaMoneyServiceImpl->MamaMoneyServiceImpl()");
		LOGGER.info("Exited MamaMoneyServiceImpl->MamaMoneyServiceImpl()");
	}

	@Override
	public USSDResponse processRequest(USSDRequest ussdRequest) {
		
			LOGGER.info("Initialized MamaMoneyServiceImpl->processRequest()");
			
			final int iUserEntry = ussdRequest.getUserEntry();
			
			USSDMenuProcessor ussdMenuProcessor = null;
			
			USSDResponse ussdResponse = null;
			
			switch (iUserEntry) {
			case 1:{
				ussdMenuProcessor = getUSSDMenu1Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				LOGGER.info("Exited MamaMoneyServiceImpl->processRequest()");
				return ussdResponse;
			}
			case 2:{
				ussdMenuProcessor = getUSSDMenu2Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				LOGGER.info("Exited MamaMoneyServiceImpl->processRequest()");
				return ussdResponse;
			}
			case 3:{
				ussdMenuProcessor = getUSSDMenu3Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				LOGGER.info("Exited MamaMoneyServiceImpl->processRequest()");
				return ussdResponse;
			}
			case 4:{
				ussdMenuProcessor = getUSSDMenu4Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				LOGGER.info("Exited MamaMoneyServiceImpl->processRequest()");
				return ussdResponse;
			}
			default:
				LOGGER.info("Exited MamaMoneyServiceImpl->processRequest()");
				throw new IllegalArgumentException("Invalid User Entry Supplied: " + iUserEntry);
			}
		
	}

	@Bean
	private USSDMenuExecutor getUSSDMenu1Executor(){
		return new USSDMenu1Executor();
	}
	
	@Bean
	private USSDMenuExecutor getUSSDMenu2Executor(){
		return new USSDMenu2Executor();
	}
	
	@Bean
	private USSDMenuExecutor getUSSDMenu3Executor(){
		return new USSDMenu3Executor();
	}
	
	@Bean
	private USSDMenuExecutor getUSSDMenu4Executor(){
		return new USSDMenu4Executor();
	}
	
	@Bean
	private USSDMenuProcessor getUSSDMenu1Processor(){
		return new USSDMenu1Processor(getUSSDMenu1Executor());
	}
	
	@Bean
	private USSDMenuProcessor getUSSDMenu2Processor(){
		return new USSDMenu2Processor(getUSSDMenu2Executor());
	}
	
	@Bean
	private USSDMenuProcessor getUSSDMenu3Processor(){
		return new USSDMenu3Processor(getUSSDMenu3Executor());
	}
	
	@Bean
	private USSDMenuProcessor getUSSDMenu4Processor(){
		return new USSDMenu4Processor(getUSSDMenu4Executor());
	}
	
}
