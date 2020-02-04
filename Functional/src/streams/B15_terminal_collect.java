package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 *  - collect sammelt die Elemnte einer Pipeline
 *  - collect ist da um 'muttable reduction' zu realisieren
 */

public class B15_terminal_collect {

	public static void main(String[] args) {
		
		/*
		 * <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);
		 */
		
		/*
		 *  Supplier<R>  supplier beschreibt die Logik zum finden (erzeugen) des Ziel-Containers
		 *  
		 *   R ist also der Typ des Ziel-Containers
		 */
		
		Supplier<List<Integer>> supplier = new Supplier<List<Integer>>() {
			public List<Integer> get() {
				return new ArrayList<>();
			}
		};
		
		/*
		 *  BiConsumer<R, ? super T> accumulator: die Logik des Speicherns eines Pipeline - Elementes im Ziel -Contianer
		 *  
		 *  R ist also der Typ des Ziel-Containers
		 *  T ist also der Typ der Pipeline-Elemente
		 */
		
		BiConsumer<List<Integer>, Integer> accumulator = (List<Integer> list, Integer element) -> {
			list.add(element); // mutable reduction (eine List wird geandert)
		};
		
		/*
		 * BiConsumer<R, R> combiner : die Logik von Kombinieren zwei Zwischenergebnisse (hier Zwischenlisten)
		 * 				zu einem Gesamtergebnis (hier: aus zwei Listen wird eine)
		 */
		
		BiConsumer<List<Integer>, List<Integer>> combiner = (listA, listB) -> listA.addAll(listB); // mutable reduction (eine List wird geandert)
		
		List<Integer> result = Stream.of(1, 2, 3, 4, 5).collect(supplier, accumulator, combiner);
		System.out.println(result);
		
		/*
		 * nochmal ohne Zwischenvariablen
		 */
		
		result = Stream.of(1, 2, 3, 4, 5).collect(ArrayList::new, List::add, List::addAll);
		System.out.println("nochmal: " + result);
	}
	
}
