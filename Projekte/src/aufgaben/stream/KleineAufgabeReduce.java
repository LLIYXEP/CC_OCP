package aufgaben.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class KleineAufgabeReduce {

	public static void main(String[] args) {
		
		Integer[] zahlen = { 1, 2, 3, 4};
		
		// A1 Optional<T> reduce(BinaryOperator<T> accumulator);
		
		Integer result = Arrays.asList(zahlen).stream()
				.reduce((a,b) -> a * b)
				.get(); 
		
		System.out.println(result);
		
		/*
		 * <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
		 */
		
		BinaryOperator<Integer> op = (c,d) -> c * d;
		
		result = Arrays.asList(zahlen).stream().reduce(1, op, op);
		
		System.out.println(result);
		
		
	}
	
}
