package concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
/*
 * compute:
 * 
 * 		Falls die Datenmenge klein genug ist (Augabe ist einfach):
 * 				 die Aufgabe losen,
 * 		Sonst: 
 * 				Datenmenge in zwei (oder mehrere) Teile spalten,
 * 				Zwei oder mehrere Sub-Tasks bilden,
 * 				Daten an die Sub- Tasks verteilen,
 * 				Sub - Tasks dem ForkJoinPool zum aktivieren ubergeben
 */
@SuppressWarnings("serial")
class MyRecutsiveActionReplaceNull extends RecursiveAction {

	private static final int MAX_ELEMENTS = 3;
	
	private int indexFrom, indexTo;
	private String[] daten;
	
	public MyRecutsiveActionReplaceNull(String[] daten, int indexFrom, int indexTo) {
		super();
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
		this.daten = daten;
	}

	@Override
	protected void compute() {
		
		if (indexTo - indexFrom <= MAX_ELEMENTS) {
			System.out.printf("Action fur den Bereaich %d bis %d, Thread %d %n", indexFrom,indexTo,Thread.currentThread().getId());
			for (int i = indexFrom; i < indexTo; i++) {
				if (daten[i] == null) {
					daten[i] = "nicht besetzt";
				}
			}
		} else {
			System.out.println("Aufgabe ist zu komplex!");
			
			int indexMitte = (indexTo - indexFrom) / 2 + indexFrom; // 
			
//			int indexFromA = indexFrom;
//			int indexToA = indexMitte;
//			
//			int indexFromB = indexMitte;
//			int indexToB = indexTo;
			
			System.out.printf("Action fur A und B vorbereitet  den Bereaich: %d / %d / %d, Thread %d %n", indexFrom,indexMitte,indexTo,Thread.currentThread().getId());
			
			RecursiveAction taskA = new MyRecutsiveActionReplaceNull(daten, indexFrom, indexMitte);
			RecursiveAction taskB = new MyRecutsiveActionReplaceNull(daten, indexMitte, indexTo);
			
			invokeAll(taskA, taskB); //taskA im aktuellen Thread, taskB im anderen Thread
		}
		
	}
	
}

public class B15_ForkJoin_RecursiveAction {

	public static void main(String[] args) {
		
		String[] daten = {
				"0",
				null,
				"2",
				null,
				"4",
				"5",
				"6",
				
		};
		
		//aufgabe: mit RecutsiveAction die nulls im Array durch "nicht besetzt" ersetzen
		
		ForkJoinPool pool = new ForkJoinPool();
		
		RecursiveAction task = new MyRecutsiveActionReplaceNull(daten, 0, daten.length);
		
		pool.invoke(task);
		
		System.out.println("Array in main: " + Arrays.toString(daten));
		
	}
	
}
