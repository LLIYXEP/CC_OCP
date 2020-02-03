package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B16_terminal_collect_v2 {

	public static void main(String[] args) {
		
		/*
		 * Collector ist ein Hilfsobjekt in dem die Logiken alle Schritte der collect-Methoden gesammelt sind)
		 * 
		 * Collector<T, A, R>
		 * 		T - Typ der Pipeline- Elemente
		 * 		R - Typ des Zielcontainers
		 * 		A - kann ignoriert werdwn
		 */
		
		Collector<Integer, ?, List<Integer>> collector = Collectors.toList();
		
		List<Integer> list = Stream.of(1, 2, 3, 4, 5).collect(collector);
		
		System.out.println(list);
		
		list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
		System.out.println(list);
		
		list = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);
		
	}
	
}
