package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import threads.MyThreadUtils;

public class B12_ExecutorService_Ergebnisse_abwarten {

	public static void main(String[] args) {
		
//		v1_awaitTermination();
//		v2_Future_get_for_Runnable_1();
//		v2_Future_get_for_Runnable_2();
		v3_Future_get_for_Callable();
		
		// weitere Moglichkeit Ergebnisse abzuwarten: invoke - Methoden B13
	}
	
	static void v3_Future_get_for_Callable() {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Callable task = () -> {
			System.out.println("run");
			return 12345;
		};
		
		Future<Integer> submit = service.submit(task);
		
		service.shutdown();
		
		
		try {
			Integer resut = submit.get();
			System.out.println(resut);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	static void v2_Future_get_for_Runnable_2() {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		AtomicInteger result = new AtomicInteger();
		
		Runnable task = () -> {
			System.out.println("run");
			result.set(330 + 3);
		};
		
		Future<AtomicInteger> future = service.submit(task, result);
		
		service.shutdown();
		
		try {
			AtomicInteger resultFromFuture = future.get();
			System.out.println("result from future: " + resultFromFuture);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 

	}
	
	static void v2_Future_get_for_Runnable_1() {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		AtomicInteger result = new AtomicInteger(0);
		
		Runnable task = () -> {
			System.out.println("run");
			result.set(110);
		};
		
		/*
		 * Future<?> submit(Runnable task);
		 */
		Future<?> future = service.submit(task);
		
//		service.shutdown();
		
		try {
			future.get(); // liefert bei der verwendenten immer null zuruck
						  // blockiert den main - Thread, die Task vorbei ist
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("result: " + result);
		
		service.shutdown();
		
	}
	
	static void v1_awaitTermination() {
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		AtomicInteger result = new AtomicInteger(0); // zum Datenaustausch
		
		Runnable task = () -> {
			System.out.println("run");
			 result.set(22);
		};
		service.execute(task);
		
		service.shutdown();
		
		System.out.println("result: " + result); // 0
		
		long timeout = 1;
		TimeUnit unit = TimeUnit.DAYS;
		try {
			service.awaitTermination(timeout, unit); // synchron, warten maximal 1 Tag bis alle registrirten Tasks fertig sind
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("result: " + result); // 22
		
	}
	
}
