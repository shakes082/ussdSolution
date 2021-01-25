package za.co.mamamoney.ussdservice.service;

public class USSDMenu2Processor extends USSDMenuProcessor{

	public USSDMenu2Processor() {
		super(new USSDMenu2Executor());
	}

}
