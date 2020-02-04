package streams;

import java.util.Comparator;
import java.util.stream.Stream;


public class B06_sorted {
	
	static class Rechteck implements Comparable<Rechteck> {
		int breite, hoehe;

		public Rechteck(int breite, int hoehe) {
			super();
			this.breite = breite;
			this.hoehe = hoehe;
		}
		@Override
		public String toString() {
			return "Rechteck " + breite + " X " + hoehe;
		}
		@Override
		public int compareTo(Rechteck o) {
			return breite*hoehe - o.breite*o.hoehe;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("******* sorted() ******");
		Stream.of(5, -7, 3, -2)
			.sorted()
			.forEach(System.out::println);
		
		
		System.out.println("******* sorted() mit Rechteck - Elementen ******");
		Rechteck[] array = {
				new Rechteck(10, 3),
				new Rechteck(2, 3),
				new Rechteck(7, 2)
		};
		
		Stream.of(array).sorted().forEach(System.out::println);
		
		System.out.println("******* sorted() Comparator.reverseOrder() ******");
		Stream.of(5, -7, 3, -2)
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);
	}
	
}
