package threads;

import java.io.IOException;

public class B06_ThredBeenden_Einfach {
	
	static void pause(long millis)  {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static class MyExtraThreadLogic implements Runnable{
		
		volatile boolean laufe = true;
		
		@Override
		public void run() {
			while (laufe) {
				System.out.println("laufe...");
				pause(1000);
			}
			
			System.out.println("Die run ist gleich vorbei fur den Thread " + Thread.currentThread().getId());
		}
	}

	public static void main(String[] args) {
		
		MyExtraThreadLogic logic = new MyExtraThreadLogic();
		Thread th = new Thread(logic);
		
		th.start();
		
		pause(5000);
		System.out.println("main beendet den Extra-Thread " + th.getId());
		
		logic.laufe = false;
		
	}
	
}
