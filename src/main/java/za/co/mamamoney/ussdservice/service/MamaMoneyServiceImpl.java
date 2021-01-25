package za.co.mamamoney.ussdservice.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import za.co.mamamoney.ussdservice.MamaMoneyUssdServiceApplication;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

@Service("mamaMoneyServiceImpl")
public class MamaMoneyServiceImpl implements MamaMoneyServiceIF{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MamaMoneyUssdServiceApplication.class);
	
	public MamaMoneyServiceImpl() {
	}

	@Override
	public USSDResponse processRequest(USSDRequest ussdRequest){
		
		LOGGER.info("Initialized MamaMoneyServiceImpl->processRequest()");
		
		final int iUserEntry = ussdRequest.getUserEntry();
		
		USSDMenuExecutor ussdMenuExecutor = null;
		
		USSDResponse ussdResponse = null;
		
		switch (iUserEntry) {
		case 1:{
			ussdMenuExecutor = new USSDMenu1Executor();
			ussdResponse = ussdMenuExecutor.execute(ussdRequest);
			return ussdResponse;
		}
		case 2:{
			ussdMenuExecutor = new USSDMenu2Executor();
			ussdResponse = ussdMenuExecutor.execute(ussdRequest);
			return ussdResponse;
		}
		case 3:{
			ussdMenuExecutor = new USSDMenu3Executor();
			ussdResponse = ussdMenuExecutor.execute(ussdRequest);
			return ussdResponse;
		}
		case 4:{
			ussdMenuExecutor = new USSDMenu4Executor();
			ussdResponse = ussdMenuExecutor.execute(ussdRequest);
			return ussdResponse;
		}
		default:
			throw new IllegalArgumentException("Invalid User Entry Supplied: " + iUserEntry);
		}
		
	}

}
