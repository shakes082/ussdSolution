package za.co.mamamoney.ussdservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
				ussdMenuProcessor = new USSDMenu1Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				return ussdResponse;
			}
			case 2:{
				ussdMenuProcessor = new USSDMenu2Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				return ussdResponse;
			}
			case 3:{
				ussdMenuProcessor = new USSDMenu3Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				return ussdResponse;
			}
			case 4:{
				ussdMenuProcessor = new USSDMenu4Processor();
				ussdResponse = ussdMenuProcessor.processRequest(ussdRequest);
				return ussdResponse;
			}
			default:
				throw new IllegalArgumentException("Invalid User Entry Supplied: " + iUserEntry);
			}
	}

}
