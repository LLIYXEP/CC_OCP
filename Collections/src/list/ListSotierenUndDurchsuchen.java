package list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSotierenUndDurchsuchen {

	public static void main(String[] args) {
		
		List<Integer> listInt = Arrays.asList(4,2,5,1);
		
		System.out.println("1. listInt: " + listInt); // [4, 2, 5, 1]
		
		/*
		 * sort(list)
		 */
		Collections.sort(listInt);
		System.out.println("2. listInt: " + listInt); // [1, 2, 4, 5]
		
		/*
		 * sort(list, Comparator)
		 */
//		Comparator<Integer> cmp = (a,b) -> b - a;
		Comparator<Integer> cmp = Collections.reverseOrder();
		Collections.sort(listInt, cmp);
		System.out.println("2. listInt: " + listInt); // [5, 4, 2, 1]
		
		/*
		 * int binarySearch(List list, E key)
		 */
		System.out.println("FALSCHE Suchen nach 2. die Liste ist nicht 'nuturlich' aufsteigend sortiert");
		int pos = Collections.binarySearch(listInt, 2);
		System.out.println("pos " + pos); // -1
		
		/*
		 * int binarySearch(List list, E key, Comparator cmp)
		 */
		
		System.out.println("Richtige Suchen nach 2. den Comparator ubergeben");
		pos = Collections.binarySearch(listInt, 2, cmp);
		System.out.println("pos " + pos); // 2
	}
	
}
