package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class My1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
//		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		
//		executorService.submit(new MyRunnable());
//		System.out.println(executorService.submit(new MyCallable()).get());
//		
//		executorService.shutdown();
		
		Collection<Integer> col = Arrays.asList(1,2,3);
		
		col.parallelStream().forEach(System.out::println);
		
		System.out.println("-----------");
		
		List<Integer> daten = Arrays.asList(12,14,16,18);
		
		Integer result = daten.parallelStream()
				.filter( x -> {
					return true;})
				.findFirst()
				.get();
		
		System.out.println(result);
		
	}
	
	static class MyRunnable implements Runnable {

		@Override
		public void run() {
			System.out.println(1);
		}
		
	}
	
	static class MyCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			return "2";
		}
		
	}
	
}
