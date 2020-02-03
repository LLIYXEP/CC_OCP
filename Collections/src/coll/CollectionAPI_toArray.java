package coll;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class CollectionAPI_toArray {

	public static void main(String[] args) {
		
		Collection<Integer> coll = new LinkedList<>();
		coll.add(12);
		coll.add(13);
		coll.add(14);
		
		/*
		 * Object [] toArray()
		 */
		Object[] arr1 = coll.toArray();
		System.out.println("arr1-Typ: " + arr1.getClass().getName()); // <- Object - Array
		
		Integer x = (Integer) arr1[1]; // nicht bequem: Casting notig
		System.out.println("x: " + x); // 13
		
		/*
		 * <T> T[] toArray(T[] a);
		 */
		Integer[] arr2 = new Integer[5];
		Integer[] arr3 = coll.toArray(arr2);
		
		Integer y = arr2[1]; // bequem, kein Casting notig
		System.out.println("y: " + y);
		
		
		System.out.println("arr2 == arr3: " + (arr2 == arr3)); // true (Argument - Array war gross genug)
		System.out.println("arr3: " + Arrays.toString(arr3)); // [12, 13, 14, null, null]
		
		arr3 = coll.toArray(new Integer[0]); // ubergebenes Array ist zu klein. toArray erzeugt ein neues Array der passenden Grosse
		System.out.println("arr3: " + Arrays.toString(arr3)); // [12, 13, 14]
		
	}
	
}
