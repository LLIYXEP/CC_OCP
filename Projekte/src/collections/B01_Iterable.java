package collections;

import java.util.Arrays;
import java.util.function.Consumer;


public class B01_Iterable {

	public static void main(String[] args) {
		
		Iterable<Integer> iterable = Arrays.asList(11, 12, 13);
		
		/*
		 * void forEach(Consumer<? super T> action)
		 */
		
		Consumer<Integer> action = i -> System.out.println("i = " + i);
		iterable.forEach(action);
		
		
		
		
	} // end of main
	
}
