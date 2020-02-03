package functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/*
 * Typ 4: Referenz auf eine Instanz Methode eines unbestimten (noch nicht vorhandenen) Objekt von einem speziellen (bekannten) Typ
 * 
 * Andere Formulierung:
 * 			Referenz auf eine Instanz Methode von dem 1 Parameter der abstrakten Methode, die dabei realisiert wird.
 */

public class B17_Method_reference_Type4 {

	public static void main(String[] args) {
		
		/*
		 * anonyme Klasse
		 */
		Function<String, Integer> f0 = new Function<>() {
			public Integer apply(String s) {
				return s.length();
			}
		};
		
		/*
		 * Lambda
		 */
		Function<String, Integer> f1 = s -> s.length();
		
		
		/*
		 * Referenz auf eune Instanz Methode des 1 Parameters
		 */
		Function<String, Integer> f2 = String::length;
		
		Integer result = f2.apply("Hallo");
			
		System.out.println(result);
		
		keineAufgabe();
		
	} // end of main
	
	static void keineAufgabe() {
		
		BiFunction<String, String, String> f0 = new BiFunction<String, String, String>() {

			@Override
			public String apply(String s1, String s2) {
				return s1.concat(s2);
			}
			
		};
		System.out.println(f0.apply("1", "2"));
		
		BiFunction<String, String, String> f1 = (s1,s2) -> s1.concat(s2);
		System.out.println(f1.apply("1", "2"));
		
		BiFunction<String, String, String> f2 = String::concat;
		BinaryOperator<String> f2b = String::concat;
		System.out.println(f2.apply("Java", " ist toll!"));
		
		/*
		 * Vergleich im Einsatz - anonyme Klasse gegen eine Methodenreferenz
		 */
		getAndPrint(new BinaryOperator<String>() {
			public String apply(String t, String u) {
				return t.concat(u);
			}
			
		});
		
		getAndPrint(String::concat);
	}
	
	static void getAndPrint(BinaryOperator<String> op) {
		System.out.println(op.apply("Java", " ist toll!"));
	}
	
}
