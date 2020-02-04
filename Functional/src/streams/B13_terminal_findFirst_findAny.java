package streams;

import java.util.Optional;
import java.util.stream.Stream;

public class B13_terminal_findFirst_findAny {

	public static void main(String[] args) {
		
		/*
		 * Optional<T> findFirst()
		 */
		
		Optional<Integer> maybeElement = Stream.of(1 ,2 ,3)
				.filter(x -> x%2 == 0)
				.findFirst();
		
		System.out.println(maybeElement.get()); // 2
		
		/*
		 * Optional<T> findAny();
		 */
		
		 Optional<Integer> maybeFirst = Stream.of(1 ,2 ,3).findAny();
		 
		 System.out.println(maybeFirst.get()); // 1
		
	}
	
}
