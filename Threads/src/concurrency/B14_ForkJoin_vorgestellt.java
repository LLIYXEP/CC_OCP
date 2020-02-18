package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/*
 * Delit Zadanie na melenikie Zadaniia
 */
public class B14_ForkJoin_vorgestellt {

	public static void main(String[] args) {
		
		RecursiveAction task1 = new RecursiveAction() {

			@Override
			protected void compute() {
				System.out.println("compute der task1");
			}
			
		};
		
		ForkJoinPool pool1 = new ForkJoinPool();
		Void result1 = pool1.invoke(task1); // synchron
//		/result1 resultist immer 0
		
		RecursiveTask<Integer> task2 = new RecursiveTask<>() {

			@Override
			protected Integer compute() {
				System.out.println("compute der task2");
				return 12;
			}
			
		};
		
		ForkJoinPool pool2 = new ForkJoinPool();
		Integer result2 = pool2.invoke(task2); // synchron
		System.out.println("result2: " + result2);
		
	}
	
}
