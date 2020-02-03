package aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AufgabeGenerischeMethodenFunctional {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		Predicate<Integer> isEven = i -> i % 2 == 0;
		System.out.println( count(list1, isEven) ); // 2  

		Predicate<Number> isNotNull = b -> b.intValue() % 2 != 0;
		List<Number> list2 = Arrays.asList(1, 1.2, 3, 3.4);
		System.out.println( count(list2, isNotNull) ); // 4  
		
		Predicate<String> isEmpty = String::isEmpty;
		List<String> list3 = Arrays.asList("a", "", "b", "", "c");
		System.out.println( count(list3, isEmpty) ); // 2 
		
//		System.out.println(count(list1, isEmpty)); // darf nich Compilieren
	}
	
	static <T> int count(List<T> list, Predicate<T> p) {
		int cnt = 0;
		
		for (T e : list) {
			if (p.test(e)) {
				cnt++;
			}
		}
		return cnt;
	}
	
}
