package concurrency;

import java.util.concurrent.CopyOnWriteArrayList;

public class B05_Coll_CopyOnWrite {

	public static void main(String[] args) {
		
		/*
		 * Achtung! Sehr langsam beim Hinzufugen neuer Elemente!
		 * 
		 * make fresh copy of the array on set and add
		 * 
		 * Vorteile:
		 * 
		 * 	- threadsichere
		 * 	- lesen wird nicht unnotig synchonisiert
		 * 
		 * Gedacht fur den Einsatz:
		 * 
		 * 	haufiger Lesezugriffe mit get, seltenes Erweitern mit add
		 */
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
		
		
		
	}
	
}
