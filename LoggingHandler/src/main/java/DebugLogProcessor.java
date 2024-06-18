package main.java;

public class DebugLogProcessor extends LoggerProcessor {

	public DebugLogProcessor(LoggerProcessor nextProcessor) {
		super(nextProcessor);
		// TODO Auto-generated constructor stub
	}
	void log(LogLevel logLevel, String message ) {
		if(logLevel==LogLevel.Debug) {
			System.out.println("Debug level message: "+message);
		}
		else {
			super.log(logLevel,message);
		}
	}

}
