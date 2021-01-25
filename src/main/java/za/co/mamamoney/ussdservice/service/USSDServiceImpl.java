package za.co.mamamoney.ussdservice.service;
import org.springframework.stereotype.Service;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;

@Service
public class USSDServiceImpl implements USSDServiceIF{

	@Override
	public USSDResponse processRequest(USSDRequest ussdRequest){
		
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
