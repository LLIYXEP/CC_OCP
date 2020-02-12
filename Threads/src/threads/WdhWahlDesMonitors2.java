package threads;

class ValueAccess {
	private static int value;
	
	public static int getValue() {
		return value;
	}
	
	void increment() {
		value++;
	}
	
}

public class WdhWahlDesMonitors2 {

	public static void main(String[] args) throws InterruptedException {
//		Object monitor = new Object();
		Object monitor = new ValueAccess();
		
		ValueAccess accessA = new ValueAccess();
		
		Runnable targetA = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				synchronized (monitor) {
					accessA.increment();
				}
			}
		};
		
		Thread t1 = new Thread(targetA);
		Thread t2 = new Thread(targetA);
		
		
		ValueAccess accessB = new ValueAccess();
		
		Runnable targetB = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				synchronized (monitor) {
					accessB.increment();
				}
			}
		};
		
		Thread t3 = new Thread(targetB);
		Thread t4 = new Thread(targetB);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println(ValueAccess.getValue());
		
	}
	
}
