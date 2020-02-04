package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B21_Collectors_kombinieren {

	static class Kreis {
		int radius;

		public Kreis(int radius) {
			super();
			this.radius = radius;
		}

		@Override
		public String toString() {
			return "Kreis " + radius;
		}
		
	}
	
	public static void main(String[] args) {
		
		Integer[] radien = { 1, 2, 3, 4, 5};
		

		/*
		 * Versuch 2:
		 */
		
		Collector<Kreis, ?, Map<String, List<Kreis>>> c0 = Collectors.groupingBy(k -> k.radius %2 == 0 ? "gerade" : "ungerade");
		Map<String, List<Kreis>> map1 = Arrays.stream(radien).map(Kreis::new).collect(c0);
		System.out.println("Kreise mit geraden Radius: " + map1.get("gerade"));
		System.out.println("Kreise mit ungerade Radius: " + map1.get("ungerade"));
		
		/*
		 * Versuch 2:
		 */
		
		Collector<Kreis, ?, List<Kreis>> c1 = Collectors.toList(); // downstream- Collector
		Function<Integer, Kreis> mapper = Kreis::new;
		Collector<Integer, ?, List<Kreis>> c2 = Collectors.mapping(mapper, c1); // mapping- Collector
		Function<Integer, String> classifier = radius -> radius %2 == 0 ? "gerade" : "ungerade";
		Collector<Integer, ?, Map<String, List<Kreis>>> c3 = Collectors.groupingBy(classifier, c2); // goupingBy- Collector
		
		Map<String, List<Kreis>> map2 = Arrays.stream(radien).collect( c3 );
		System.out.println("Kreise mit geraden Radius: " + map2.get("gerade"));
		System.out.println("Kreise mit ungerade Radius: " + map2.get("ungerade"));
				
	}
	
}
