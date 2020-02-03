package set;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class NavigableSetMitTreeSet {

	public static void main(String[] args) {
		
		TreeSet<Integer> basisSet = new TreeSet<Integer>();
		
		basisSet.add(33);
		basisSet.add(17);
		basisSet.add(-9);
		
		System.out.println(basisSet); //[-9, 17, 33]
		
		// Suche nach einem Element
		
		/*
		 * first(), last()
		 */
		Integer first = basisSet.first();
		System.out.println("first(): " + first);
		
		Integer last = basisSet.last();
		System.out.println("last(): " + last);
		
		/*
		 * ceiling(int)
		 */
		Integer ceiling = basisSet.ceiling(0); // gesucht Element >= 0
		System.out.println(ceiling);
		
		System.out.println(basisSet.ceiling(17)); // 17
		System.out.println(basisSet.ceiling(100)); // null
		
		/*
		 * floor(int)
		 */
		Integer x = basisSet.floor(19); // gesucht Element <= 19
		System.out.println(x); // 17
		
		/*
		 * higher(int)
		 */
		x= basisSet.higher(17); 
		System.out.println(x); // 33
		
		/*
		 * lower(int)
		 */
		x = basisSet.lower(17); // gesucht Element < 17
		System.out.println(x); // -9
		
		/*
		 * Suche nach Untermengen ( die evtl. meherere Elemente beinhalten)
		 */
		System.out.println("*********");
		System.out.println("basisset: " + basisSet); // HEAD [-9, 17, 33] TAIL
		
		/*
		 * headSet(2 mal uberladen)
		 */
		Integer toElement = 33;
		SortedSet<Integer> headSet1 = basisSet.headSet(toElement); // Obergrenze exklusive
		System.out.println("headSet(33) : " + headSet1); // [-9, 17]
		
		boolean inclusive = true;
		NavigableSet<Integer> headSet2 = basisSet.headSet(toElement, inclusive);

		System.out.println("headSet(33, true): " + headSet2); // [-9, 17, 33]
		
		/*
		 * tailSet(2 mal uberladen)
		 */
		Integer fromElement = 17;
		SortedSet<Integer> tailSet = basisSet.tailSet(fromElement); // Untergrenze inklusive
		System.out.println("tailSet(17): " + tailSet); // [17, 33]
		
		NavigableSet<Integer> tailSet2 = basisSet.tailSet(fromElement, false);
		System.out.println(tailSet2); // [33]
		
		/*
		 * subSet(2 mal uberladen)
		 */
		fromElement = -9;
		toElement = 33;
		SortedSet<Integer> subSet = basisSet.subSet(fromElement, toElement);
		System.out.println(subSet); // [-9, 17]
//		subSet.add(44); // IllegalArgumentException: key out of range
		
		subSet = basisSet.subSet(fromElement, false, toElement, true);
		System.out.println(subSet); // [17, 33]

		System.out.println("headSet(33, true): " + headSet2); // headSet2
		

		
		/*
		 * Achtung! headSet, tailSet, und subSet liefern backed (gekoppelte) Collections zuruck.
		 */
		System.out.println("********* backed collections test ******");
		System.out.println("basisset: " + basisSet); // HEAD [-9, 17, 33] TAIL
		
		SortedSet<Integer> tailSet3 = basisSet.tailSet(0); // [17, 33]
		System.out.println(tailSet3);
		
		basisSet.add(-11);
		basisSet.add(5);
		System.out.println(basisSet); // [-11, -9, 5, 17, 33]
		System.out.println(tailSet3); // [5, 17, 33]
		
		tailSet3.add(177);
		System.out.println(basisSet); // [-11, -9, 5, 17, 33, 177]
		System.out.println(tailSet3); // [5, 17, 33, 177]
		
//		tailSet3.add(-1); // IllegalArgumentException: key out of range
		
		SortedSet<Integer> subSet2 = basisSet.subSet(5, 100);
		subSet2.add(5); // OK
//		subSet2.add(100); // EXC
		subSet2.add(99); // EXC
		System.out.println(basisSet); // [-11, -9, 5, 17, 33, 99, 177]
		System.out.println(subSet2); // [5, 17, 33, 99]
		
		
		
		
	}
	
}
