package threads;

import threads.B09_RaceCondition.Increment;

public class B10_Synchronisieren {
	
	volatile static int value;
	
	static final Object monitor = new Object(); // nicht die beste wahl als Monitor. Nur in diesem Beispiel
	
	static class Increment implements Runnable {
		public void run() {
			for (int i = 0; i < 1_000_000; i++) {
				
				synchronized (monitor)
					{				// kritischer Block start
						value++; 
					}				// kritischer Block end
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
			
			
			
			System.out.println("value : " + value); // 2 000 000
			
		}
		
	}

