package io;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/*
 * Es gibt keine IOExceptions in der Prüfung aus den Methoden skip, mark und reset. 
 * In der Praxis ist es anders.
 */
public class B05_mark_reset_skip {

	public static void main(String[] args) throws IOException {
		testSkip();
		testMarkAndReset();
	}
	
	public static void testMarkAndReset() throws IOException {
		System.out.println("*** mark, reset");
		
		try(Reader in = new StringReader("aXbYcZd")) {
			
//			0123456
//			aXbYcZd
//		    | <- virtueller Zeiger, gesetzt auf das 1. Zeichen im Input
			
			System.out.println( (char)in.read() ); // a geliefert, Zeiger verschoben
			
//			0123456
//			aXbYcZd
//		     | <- virtueller Zeiger
			
			int readAheadLimit = 10;
			in.mark(readAheadLimit);  // Markierung setzen
			
			
			in.read(); // Zeiger verschoben
			in.read(); // Zeiger verschoben
			
//			0123456
//			aXbYcZd
//		       | <- virtueller Zeiger
			
			in.reset(); // den Zeiger zu der Markierung zurückschieben

//			0123456
//			aXbYcZd
//		     | <- virtueller Zeiger

			System.out.println( (char)in.read() ); // X geliefert, Zeiger verschoben
			
//			0123456
//			aXbYcZd
//		      | <- virtueller Zeiger
		}
	}
	
	public static void testSkip() throws IOException {
		System.out.println("*** skip");
		
		try(Reader in = new StringReader("aXbYcZd")) {
			
//			0123456
//			aXbYcZd
//		    | <- virtueller Zeiger, gesetzt auf das 1. Zeichen im Input

			System.out.println( (char)in.read() ); // a geliefert, Zeiger verschoben
			
//			0123456
//			aXbYcZd
//		     | <- virtueller Zeiger
			
			System.out.println( (char)in.read() ); // X geliefert, Zeiger verschoben
			
//			0123456
//			aXbYcZd
//		      | <- virtueller Zeiger
			
			
			/*
			 * Methode 'skip(long)'
			 */
			in.skip(3); // den Zeiger 3 Elemente weiter schieben
			
//			0123456
//			aXbYcZd
//		         | <- virtueller Zeiger
			
			System.out.println( (char)in.read() ); // Z geliefert, Zeiger verschoben
			
//			0123456
//			aXbYcZd
//		          | <- virtueller Zeiger
		}
		

	}

}
