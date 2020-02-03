package aufgaben.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class AufgabeCollectNumbers {

	public static void main(String[] args) {
		
		String[] arr = {
				"1,2,3,4,5",
				"7,6,5,4,3",
				"123,456",
			};
			
			List<Integer> list;
			
			// A
			list = new ArrayList<>();
			for (String s : arr) {
				String[] stringNumbers = s.split(",");
				
				for (String sNum : stringNumbers) {
					Integer num = Integer.valueOf(sNum);
					list.add(num);
				}
			}
			// B
			
			System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
			
			
		
			Supplier<List<Integer>> supplier = () -> new ArrayList();
			
			BiConsumer<List<Integer>, String> accumulator = (lst,element) -> {
				String[] stringNumbers = element.split(",");
				
				for (String sNum : stringNumbers) {
					Integer num = Integer.valueOf(sNum);
					lst.add(num);
				}
			};
			
			BiConsumer<List<Integer>, List<Integer>> combiner = (a,b) -> a.addAll(b);;
			
			list = Arrays.stream(arr).collect(supplier, accumulator, combiner);
	
			System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
			
			a1a(arr);
			a1b(arr);
			a2c(arr);
			
	}
	
	static void a2c(String[] arr) {
		System.out.println("Aufgabe 2");
		
		List<Integer> list = Arrays.stream(arr)	// Stream String
				.map( str -> str.split(","))    // Stream String[]   	<- z.B : das letzte Element wird {"123", "456"}
				.flatMap( Arrays::stream ) // Stream String				<- Elemente: "1","2","3"..."456"
				.map( Integer::valueOf )	// Stream<Integer>
				.filter( x -> x % 2 == 0)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		System.out.println(list); // [2, 4, 6, 4, 456]
	}
	
	static void a1b(String[] arr) {
		Supplier<List<Integer>> supplier = () -> new ArrayList();
		
		BiConsumer<List<Integer>, Integer> accumulator = (lst,element) -> lst.add(element);
		
		BiConsumer<List<Integer>, List<Integer>> combiner = (a,b) -> a.addAll(b);;
		
		List<Integer> list = Arrays.stream(arr)	// Stream String
				.map( str -> str.split(","))    // Stream String[]
				.flatMap( strArr -> Arrays.stream(strArr)) // Stream String
				.map( str -> Integer.valueOf(str))	// Stream<Integer>
				.collect(supplier, accumulator, combiner);

		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
	}
	
	static void a1a(String[] arr) {
		Supplier<List<Integer>> supplier = () -> new ArrayList();
		
		BiConsumer<List<Integer>, String> accumulator = (lst,element) -> {
			String[] stringNumbers = element.split(",");
			
			for (String sNum : stringNumbers) {
				Integer num = Integer.valueOf(sNum);
				lst.add(num);
			}
		};
		
		BiConsumer<List<Integer>, List<Integer>> combiner = (a,b) -> a.addAll(b);;
		
		List<Integer> list = Arrays.stream(arr).collect(supplier, accumulator, combiner);

		System.out.println(list); // [1, 2, 3, 4, 5, 7, 6, 5, 4, 3, 123, 456]
	}
	
}
