package functional;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Predicate;

/*
 * Typ 1. referenz auf eine statische Methode
 * 
 * Voraussetzungen: 
 * 
 * - Die ''geplannte' Realisierung der abstrakte Methode (hier 'test') besteht nur aus dem Aufruf einer statische Methode
 * - Die Liste der Parameter der statischen Methoden entspricht det Liste der Parameter der abstrakten Methoden (IS-A wird Akzeptiert)
 * - Falls die abstrakte Methode die return Anweisung hat, muss der Ruckgabe Typ der statische Methode mit dem typ der abstrakten Methode 'kompativel' sein.
 */
class MyUtils1 {
	static boolean isNotLeer(String s) {
		return s!=null && !s.isEmpty();
	}

	static int random(Number i1, Number i2) {
		return new Random().nextInt();
	}
}



public class B14_Method_reference_Type1 {

	public static void main(String[] args) {
		
		/*
		 * Mit anonyme Klasse
		 */
		Predicate<String> p0 = new Predicate<String>() {
			public boolean test(String s) {
				return MyUtils1.isNotLeer(s);
			}
		};
		
		/*
		 * Mit Lambda
		 */
		Predicate<String> p1 = s -> MyUtils1.isNotLeer(s);
		
		/*
		 * Mit einer Referenz auf eine statische Methode
		 */
		String s = "Hello";
		Predicate<String> p2 = MyUtils1::isNotLeer;
		System.out.println(p2.test(s)); // true
		s = null;
		System.out.println(p2.test(s)); // false
		
		
		
		kleineAufgabe();
		
	}
	
	
	
	static void kleineAufgabe() {
		
		Comparator<Integer> c0 = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return MyUtils1.random(i1, i2);
			}
		};
		
		Comparator<Integer> c1 = (i1, i2) -> MyUtils1.random(i1, i2);
				
		Comparator<Integer> c2 = MyUtils1::random;
	}
	
	
	
	
}
