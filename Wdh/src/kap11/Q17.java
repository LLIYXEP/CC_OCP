package kap11;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q17 {

	public static void main(String[] args) {
		
		String[] arr = {"aa", "bb", "cc" };
		
		Stream//.of(arr, arr)
			.generate(() -> arr)
			.limit(2)
			.flatMap(s -> Stream.of(s))
			.forEach(System.out::println);
		
	}
	
}
