package exceptions;

import java.io.Closeable;
import java.io.IOException;

public class B12_try_with_resources_und_supressed_Exception {
	
	static class Res01 implements Closeable{
		@Override
		public void close() {
			throw new RuntimeException("e2");
		}
	}
	
	public static void main(String[] args) {
		
		/*
		 * Die im try-Block geworfene Exception (e1) wird nicht von der in close - Methode geworfen Exception (e2)
		 * unterdruckt und taucht im cathch- block als 'Hauptexception' auf.
		 * 
		 * Umgekehrt. falls beim close-aufru eine weitere Exc geworfen wird.
		 * wird sie als supressed Exc in der Hauptexc
		 */
		try (Res01 res = new Res01()) {
			throw new RuntimeException("e1");		//'Hauptexception'
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("Suppressed");
			Throwable[] suppressed = e.getSuppressed();
			for (Throwable throwable : suppressed) {
				System.out.println(throwable.getMessage());
			}
		}
		
		
	}

}
