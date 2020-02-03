package exceptions;

import java.io.IOException;

public class B07_rethrow {
	
	static void m1() {
//		throw new Exception();	// CF
	}
	
	static void m2() {
		throw new RuntimeException();
	}
	
	static void m3() {
		 Exception e = new RuntimeException();
//		 throw e;	// CF
	}
	
	static void m4() {
		try {	
			// hier keine checked Exc moglich
		} catch (Exception e) {
			throw e;	// rethrow OK, nach der try - Analyse weist der Compiler, dass es keine checked Exc geben kann und dass e eine unchecked-exc referenziert
		}
	}
	
	static void m5() {
		try {
			throw new IOException();
		} catch (Exception e) {
//			throw e;	// CF : IOException moglich
		}
	}
	
	static void m6() throws IOException {
		try {
			throw new IOException();
		} catch (Exception e) {
			throw e;	// rethrow OK. Der Compiler hat den try analysiert: nur IOExc als checked Exc hier moglich ist
		}
	}
	
	/*
	 * Achtung! Rethrowing funktioniert nur mit 'effectively final' catch Parameter
	 */
	static void m7() {
		try {
			
		} catch (Exception e) {
			e = new ArithmeticException();
			throw e; // CF : nicht 'effectively final'
		}
	}
	

	public static void main(String[] args) {
		
		m4();
		
	}
	
}
