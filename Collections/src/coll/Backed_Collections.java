package coll;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Backed_Collections {
	
	/*
	 * s. die Methode List.subLIst
	 */
	
	
	/*
	 * <T>List<T> Arrays.asList(T... elements)
	 */

	public static void testAsList() {
		/*
		 * asList lieferte eine spezielle Liste , die an das ubergebene Array gekoppelt (backed) ist
		 */
		
		List<Integer> list = Arrays.asList(12, 13, 14);
		
		Integer[] array = {2, 3, 4};
		
		list = Arrays.asList(array);
		
		System.out.println("1 array: " + Arrays.toString(array)); // [2, 3, 4]
		System.out.println("1 list: " + list); // [2, 3, 4]
		
		// Array andern
		array[1] = -7;
		System.out.println("2 array: " + Arrays.toString(array)); //[2, -7, 4]
		System.out.println("2 list: " + list); //[2, -7, 4]
		
		// List andern
		list.sort(Comparator.naturalOrder());
		System.out.println("3 array: " + Arrays.toString(array)); // [-7, 2, 4]
		System.out.println("3 list: " + list); //[-7, 2, 4]
		
		System.out.println("list.get(1): " + list.get(1)); // 2
//		list.add(12); // UnsupportedOperationException
//		list.remove(0); //UnsupportedOperationException
	}
	
	public static void main(String[] args) {
		
		testAsList();
		
	}
	
}
