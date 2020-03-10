package wdh.streams;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestIntStream {

	public static void main(String[] args) {
		
		Integer[] a1 = {1,2,3};
		
		Stream<Integer> s1 = Arrays.stream(a1);
		
		/*
		 * 
		 */
		int[] a2 = {1,2,3};
		
		IntStream s2 = Arrays.stream(a2);
		
		IntBinaryOperator op2 = (x,y) -> x*y;
		OptionalInt maybeProduct = s2.reduce(op2);
		
		System.out.println(maybeProduct.getAsInt()); // 6
		
		/*
		 * 
		 */
		int identity = 4;
		int reduce = Arrays.stream(a2).reduce(identity, op2);
		System.out.println(reduce); // 24
		
	}
	
}
