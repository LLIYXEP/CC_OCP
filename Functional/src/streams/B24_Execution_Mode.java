package streams;

import java.util.stream.Stream;

public class B24_Execution_Mode {

	public static void main(String[] args) {
		
		/*
		 * Zwischenvariablen von Typ 'Stream' sollten in der Praxis vermieden werden.
		 * 
		 * Hier ist sie da nur fur eine Untersuchung
		 */
		
		System.out.println("------------------");
		
		Stream<Integer> s1 = Stream.of(1, 2, 3);
		
		System.out.println("Ist Execution Mode paralleel " + s1.isParallel()); // false
		
		s1.parallel(); // Execution Mode von sequenzial auf parallel setzen
		
		System.out.println("Ist Execution Mode parallel " + s1.isParallel()); // true
		
		s1.sequential(); // Execution Mode von parallel auf sequenzial setzen
		
		System.out.println("Ist Execution Mode parallel " + s1.isParallel()); // false
		
		s1.forEach(System.out::println);
		
		
	}
	
}
