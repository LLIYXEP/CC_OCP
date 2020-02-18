package concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

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

class RecursiveTaskCountWords extends RecursiveTask<Integer> {

	private static final int MAX_SIZE = 3;
	private List<String> list;
	
	public RecursiveTaskCountWords(List<String> list) {
		super();
		this.list = list;
	}

	
	protected Integer compute() {
		System.out.println("Thread: " + Thread.currentThread().getId());
		
		if (list.size() < MAX_SIZE) {
			
			int count = 0;
			for (String s : list) {
				if (s.length() == 2) {
					count++;
				}
			}
			
			return count;
		} else {
			
			int indexMitte = list.size() / 2;
			
			List<String> listA = list.subList(0, indexMitte);
			List<String> listB = list.subList(indexMitte, list.size());
			
			RecursiveTaskCountWords taskA = new RecursiveTaskCountWords(listA);
			RecursiveTaskCountWords taskB = new RecursiveTaskCountWords(listB);
			
			//Sinloss neide anrufe in den selben Thread
//			Integer countA = taskA.compute();
//			Integer countB = taskB.compute();
			
			ForkJoinTask<Integer> fork = taskA.fork(); // aktiviert die taskA (startet compute) im anderen-Thread
			
			Integer countB = taskB.compute();
			
			Integer countA = taskA.join();  // aktiviert die Task (startet compute) im anderen-Thread
											// falls noch nicht geschehen und blockiert den aktuellen Thread bis taskA fertig ist
											// oder liefert das Ergebniss der compute con taskA zuruck
			
			
			
			
			
			return countA + countB;
		}
		
		
	}
	
	
}

public class B16_ForkJoin_RecursiveTask {

	public static void main(String[] args) {
		
		List<String> daten = Arrays.asList("a", "bb", "ccc", "dd", "e", "ff", "g", "hh");
		
		ForkJoinPool pool = ForkJoinPool.commonPool();
		
		RecursiveTaskCountWords task = new RecursiveTaskCountWords(daten);
		
		Integer count = pool.invoke(task);
		
		System.out.println("Anzahl der Strings Langer 2: " + count);
		
	}
	
}
