package streams;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class B09_terminal_forEach {

	public static void main(String[] args) {
		
		Consumer<Integer> action = x -> System.out.println(x);
		
		Stream.of(1, 2, 3)
			.forEach(action);
		
		System.out.println("***** forEachOrdered ****");
		
		Stream.of(1, 2, 3, 4, 5, 6)
			.parallel()
//			.forEach(System.out::println);
			.forEachOrdered(System.out::println);
		
	}
	
}
