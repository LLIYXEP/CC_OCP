package singleton;

public class ProgramLogger {

	private static ProgramLogger programLogger;
	private static String logFile = "This is log file. \n\n";
	
	public static synchronized ProgramLogger getProgramLogger() {
		if (programLogger == null) {
			programLogger = new ProgramLogger();
		}
		
		return programLogger;
	}
	
	public void addLogInfo(String loginf) {
		logFile += loginf + "\n";
	}
	
	public void showLogFile() {
		System.out.println(logFile);
	}
}
