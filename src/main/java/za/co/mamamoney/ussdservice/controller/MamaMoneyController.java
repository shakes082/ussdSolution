package za.co.mamamoney.ussdservice.controller;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.mapstruct.Context;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;
import za.co.mamamoney.ussdservice.service.USSDServiceImpl;

@RestController
public class MamaMoneyController{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(
					MamaMoneyController.class);
	
	@Autowired
	private USSDServiceImpl uSSDServiceImpl;
	
	/**
	 * 
	 */
	public MamaMoneyController(){
		LOGGER.info("Initialized MamaMoneyController->MamaMoneyController()");
		LOGGER.info("Exited MamaMoneyController->MamaMoneyController()");
	}
	
	/**
	 * @param requestContext
	 * @param {@link USSDRequest}
	 * @return {@link USSDResponse}
	 */
	@RequestMapping(value="/ussd", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody USSDResponse ussd(@Context HttpServletRequest 
			requestContext, @Valid @RequestBody USSDRequest 
			ussdRequest){
		LOGGER.info("Initialized MamaMoneyController->ussd()");
		LOGGER.info("Ip Address: "+ requestContext.getRemoteHost());
		LOGGER.info("Content Length: "+ requestContext.getContentLength());
		LOGGER.info("Protocol: "+ requestContext.getProtocol());
		LOGGER.info("Date: "+ LocalDateTime.now());
		
		USSDResponse ussdResponse = null;
		
		try{
			ussdResponse = uSSDServiceImpl.processRequest(ussdRequest);
		}
		catch(RuntimeException runtimeException){
			throw runtimeException;
		}
		LOGGER.info("Exited MamaMoneyController->ussd()");
		return ussdResponse;
	}
	
}
