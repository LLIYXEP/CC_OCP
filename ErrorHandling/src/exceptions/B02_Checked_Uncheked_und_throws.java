package exceptions;

import java.io.IOException;

/*
 * Checked : Der Compiler uberpruft ob eine geworfene (oder potentioll moglische)
 * checked Exc im Code beruksichtigt wurde:
 *  - entweder mit try/catch abgefangen
 *  - oder mit throw deklariert
 *  
 *  Dazu: intelligente try-Analyze fur die checked Exceptions
 */

public class B02_Checked_Uncheked_und_throws {
	
	static void m0() {
		throw new NullPointerException();
	}
	
	static void m1() throws NullPointerException {
		
	}
	static void m2() throws IOException {
		throw new IOException();
	}
	static void m3() throws IOException {
//		throw new IOException();
	}
	static void m4() {
//		throw new IOException(); // CF must have throws
	}
	static void m5() {
		try {
			throw new IOException(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void m6()  {
		try {
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	static void m7()  {
		try {
			
		} catch (IOException e) { 	// CF unricheble catch code - intelligente try-Analyze fur die checked Exceptions, im ty ist keine IOException
			e.printStackTrace();
		}
	}
	static void m8()  {
		try {
			
		} catch (Exception e) { 	// OK - basistyp auch fur unchecked Exc
			e.printStackTrace();
		} catch (Throwable e) {		// OK - basistyp auch fur unchecked Exc
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		m0();
		m1();
//		m2(); //CF
//		m3(); //CF
		m4();
		m5();
		
	}
	
}
