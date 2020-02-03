package functional;

import java.io.Serializable;
import java.util.Comparator;
import java.util.function.Predicate;

/*
 * Functionales Interface hat genau eine abstrakte Methode
 */

interface I1 { // funktionales Interface
	void m();
}

@FunctionalInterface // nurzur Kontrolle ob es wirklich ein funcktionales Interface ist
interface I2 {
	void m();
}

//@FunctionalInterface		// CF , zwei abstrakte Methoden
//	void m1();
//	void m2();
//}

@FunctionalInterface 
interface I4 {
	void m1();
	String toString(); // Ok , es gibt die Methode in der Klasse Objekt (ind somit in jeder Klasse)
}

public class B01_FunctionalInterface {

	/*
	 * Aus de Standartbibliotek:
	 */
	Comparable<String > c1 = new Comparable<String>() {
		public int compareTo(String o) {
			return 0;
		}
	};
	
	Comparator<String> cmp1 = new Comparator<String>() {
		public int compare(String s1, String s2) {
			return 0;
		}
	};
	
	Runnable r1 = new Runnable() {
		public void run() {
		}
	};
	
	Predicate<String> p1 = new Predicate<String>() {
		public boolean test(String s) {
			return false;
		}
	};
	
}
