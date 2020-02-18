package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class My1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.submit(new MyRunnable());
		System.out.println(executorService.submit(new MyCallable()).get());
		
		executorService.shutdown();
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