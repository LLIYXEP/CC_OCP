package streams;

import java.util.stream.Stream;

public class B23_Stream_Objekte {

	public static void main(String[] args) {
		
		/*
		 * Zwischenvariablen von Typ 'Stream' sollten in der Praxis vermieden werden.
		 * 
		 * Hier sind sie da nur fur eine Untersuchung
		 */

		
		Stream<Integer> s1 = Stream.of(1, 2, 3);
		
		System.out.println("s1: " + s1); // java.util.stream.ReferencePipeline$Head@39a054a5
		
		Stream<Integer> s2 = s1.map(x -> x+1);
		
		System.out.println("s2: " + s2); // java.util.stream.ReferencePipeline$3@65e579dc
		
		/*
		 * Achtung! Nue eine Operation ist mit einem Stream-Objekt moglich
		 */
		
//		s1.filter(x -> true); // java.lang.IllegalStateException: stream has already been operated upon or closed
		
		s2.forEach(System.out::println);
		
		
	}
	
}
