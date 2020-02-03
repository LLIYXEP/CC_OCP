package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class B15_generische_Methoden {

	public static void main(String[] args) {
		
//		Collections.sort(list);
		
		// Collection ist ein generischen Typ mit dem Typparameter E
		Collection<Integer> coll = new ArrayList<Integer>();
		
		coll.add(12); // add(E e)
		
		/*
		 * toArray ist eine generische Methode mmit dem eigenen Typparameter T
		 */
		Object[] arrA = new Object[3];
		Object[] resA = coll.toArray(arrA); // <T> T[] toArray(T[] a)   -> Object[] toArray(Object[] a)
		
		Integer[] arrB = new Integer[3];
		Integer[] resB = coll.toArray(arrB); // <T> T[] toArray(T[] a)   -> Integer[] toArray(Integer[] a)
		System.out.println(resB[0]);
		
//		String[] arrC = new String[3];
//		String[] array = coll.toArray(arrC); // <T> T[] toArray(T[] a)   -> String[] toArray(String[] a)
//		System.out.println(array[0]);
		
		/*
		 * Collections ist eine nicht-generische Klasse,
		 * 
		 * sort ist eine generische Methode
		 * 
		 * <T extends Comparable<? super T>> void sort(List<T> list)
		 * 
		 * 			T extends Comparable<T> - rekursiver 'Type bound'
		 */
		List<String> list = new ArrayList<String>();
		Collections.sort(list); // void sort(List<String> list) : type bound OK, String ist Comparable<String>
	}
	
}
