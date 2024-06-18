package main.java;

public class ErrorLogProcessor extends LoggerProcessor {

	public ErrorLogProcessor(LoggerProcessor nextProcessor) {
		super(nextProcessor);
		// TODO Auto-generated constructor stub
	}
	
	void log(LogLevel logLevel, String message ) {
		if(logLevel==LogLevel.Error) {
			System.out.println("Error level message: "+message);
		}
		else {
			super.log(logLevel,message);
		}
	}
}
