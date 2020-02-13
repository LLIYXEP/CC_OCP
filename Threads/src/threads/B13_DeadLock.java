package threads;

class Deadlock extends Thread {
	static final Object m1 = new Object();
	static final Object m2 = new Object();
	
	public void run() {
		synchronized (m1) { // 
			System.out.println("m1");  // Thread 2 hier, hat den Lock auf m1
			synchronized (m2) {
				System.out.println("m1.m2");
			}
		}
		
		synchronized (m2) {
			System.out.println("m2");  // Thread 1 hier, hat den Lock auf m2
			synchronized (m1) {
				System.out.println("m2.m1");
			}
		}
	}
}

public class B13_DeadLock {

	public static void main(String[] args) {
		
		new Deadlock().start();
		new Deadlock().start();
		
	}
	
}
