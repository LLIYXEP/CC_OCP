package concurrency.aufgaben;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threads.MyThreadUtils;

public class AufgabeCyclibBarier {

	static int count;
	
	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.println("count: " + count));
		
		Runnable inc = () -> {
			
			for (int i = 0; i < 1_000_000; i++) {
				synchronized (barrier) {
					count++;
				}
			}
			
			try {
				barrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		};
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		service.execute(inc);
		service.execute(inc);

		service.shutdown();
	}
	
}
