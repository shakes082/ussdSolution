package za.co.mamamoney.ussdservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MamaMoneyUssdServiceApplication{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MamaMoneyUssdServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Initialized MamaMoneyUssdServiceApplication->main()");
		LOGGER.info("Exited MamaMoneyUssdServiceApplication->main()");
		SpringApplication.run(MamaMoneyUssdServiceApplication.class, args);
	}
	
}
