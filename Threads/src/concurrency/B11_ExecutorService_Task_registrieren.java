package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * interface Callable hat nur die Methode : 
 * 			V call() throws Exception;
 */
public class B11_ExecutorService_Task_registrieren {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		/*
		 * execute(Runnable)
		 */
		Runnable task1 = () -> System.out.println("run 1");
		service.execute(task1);
		
		/*
		 * Future<?> submit(Runnable task);
		 */
		Runnable task2 = () -> System.out.println("run 2");
		Future<?> future2 = service.submit(task2);
		
		/*
		 * <T> Future<T> submit(Runnable task, T result);
		 */
		Runnable task3 = () -> System.out.println("run 3");
		Integer result3 = 3;
		Future<Integer> future3 = service.submit(task3, result3);
		System.out.println("result3: " + 3);
		
		/*
		 * <T> Future<T> submit(Callable<T> task);
		 */
		Callable<Integer> task4 = () -> {
			System.out.println("call");
			return 1 + 3;
		};
		Future<Integer> future4 = service.submit(task4); // async
		
		try {
			Integer result4 = future4.get(); // synchron get() ist fast wie join()
			System.out.println("result4: " + result4);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		
		
		service.shutdown();
		
	}
	
}
