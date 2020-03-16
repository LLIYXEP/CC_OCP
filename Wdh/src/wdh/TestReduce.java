package wdh;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class TestReduce {

	public static void main(String[] args) {
		
		BinaryOperator<Integer> accumulator = (x,y) -> x - y;
		
		Optional<Integer> maybeZ = Stream.of(1,2,3,4)
								.parallel()
								.reduce(accumulator);
		
		System.out.println(maybeZ.get()); // 0
		
		Integer reduce = Stream.of(1,2,3,4)
				.parallel()
				.reduce(2, accumulator);
		
		System.out.println(reduce); // 0
		
		BiFunction<Integer, Integer, Integer> acc2 = (x, y) -> x + y;
		BinaryOperator<Integer> combiner = (x,y) -> {
			System.out.println("asas");
			return x + y;
		};
		
		Integer reduce2 = Stream.of(1,2,3,4)
//				.parallel()
				.reduce(2, acc2, combiner);
		
		System.out.println(reduce2); // 12
		
		/*
		 * 
		 */
		
		System.out.println("***** reduce , die den Typ andert");
		
		BiFunction<String, Integer, String> acc3 = (x, y) -> x.concat(String.valueOf(y));
		BinaryOperator<String> cmb3 = (s1, s2) -> s1.concat(s2);
		
		String erg3 = Stream.of(1,2,3,4)
//			.parallel()
			.reduce("", acc3, cmb3);
		
		System.out.println(erg3); // sequenziell 1234
									// parallel: 
		
	}
	
}
