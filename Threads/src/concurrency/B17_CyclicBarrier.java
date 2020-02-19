package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import threads.MyThreadUtils;

public class B17_CyclicBarrier {

	public static void main(String[] args) {

		int parties = 2;
		
//		CyclicBarrier barrier = new CyclicBarrier(parties); // den Constructor gibt es auch
		
		Runnable action = () -> System.out.println("Barriere durchbrochen von Thread " + Thread.currentThread().getId());
		CyclicBarrier barrier = new CyclicBarrier(parties, action);
		
		
		Runnable target = () -> {
			
			System.out.println("Thread " + Thread.currentThread().getId() + " kommt zu der Barriere");
			
			try {
				barrier.await();
				
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			System.out.println("Thread " + Thread.currentThread().getId() + " geht weiter");
		};
		
	
		new Thread(target).start();
		new Thread(target).start();

		MyThreadUtils.pause(2000);
		
		System.out.println("** und nochmal");
		
		new Thread(target).start();
		new Thread(target).start();
	}
	
}


