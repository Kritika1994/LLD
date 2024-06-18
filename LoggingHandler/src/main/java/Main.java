package main.java;

public class Main {


	public static void main(String[] args) {
		LoggerProcessor lp = new ErrorLogProcessor(new InfoLoggerProcessor(new DebugLogProcessor(null)));
		lp.log(LogLevel.Debug, "Hi");
		lp.log(LogLevel.Info, "My name");
		lp.log(LogLevel.Error, " is Kritika");
	}

}
