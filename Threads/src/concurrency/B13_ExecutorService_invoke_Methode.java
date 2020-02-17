package concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class B13_ExecutorService_invoke_Methode {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Collection<Callable<String>> tasks = new ArrayList<>();
		tasks.add(() -> "a");
		tasks.add(() -> "b");
		tasks.add(() -> "c");
		
		/*
		 * <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
		 */
		try {
			List<Future<String>> futures = service.invokeAll(tasks); // synchron
									  								   // main-Thread wird angehalten, bis ALLE tasks fertig sind
			
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
