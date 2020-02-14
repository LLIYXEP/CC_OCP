package threads;

/*
 * wait, notify und notifyAll mussen aus einem synchronized Block aufgerufen werden
 * 		- der synchronized Block soll als Monito rdas Object verwenden, mit dem die wait notify und notifyAll angerufen werden
 * 
 * sonst: IllegalMonitorStateException
 * 
 * - Wahrend des wait -Aufrufes gibt ser WAITING- Thread den Lock auf den Monitor frei
 */

public class B15_wait_notify_Regel {

	public static void main(String[] args) {
		
		Object monitor = new Object();
		
		Runnable target = () -> {
			System.out.println(" In 2 sek. wird der main Thread aus dem WAITING geholt");
			MyThreadUtils.pause(2000);
			
			synchronized (monitor) {
				monitor.notify();
			}
//			monitor.notifyAll(); // geht auch
		};
		
		new Thread(target).start();
		
		System.out.println("main geht ins WAITING");
		
		try {
			synchronized (monitor) {
				monitor.wait();  // wahrend des WAITING ist der Monitor frei 
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main ist wieder RUNNING");
		
	}
	
}
