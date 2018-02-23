package behavioral_patterns;

abstract class AbstractLogger {
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	protected int level = 1;

	public AbstractLogger abstractLogger;

	public void setNextLogger(AbstractLogger al) {
		abstractLogger = al;
	}

	public void log(int level, String message) {
		if (level >= this.level) {
			write(message);
		}
		if (abstractLogger != null) {
			abstractLogger.log(level, message);
		}
	}

	public abstract void write(String message);

}

class ConsoleLogger extends AbstractLogger {
	{
		level = abstractLogger.INFO;
	}

	@Override
	public void write(String message) {
		System.out.println("INFO: " + message);
	}

}

class ErrorLogger extends AbstractLogger {
	{
		level = abstractLogger.ERROR;
	}

	@Override
	public void write(String message) {
		System.out.println("ERROR: " + message);
	}

}

class FileLogger extends AbstractLogger {
	{
		level = abstractLogger.DEBUG;
	}

	@Override
	public void write(String message) {
		System.out.println("DEBUG: " + message);
	}

}

public class ChainPattern {

	public static void main(String[] args) {
		AbstractLogger errorLogger = new ErrorLogger();
		AbstractLogger fileLogger = new FileLogger();
		AbstractLogger consoleLogger = new ConsoleLogger();
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);

		errorLogger.log(AbstractLogger.ERROR, "this is a error!");
		System.out.println("===========================");
		errorLogger.log(AbstractLogger.DEBUG, "this is a debug!");
		System.out.println("===========================");
		errorLogger.log(AbstractLogger.INFO, "this is a info!");

	}

}
