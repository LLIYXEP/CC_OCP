package generics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class B02_MitGenerics {

	public static void main(String[] args) {
		
		List<Object> listA = Arrays.asList(12, "22", 5);
		
		Collections.sort(listA); // <T extends Comparable> void sort(List<T>)  (<- vereinfacht Beschreibung dersort)
		
		List<Comparable<Integer>> listB = Arrays.asList(12, "22", 5); // <T> List<T> asList(T... a)
		Collections.sort(listB);
		
		List<Comparable<String>> listC = Arrays.asList(12, "22", 5); // <T> List<T> asList(T... a)
		Collections.sort(listC);
		
		
		
	}
	
}
