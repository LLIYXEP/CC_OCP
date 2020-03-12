package kap01;

import java.util.Arrays;

interface Bb {
	static class Aa{
		
	}
	
	interface Cc {
		
	}
}

interface I9 {
	 private void m0() {} // Java 11, nicht in Java 8
	 
	 private static void m1() {} // Java 11, nicht in Java 8
	 
	 void m2(); // abstract
	 abstract void m2b(); 
	 
	 default void m3() {}
	 
	 static void m4() {}
	 
//	 final void m5() {}
//	 final void m6();
//	 final default void m6();
	 
	 int x1 = 0; // static final
	 
}

public class Q9 {
	

	public static void main(String[] args)  {
		
		
		try {
			Thread.sleep(1000);
			System.out.println("A");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("B");
		}
		
	}
	
}
