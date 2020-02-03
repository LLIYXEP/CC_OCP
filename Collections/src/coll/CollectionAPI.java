package coll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.function.Predicate;

public class CollectionAPI {
	
	public static void main(String[] args) {
		
//		testMethods(new ArrayList<>());
//		testMethods(new HashSet<>());
//		testMethods(new TreeSet<>());
		
	}

	public static void testMethods(Collection<Integer> coll) {
		
		System.out.println(" ******** test for: " + coll.getClass());
		
		/*
		 * boolean add(E e)
		 * 
		 */
		System.out.println(" ***** add(12), add(13), add(12) *****");
		System.out.println(coll.add(12));
		System.out.println(coll.add(13));
		System.out.println(coll.add(12));
		
		System.out.println("1: " + coll);
		
//		System.out.println(coll.add("2")); // CF (Integer als Parametr)
		
		/*
		 * boolean remove(Object e)
		 */
		System.out.println(" ***** remove (\"hallo\") *****");
		try {
			System.out.println(coll.remove("hallo")); // false oder ClassCastexceptoin mit einem Treeset
		} catch (ClassCastException e) {
			System.out.println("Fehler in remove: " + e.fillInStackTrace());
		}
		
		
		System.out.println("2: " + coll);
		/*
		 * removeIf
		 */
		System.out.println("***** removeIf (x == 12) ******");
		Predicate<Integer> filter = x -> x == 12;
		coll.removeIf(filter);
		
		System.out.println("3: " + coll);
		
		/*
		 * contains(Object)
		 */
		System.out.println("*** contains(13) ****");
		System.out.println(coll.contains(13));
		
		/*
		 * int size()
		 */
		System.out.println("*** size(): " + coll.size() + " ***");
		
		/*
		 * boolean isEmpty()
		 */
		System.out.println("isEmpty: " + coll.isEmpty());
		
		/*
		 * witere Methoden ( mit Functional - Parametr) werden im Project 'Functional' sntersucht
		 */
	}
	
}
