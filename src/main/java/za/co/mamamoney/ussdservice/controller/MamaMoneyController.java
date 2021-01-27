package za.co.mamamoney.ussdservice.controller;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.mapstruct.Context;
import za.co.mamamoney.ussdservice.dtos.USSDRequest;
import za.co.mamamoney.ussdservice.dtos.USSDResponse;
import za.co.mamamoney.ussdservice.service.MamaMoneyServiceIF;

@RestController
public class MamaMoneyController{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(
					MamaMoneyController.class);
	
	@Autowired
	@Qualifier("mamaMoneyServiceImpl")
	private MamaMoneyServiceIF mamaMoneyServiceImpl;
	
	
	/**
	 * @param requestContext
	 * @param {@link USSDRequest}
	 * @return {@link USSDResponse}
	 */
	@RequestMapping(value="/ussd", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody USSDResponse ussd(@NotNull @Valid @Context HttpServletRequest 
			httpServletRequest, @NotNull @Valid @RequestBody USSDRequest 
			ussdRequest){
		LOGGER.info("Initialized MamaMoneyController->ussd()");
		LOGGER.info("Ip Address: "+ httpServletRequest.getRemoteHost());
		LOGGER.info("Content Length: "+ httpServletRequest.getContentLength());
		LOGGER.info("Protocol: "+ httpServletRequest.getProtocol());
		LOGGER.info("Date: "+ LocalDateTime.now());
		
		USSDResponse ussdResponse = null;
		
		try{
			ussdResponse = mamaMoneyServiceImpl.processRequest(ussdRequest);
		}
		catch(RuntimeException runtimeException){
			throw runtimeException;
		}
		
		LOGGER.info("Exited MamaMoneyController->ussd()");
		
		return ussdResponse;
	}
	
}
