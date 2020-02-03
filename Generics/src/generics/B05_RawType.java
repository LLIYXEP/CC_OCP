package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/*
 * Bitte NIE raw types verwenden!!!
 */

public class B05_RawType {

	public static void main(String[] args) {
		
		List<Integer> listA; // List<Integer> - parametrisierte generische Typ
		
		listA = new ArrayList<>();
		
		listA.add(12);
		listA.add(13);
//		listA.add("hallo"); // CF
		
		/*
		 * Durch die raw type Variable gibt es keine Typsicherheit mehr.
		 */
		List listB; // List - raw type
		listB = listA;
		listB.add(55);
		listB.add("hallo"); // kein CF.  Typsicherheit verletzt
		System.out.println(listA); // [12, 13, 55, hallo]
		System.out.println(listB); // [12, 13, 55, hallo]
		
//		TreeSet set = new TreeSet(listA); //ClassCastException
	}
	
}
