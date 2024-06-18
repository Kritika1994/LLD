package main.java;

public class InfoLoggerProcessor extends LoggerProcessor {

	public InfoLoggerProcessor(LoggerProcessor nextProcessor) {
		super(nextProcessor);
	}
	
	void log(LogLevel logLevel, String message ) {
		if(logLevel==LogLevel.Info) {
			System.out.println("Info level message: "+message);
		}
		else {
			super.log(logLevel,message);
		}
	}

}
