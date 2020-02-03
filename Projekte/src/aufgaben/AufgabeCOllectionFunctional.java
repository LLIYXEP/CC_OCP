package aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AufgabeCOllectionFunctional {

	public static void main(String[] args) {
		//1
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
		
		list = new ArrayList<Integer>(list);
		
		list.removeIf(x -> x%2 != 0);
		
		list.forEach(x -> System.out.print(x + ", "));
		System.out.println();
		//2
		list = Arrays.asList(1,2,3,4,5,6,7,8);
		
		list.replaceAll(x -> x+1);
		
		list.forEach(x -> System.out.print(x + ", "));
		
		System.out.println();
		//3
		list = Arrays.asList(1,2,3,4,5,6,7,8);
		
		list.sort((a,b) -> b - a);
//		list.sort(new Comparator<Integer>() {
//			public int compare(Integer o1, Integer o2) {
//				return o2 - o1;
//			};
//		});
		
		list.forEach(x -> System.out.print(x + ", "));
		
		
		
	}
	
}
