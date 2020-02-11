package threads;

public class B01_Thread_starten {

	public static void main(String[] args) {

		/*
		 * 1. Thread-Object erstellen 
		 */
		Thread th = new Thread();
		
		/*
		 * 2. Thread beim Scheduler als startklar registrieren (!)
		 */
		th.start();  // ab hier gibt es zwei Threads mit gleichen Rechten
		
		
		/*
		 * Die Methode run , die im Extra-Thread (im Zustand RUNNABLE) laufen wird:
		 * 
		 * public void run() {
		        if (target != null) {
		            target.run();
		        }
		    }
		 */
		
	} // end of main
	
}
