package za.co.mamamoney.ussdservice.service;

public class USSDMenu1Processor extends USSDMenuProcessor{

	public USSDMenu1Processor() {
		super(new USSDMenu1Executor());
	}

}
