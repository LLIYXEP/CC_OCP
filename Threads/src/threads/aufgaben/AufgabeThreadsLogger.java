package threads.aufgaben;

class MyLogger {
	private StringBuilder sb = new StringBuilder();
	
	public void addMessage(String caller, String message) {
		sb.append(caller)
		  .append(" - ")
		  .append(message)
		  .append("\n");
	}
	
	public String getLog() {
		return sb.toString();
	}
} 

public class AufgabeThreadsLogger {

	public static void main(String[] args) {
		
		MyLogger ml = new MyLogger();
		
		ml.addMessage("First", "message1");
		String log = ml.getLog();
		
		System.out.println(log);
		
	}
	
}
