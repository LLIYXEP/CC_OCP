package streams;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class B08_intermediate_peek {

	public static void main(String[] args) {
		
		Consumer<Integer> action = x -> {
			System.out.println("x = " + x);
		};
		
		Stream.of(1,2,3,4,5)
			.peek(action)
			.map( x -> ++x)
			.peek(action)
			.forEach(System.out::println);
		
		
		System.out.println("********* Exam ********");
		
		Stream.of(1,2,3,4,5)
			.peek(action); // Achtung! Keine Ausgaben (keine terminal Operation)
	}
	
}
