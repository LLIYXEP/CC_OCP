package threads.aufgaben.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class KleineAufgabeFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		List<Callable<Integer>> callList = new ArrayList<Callable<Integer>>();
		
		for (int i = 0; i < 100; i++) {
			Callable<Integer> callable = () -> {
				int nextInt = new Random().nextInt(5);
				System.out.println("Registriert " + nextInt);
				return nextInt;
			};
			callList.add(callable);
		}
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		
		
		Integer summ = 0;
		for (Callable<Integer> callable : callList) {
			Future<Integer> submit = service.submit(callable);
			summ += submit.get(); // get() blockiert den main Thread
		}
		
		service.shutdown();
		
		System.out.println(summ);
		
	}
	
}
