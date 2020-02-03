package streams;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class B04_intermediate_map {

	public static void main(String[] args) {
		
		/*
		 * <R> Stream<R> map(Function<? super T, ? extends R> mapper)
		 */
		Function<Integer, String> mapper = x -> "<" + x + ">";
		
		Consumer<String> c = System.out::println;
		
		Stream.of(1,2,3)  // Stream<Integer>
			.map(mapper)  // Stream<String>
			.forEach(c);
		
		
		kleineAufgabe();
	}
	
	static void kleineAufgabe() {
		System.out.println("***** Aufgabe *****");
		
		class Person {
			String name;

			public Person(String name) {
				super();
				this.name = name;
			}
			@Override
			public String toString() {
				return "Person " + name;
			}
		}
		
		String[] namen = {
				"Peter", "Paul", "Mary"
		};
		
		Function<String, Person> mapper = new Function<String, Person>() {
			public Person apply(String t) {
				return new Person(t);
			}
		};
		
		Arrays.stream(namen)
			.map(x -> new Person(x))
			.forEach(System.out::println);
		
		Stream.of(namen)
			.map(x -> new Person(x))
			.forEach(System.out::println);
		
	}
	
}
