package concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class B13_ExecutorService_invoke_Methode {
	
	public static void main(String[] args) {
		
//		test_invokeAll(); // eher in der Prufung
		test_invokeAny(); // 
		
	}
	
	public static void test_invokeAny() {
		ExecutorService service = Executors.newCachedThreadPool();
		
		Collection<Callable<String>> tasks = new ArrayList<>();
		tasks.add(() -> "heute");
		tasks.add(() -> "ist");
		tasks.add(() -> "Dienstag");
		
		/*
		 * <T> T invokeAny(Collection<? extends Callable<T>> tasks)
        	throws InterruptedException, ExecutionException;
		 */
		try {
			String result = service.invokeAny(tasks);
			System.out.println("result: " + result); // Ergebniss unbestimt
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
		
		service.shutdown();
	}

	public static void test_invokeAll() {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Collection<Callable<String>> tasks = new ArrayList<>();
		tasks.add(() -> "a");
		tasks.add(() -> "b");
		tasks.add(() -> "c");
		
		/*
		 * <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
		 * 
		 * <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                  long timeout, TimeUnit unit)
		 */
		try {
			List<Future<String>> futures = service.invokeAll(tasks); // synchron
									  								   // main-Thread wird angehalten, bis ALLE tasks fertig sind
			
//			long timeout = 1;
//			TimeUnit unit = TimeUnit.DAYS;
//			futures = service.invokeAll(tasks, timeout, unit);
			
			System.out.println("*** isDone: ");
			futures.forEach( f -> System.out.println(f.isDone())); // true
			
			for (Future<String> future : futures) {
				try {
					System.out.println("result: " + future.get());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
								  
		
		service.shutdown();
		
	}
	
}
