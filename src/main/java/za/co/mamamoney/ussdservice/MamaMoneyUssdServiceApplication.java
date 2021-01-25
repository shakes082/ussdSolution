package za.co.mamamoney.ussdservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SpringBootApplication
public class MamaMoneyUssdServiceApplication{
	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MamaMoneyUssdServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Initialized MamaMoneyUssdServiceApplication->main()");
		LOGGER.info("Exited MamaMoneyUssdServiceApplication->main()");
		SpringApplication.run(MamaMoneyUssdServiceApplication.class,args);
	}
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public Docket api(){
		LOGGER.info("Initialized MamaMoneyUssdServiceApplication->api()");
		LOGGER.info("Exited MamaMoneyUssdServiceApplication->api()");
		return new Docket(DocumentationType.SWAGGER_2)          
			      .select()
			      .apis(RequestHandlerSelectors.basePackage("za.co.mamamoney.ussdservice.controller"))
			      .paths(PathSelectors.any())
			      .build()
			      .apiInfo(apiInfo());
	}
	
	/**
	 *  
	 * @return {@link springfox.documentation.service.ApiInfo}
	 */
	
	private ApiInfo apiInfo(){	
		LOGGER.info("Initialized SwaggerConfig->apiInfo()");
		Contact contact = new Contact("Sheldon Anthony", "https://www.mamamoney.co.za/", "shakes082@gmail.com");
		LOGGER.info("Exited SwaggerConfig->apiInfo()");
		return new ApiInfoBuilder().title("Mama Money USSD API")
					.description("Mama Money USSD API")
					.termsOfServiceUrl("https://www.mamamoney.co.za/terms-conditions.html")
					.contact(contact)
					.license("Apache 2.0")
		            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0)")
		            .version("1.0")
		            .build();
	}
	
}
