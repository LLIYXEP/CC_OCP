package concurrency.aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class MyReursiveActions extends RecursiveAction {
	private static final int MAX_ZEILEN = 3;
	private int[] daten;
	private int indexFrom;
	private int indexTo;

	public MyReursiveActions(int[] daten, int indexFrom, int indexTo) {
		super();
		this.daten = daten;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}



	@Override
	protected void compute() {
		if (indexTo - indexFrom <= MAX_ZEILEN) {
			System.out.println(indexFrom + " .... " + indexTo);
		} else {
			System.out.println("Aufgabe ist zu komplex!");
			
			int indexMitte = (indexTo - indexFrom) / 2 + indexFrom; // 
			
			
			MyReursiveActions taskA = new MyReursiveActions(daten, indexFrom, indexMitte);
			MyReursiveActions taskB = new MyReursiveActions(daten, indexMitte, indexTo);
			
			invokeAll(taskA, taskB);
		}
	}
	
}

public class KleineAufgabeRecursiveTask {

	public static void main(String[] args) {
		
		int[] data = {1,2,3,4,5,6,7,8,9};
		
		ForkJoinPool pool = new ForkJoinPool();
		
		MyReursiveActions task = new MyReursiveActions(data, 0, data.length);
		
		pool.invoke(task);
		
	}
	
}
