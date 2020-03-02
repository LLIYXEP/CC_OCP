package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

// Kombiniert die elemente zu einem

public class B14_terminal_reduce {
	
	public static void main(String[] args) {
		
//		reduce_v1();
//		reduce_v2();
//		reduce_v3();
		reduce_v4_mit_Typumwandlung();
		
	}
	
	public static void reduce_v4_mit_Typumwandlung() {
		
		/*
		 * <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
		 */
		
		System.out.println("******** U> U reduce Typumwandlung ********** ");
		
		Double[] zahlen = {1.3, -2000.77, 5.9, -33.1, 8., -12.2, -13.5};
		
		long count = Arrays.stream(zahlen)
			.filter(x -> x < 0)
			.count();
		
		System.out.println(count); // 4
		
		//Variante 2
		
		// T ist gerade Double
		// U wird zu Integer (Typ fur den Counter)
		
		Integer identity = 0;
		
		BiFunction<Integer, Double, Integer> accumulator = (countt, zahl) -> {
			if (zahl < 0) {
				countt++;
			}
			return countt;
		};
		
		BinaryOperator<Integer> combiner = (countA , countB) -> countA + countB;
		
		Integer anzahlNegativer = Arrays.stream(zahlen)
			.reduce(identity, accumulator, combiner);
			
			System.out.println(anzahlNegativer); // 4
	}
	
	public static void reduce_v3() {
		
		/*
		 * <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);
		 */
		
		System.out.println("******** reduce mit 3 Parameter ********** ");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		Integer identity = 0; // 'berechningsneutral'
		
		BiFunction<Integer, Integer, Integer> accumulator = (x1, x2) -> {
			System.out.println("x1 = " + x1 + ", x2 = " + x2);
			return x1 + x2;
		};
		
		BinaryOperator<Integer> combiner = (a, b) -> {System.out.println(a + b);return a + b;};
		
		Integer result = list.stream()
			.parallel()
			.reduce(identity, accumulator, combiner);
		
		System.out.println(result);
		
		/*
		 * Wir nehmen an, dass die Pipeline auf zwei CPU - Kernen parallel verarbeitet wird
		 * 
		 * Daten aus der Liste:
		 * 
		 *	1, 2												3, 4
		 * 
		 *	CPU A												CPU B
		 * 
		 * 	Schritt 1 (mit accumulator):						Schritt 1: (mit accumulator):
		 * 
		 * 	x1 - 0 (Identity)									x1 - 0 (Identity)
		 * 	x2 = 1 (aus Datenquelle)							x2 = 3 (aus Datenquelle)
		 * 
		 * 	Ergebnis: 1											Ergebnis: 3
		 * 
		 * 
		 *  Schritt 2 (mit accumulator):						Schritt 2: (mit accumulator):
		 * 
		 * 	x1 - 1 (Ergebnis aus Schritt 1)						x1 - 3 (Identity)
		 * 	x2 = 2 (aus Datenquelle)							x2 = 4 (aus Datenquelle)
		 * 
		 * 	Ergebnis: 3											Ergebnis: 7
		 * 
		 * 
		 * 	Kombinieren (mit combiner)
		 * 
		 * 	a = 3 (Ergebniss auf CPU A)
		 *  b = 7 (Ergebniss auf CPU A)
		 *  
		 *  Gesamtergebnis : 10
		 */
		
	}
	
	
	
	public static void reduce_v2() {
		
		System.out.println("******** T reduce(T identity, BinaryOperator<T> accumulator); ********** ");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		BinaryOperator<Integer> accumulator = (x1, x2) -> x1 + x2;
		
		Integer reduce = list.stream()
			.reduce(5, accumulator);
		
		System.out.println(reduce); //15
		
		System.out.println(Stream.of(77).reduce(1,accumulator)); // 78
		System.out.println(Stream.<Integer>empty().reduce(33, accumulator)); // 33
		
		
	}

	public static void reduce_v1() {
		
		System.out.println("******** Optional<T> reduce(BinaryOperator<T> accumulator); ********** ");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		BinaryOperator<Integer> accumulator = (x1, x2) -> x1 + x2;
		
		Optional<Integer> maybeSum = list.stream()
			.reduce(accumulator);
		
		System.out.println(maybeSum); // 10
		
		Integer integer = Stream.of(77).reduce((x1, x2) -> x1 + x2).get();
		System.out.println(integer); // 77 (kein accumulator angewendet)
		
	}
	
}
