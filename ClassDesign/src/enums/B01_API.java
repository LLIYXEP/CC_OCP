package enums;

import java.util.Arrays;

public class B01_API {
	
	enum Color{
		RED, GREEN, BLUE;
		
		Color(){} // implizit private
		
	}

	public static void main(String[] args) {
		
		Color c = Color.RED;
		/*
		 * Jede enum-Klasse erbt von der Klasse java.lang.Enum
		 */
		System.out.println("Jede enum-Klasse erbt von der Klasse java.lang.Enum");
		System.out.println(Color.BLUE instanceof Enum);
		
		System.out.println("Jede enum-Klasse implementiert Comparable");
		System.out.println(Color.BLUE instanceof Comparable);	  // true
		System.out.println(Color.RED.compareTo(Color.GREEN) < 0); // true
		System.out.println(Color.GREEN.compareTo(Color.BLUE) < 0); // true
		
		System.out.println("Alle Konstruktoren einer enum-klasse sind private");
//		new Color();
		
		System.out.println("*************");
		System.out.println(Color.values() instanceof Color[]);
		System.out.println(Arrays.toString(Color.values())); // [RED, GREEN, BLUE]
		
		System.out.println("*** statische Methode valueOf(String) ***");
		System.out.println(Color.valueOf("BLUE"));
		
		System.out.println("Die enum Konstanten sind statische");
		System.out.println("Color.RED: " + Color.RED);
		
		System.out.println("Die enum uberschreibt die toString");
		System.out.println("Color.RED: " + Color.RED);
		
		System.out.println("**** Jede enum-klasse hat die final - Methode name() *****");
		System.out.println("Color.RED.name(): " + Color.RED.name());
		
		System.out.println("**** Jede enum-klasse hat die final - Methode ordinal() *****");
		System.out.println("Color.RED.ordinal(): " + Color.RED.ordinal());
		
	}
	
}
