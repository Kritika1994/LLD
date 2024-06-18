package main.java;

abstract class LoggerProcessor {

	public static int LogTypeDebug = 0;
	public static int LogTypeInfo = 1;
	public static int LogTypeError = 2;
	LoggerProcessor nextProcessor;
	LoggerProcessor(LoggerProcessor nextProcessor){
		this.nextProcessor = nextProcessor;
	}
	
	void log(LogLevel logLevel, String message ) {
		if(nextProcessor!=null) {
			nextProcessor.log(logLevel,message);
		}
	}
}
