package exceptions;

import java.io.IOException;

/*
 * Keine erweitere checked - Exceptions in der throws - Klausel beim Uberschreiben
 */

class Strasse {
//	 public String toString() throws IOException{return "";} // CF

	void m1() {}
	void m2() throws IOException {}
	void m3() throws Exception {}
	void m4() throws Exception {}
	
}

class Gasse extends Strasse{
	void m1() throws NullPointerException {}
	void m2() {}
	void m3() throws IOException {}
//	void m4() throws Throwable {} // CF
}

public class B03_checked_beim_Uberschreiben {

	public static void main(String[] args) {
		
		
		
	}
	
}
