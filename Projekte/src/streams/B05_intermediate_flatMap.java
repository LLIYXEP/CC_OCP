package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class B05_intermediate_flatMap {

	public static void main(String[] args) {
		
		List<Integer> listA	= Arrays.asList(1, 2);
		List<Integer> listB	= Arrays.asList(11, 12);
		List<Integer> listC	= Arrays.asList(7, 8);
		
		System.out.println("******* vgl. mit concat *****");
		/*
		 * mehr als 2 Listen als Datenquelle fur eine Pipeline: mit concat unbequem
		 */
		Stream<Integer> streamAB = Stream.concat(listA.stream(), listB.stream());
		
		Stream.concat(streamAB, listC.stream())
			.forEach(System.out::println);
		
		/*
		 * <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
		 */
		System.out.println("******* flatMap *****");
		
//		Function<List<Integer>, Stream<Integer>> mapper = list -> list.stream();
		Function<List<Integer>, Stream<Integer>> mapper = List::stream; // Typ 4
		
		Stream.of(listA, listB, listC)
			.flatMap(mapper)
			.forEach(System.out::println);
		
	}
	
}
