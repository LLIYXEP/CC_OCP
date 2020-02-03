package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Erasing: der Compiler loscht die Parametrisierungen beim Ubersetzen, fugt (unsichtbar) an vielen Stellen Laufzeitkontrollen hinzu.
 */

public class B06_Erasing {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(12);
		
		System.out.println(list.getClass()); // class java.util.ArrayList
		
		/*
		 * Exam:
		 */
		Object[] arr = {
			12,
			"22"
		};
		
		Arrays.sort(arr); // ClassCastException : Integer connot be cast tp String

		/*
		 * Nicht in der Prufung: wo es im Code das Casting gibt
		 * 
		 * aus der sort:
		 */
		Object[] a = arr;
		Comparable pivot = (Comparable) a[1];
//		pivot.compareTo(a[0]); // ClassCastException: Integer can not be casted to String (s. nechst beisp.)
		System.out.println(pivot);
		
		
		
	}
	
}
