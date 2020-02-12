package threads.aufgaben;

import java.util.concurrent.atomic.AtomicInteger;

public class My3 {
	
	static AtomicInteger atomicInteger = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		
		for (int i = 0; i < 10_000; i++) {
			new MyThread().start();
		}
		Thread.sleep(1000);
		System.out.println(atomicInteger.get());
		
	}
	
	static class MyThread extends Thread {
		@Override
		public void run() {
			atomicInteger.incrementAndGet();
		}
	}
	
}
