package io;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class B05_mark_reset_skip {
	
	public static void main(String[] args) throws IOException {
		
//		testSkip();
		testMarkAndReset();
		
	}
	
	
	static void testMarkAndReset() throws IOException {
		
		/*
		 * Methode 'Mark And Reset'
		 */
		try(Reader in = new StringReader("aXbYcZd")) {
			
			/*
			 * 0123456
			 * aXbYcZd
			 * |<- Virtueller Zeiger, gesetzt auf den 1 Zeichen im Input
			 */
			
			System.out.println((char)in.read()); // a geliefert, Zeiger verschoben
			
			/*
			 * 0123456
			 * aXbYcZd
			 *  |<- Virtueller Zeiger, gesetzt auf den 1 Zeichen im Input
			 */
			int readAheadLimit = 10;
			in.mark(readAheadLimit); //  Amrkirung setzen
			
			in.read();
			in.read();
			
			/*
			 * 0123456
			 * aXbYcZd
			 *    |<- Virtueller Zeiger, gesetzt auf den 1 Zeichen im Input
			 */
			
			in.reset(); // den Zeiger zu der Markierung zuruckschieben
			
			/*
			 * 0123456
			 * aXbYcZd
			 *  |<- Virtueller Zeiger, gesetzt auf den 1 Zeichen im Input
			 */
			
			System.out.println((char)in.read()); // X geliefert, Zeiger verschoben
		}
		
	}

	static void testSkip() throws IOException {
		
		/*
		 * Methode 'skip'
		 */
		try(Reader in = new StringReader("aXbYcZd")) {
			
			/*
			 * 0123456
			 * aXbYcZd
			 * |<- Virtueller Zeiger, gesetzt auf den 1 Zeichen im Input
			 */
			System.out.println((char)in.read()); // a geliefert, Zeiger verschoben
				
			/*
			 * 0123456
			 * aXbYcZd
			 *  |<- Virtueller Zeiger
			 */
			System.out.println((char)in.read()); // X geliefert, Zeiger verschoben
			
			/*
			 * 0123456
			 * aXbYcZd
			 *   |<- Virtueller Zeiger
			 */
			in.skip(3);   // den Zeiger 3 Elemente weiter schieben
			
			/*
			 * 0123456
			 * aXbYcZd
			 *      |<- Virtueller Zeiger
			 */
			System.out.println((char)in.read()); // Z geliefert, Zeiger verschoben
			
			/*
			 * 0123456
			 * aXbYcZd
			 *       |<- Virtueller Zeiger
			 */
			System.out.println((char)in.read()); // d geliefert, Zeiger verschoben
		}
		
	}
	
}
