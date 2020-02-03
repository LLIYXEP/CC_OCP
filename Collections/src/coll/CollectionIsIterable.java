package coll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIsIterable {

	public static void main(String[] args) {
		
		Collection<Integer> coll = new ArrayList<Integer>();
		
		coll.add(12);
		coll.add(13);
		coll.add(14);
		
		System.out.println("********** mit einem Iterator *******");
		Iterator<Integer> iterator = coll.iterator();
		
		while (iterator.hasNext()) {
			Integer x = iterator.next();
			System.out.println(x);
		}
		
		try {
			iterator.next();
		} catch (Exception e) {
			System.out.println("Fehler! es gibt keine weitere elemente zum Iterieren");
		}
		
		Iterator<Integer> iterator2 = coll.iterator();
		System.out.println(iterator2.next());
		System.out.println(iterator2.next());
		System.out.println(iterator2.next());
		
		System.out.println("mit der foreach");
		for (Integer integer : coll) {
			System.out.println(integer);
		}
		
	}
	
	
	
}
