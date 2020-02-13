package threads.aufgaben;

/*
 * Diese Klasse ist threadsicher dur die aktuelle Anwendung
 * aber im allgemeinen nach Oracle ist die nicht threadsicher, denn damit lasst sich Code erstellenn
 * mit dem 'unkorrekte' Inhalte im Logger gefunden werden konnen
 */
class MyLogger {
	private StringBuilder sb = new StringBuilder();
//	private StringBuffer sb = new StringBuffer();
	
	public void addMessage(String caller, String message) {
		synchronized (this) {
			sb.append(caller)
			  .append(" - ")
			  .append(message)
			  .append("\n");
		}
	}
	
	public String getLog() {
//		nach Oracle muss auch hier der lesende Zugriff auf sb synchonisiert werden, damit die Klasse MyLogger threadsicher werd
//		synchronized (this) {
//			return sb.toString();
//		}
		return sb.toString();
	}
} 

class MyService extends Thread {
	
	private MyLogger logger;
	
	public MyService(MyLogger logger) {
		super();
		this.logger = logger;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			logger.addMessage(getName(), "Message " + i);
		}
	}
}

public class AufgabeThreadsLogger {

	public static void main(String[] args) throws InterruptedException {
		
		MyLogger logger = new MyLogger();
		
		Thread t1 = new MyService(logger);
		Thread t2 = new MyService(logger);
		t1.start();
		t2.start();
		
		new MyService(new MyLogger()).start();
		
		t1.join();
		t2.join();
		
		System.out.println(logger.getLog());
		
	}
	
}
