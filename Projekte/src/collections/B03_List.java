package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.function.UnaryOperator;

public class B03_List {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(12,13,14);
		
		/*
		 * oid sort(Comparator<? super E> c)
		 */
		Comparator<Integer> cmp = Comparator.reverseOrder();
		list.sort(cmp);
		
		System.out.println(list); // [14, 13, 12]
		
		/*
		 * void replaceAll(UnaryOperator<E> operator)
		 */
		
		UnaryOperator<Integer> operator = x -> x + 1;
		list.replaceAll(operator);
		
		System.out.println(list); // [15, 14, 13]

		
		
	}
	
}
