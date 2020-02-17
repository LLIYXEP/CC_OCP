package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threads.MyThreadUtils;

public class B10_ExecutorService_ThreadPool {

	public static void main(String[] args) {
		
		List<Runnable> listTasks = new ArrayList<Runnable>();
		
		for (int i = 0; i < 10; i++) {
			Runnable task = () -> System.out.println("my task in thread " + Thread.currentThread().getId());
			listTasks.add(task);
		}
		
		/*
		 * newSingleThreadExecutor
		 */
//		ExecutorService service = Executors.newSingleThreadExecutor();
		
		/*
		 * newCachedThreadPool
		 * 		wenn es keinen freien Thread fur neu registrierte Aufgabe gibt,
		 * 		wird ein weiterer Thread erzeugt.
		 */
//		ExecutorService service = Executors.newCachedThreadPool();
		
		/*
		 * 
		 */
		int nThreads = 4; 
		
//		nThreads = Runtime.getRuntime().availableProcessors();
//		System.out.println("Anzahl Threads: " + nThreads);
		
		ExecutorService service = Executors.newFixedThreadPool(nThreads);
		
		for (Runnable task : listTasks) {
			service.execute(task);
//			MyThreadUtils.pause(100);
		}
		
		service.shutdown();
		
	}
	
}
