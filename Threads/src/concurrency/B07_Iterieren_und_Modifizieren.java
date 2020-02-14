package concurrency;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class B07_Iterieren_und_Modifizieren {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(7);
		
//		iterierenUndModifizieren(list); // ConcurrentModificationException
		
		List<Integer> listSync = Collections.synchronizedList(list);
		
//		iterierenUndModifizieren(listSync); // ConcurrentModificationException
		
		CopyOnWriteArrayList<Integer> copyOnWriteList = new CopyOnWriteArrayList<Integer>(list);
		
		// Ausgabe: 5 7	Iterator aus CopyOnWriteArrayList behalt 'Snapshot' Elemente
		iterierenUndModifizieren(copyOnWriteList); // 5 7
		System.out.println(copyOnWriteList); // [5, 7, 9, 9]
		
		ConcurrentLinkedDeque<Integer> concDeque = new ConcurrentLinkedDeque<Integer>(list);
		iterierenUndModifizieren(concDeque);
	}
	
	static void iterierenUndModifizieren(Collection<Integer> coll) {
		
		System.out.println("****** erhalten: " + coll.getClass());
		
		for (Integer x : coll) {
			System.out.println(x);
			coll.add(9);			
		}
		
	}
	
}
