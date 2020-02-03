package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class B02_Collection {

	public static void main(String[] args) {
		
		Collection<Integer> coll = Arrays.asList(12,13,14);
		
		/*
		 * boolean removeIf(Predicate<? super E> filter)
		 */
		
		Predicate<Integer> filter = x -> x % 2 != 0;
		
		coll = new ArrayList<Integer>(coll);
		
		coll.removeIf(filter); // Exception (List aus Arrays.asList kann man nicht reduzieren)
		
		coll.forEach(System.out::println);
		
		/*
		 * Methoden fur Streams
		 * 
		 * Stream<E>	stream();
		 * Stream<E>    parallelStream();
		 */
		
		coll.stream();
		coll.parallelStream();
		
	}
	
}
