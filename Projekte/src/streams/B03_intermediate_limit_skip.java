package streams;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class B03_intermediate_limit_skip {

	public static void main(String[] args) {
		
		/*
		 * limit(long max)
		 */
		long max = 3;
		
		UnaryOperator<Integer> op = x -> x+1;
		
		System.out.println("****** limit: *******");
		
		Stream.iterate(1, op)
			.limit(max)
			.forEach(System.out::println);
		
		
		/*
		 * skip(long max) // how much elemente to skip
		 */
		
		long toSkip = 3;
		
		System.out.println("****** skip: *******");
		Stream.iterate(1, op)
			.skip(toSkip)
			.limit(3)
			.forEach(System.out::println);
	}
	
}
