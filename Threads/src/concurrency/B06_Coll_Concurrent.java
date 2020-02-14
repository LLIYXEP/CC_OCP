package concurrency;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;

public class B06_Coll_Concurrent {

	public static void main(String[] args) {
		
		/*Concurent Klassen sind
		 * 
		 * - threadsicher
		 * - durchshnittlich schnekker als die 'synchtonized' Collections aus den synchtonizedXXX - Methoden der Klasse 'Collections'
		 */
		
		ConcurrentLinkedQueue<Integer> queue;
		ConcurrentLinkedDeque<Integer> deque;
		ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<Integer>();
		
		/*
		 * SkipList = Sortiert
		 */
		set.add(11);
		set.add(-7);
		set.add(13);
		set.add(13);
		set.add(-19);
		
		System.out.println(set); // [-19, -7, 11, 13]
	}
	
}
