package concurrency.aufgaben;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class AufgabeForkJoinArray {
	
	static class MyRecursiveAction extends RecursiveAction {
		
		private static final int MAX_SIZE = 3;
		
		private int[] arr;
		private int indexFrom;
		private int indexTo;

		public MyRecursiveAction(int[] arr, int indexFrom, int indexTo) {
			super();
			this.arr = arr;
			this.indexFrom = indexFrom;
			this.indexTo = indexTo;
		}

		@Override
		protected void compute() {
			if (indexTo - indexFrom <= MAX_SIZE) {
				for (int i = indexFrom; i < indexTo; i++) {
					if (arr[i] < 0) {
						arr[i] = 0;
					}
				}
			} else {
				int indexMitte = (indexTo - indexFrom) / 2 + indexFrom;
				RecursiveAction taskA = new MyRecursiveAction(arr, indexFrom, indexMitte);
				RecursiveAction taskB = new MyRecursiveAction(arr, indexMitte, indexTo);
				invokeAll(taskA, taskB);
				
			}
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			int random = new Random().nextInt(50 + 50) - 50;
			arr[i] = random;
		}
		
		System.out.println("Array in main 1: " + Arrays.toString(arr));
		
		ForkJoinPool pool = new ForkJoinPool();
		
		RecursiveAction task = new MyRecursiveAction(arr, 0, arr.length);
		
		pool.invoke(task);

		System.out.println("Array in main 2: " + Arrays.toString(arr));
		
	}
	
}
