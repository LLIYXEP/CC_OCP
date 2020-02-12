package threads;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Race Condition ensteht bei , wenn zwei mehr Threads parallel lesend und schreibend auf dieselbe Variable zugreifen konnen
 */
public class B09_RaceCondition {
	
	/*
	 * value++ ist eigentlich value = 'value +1'
	 * 
	 * Eine Situation, bei der es zu einem Fehler kommt:
	 * 
	 * 								value = 0
	 * 
	 * Thread 1											Thread 2
	 * 
	 * cpu1 = value (cpu1=0)							cpu2 = value (cpu2=0)
	 * cpu1 ++      (cpu1=1)							cpu2 ++      (cpu1=1)
	 * value = cpu1 (atomar)
	 * 
	 * 								value = 1
	 * 
	 * 													value = cpu2 (atomar)
	 * 
	 * 								value = 1
	 */
	
	
//	volatile static AtomicInteger value = new AtomicInteger(0);
	volatile static int value;
	
	static class Increment implements Runnable {
		public void run() {
			for (int i = 0; i < 1000_000; i++) {
//				value.incrementAndGet();
				value++; // nicht atomar, durfte nicht parallel ausgefuht werden
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Increment());
		Thread t2 = new Thread(new Increment());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		
		System.out.println("value : " + value); // Etwas kleiner oder gleich 2 Millionen
		
	}
	
}
