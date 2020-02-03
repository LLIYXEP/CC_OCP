package streams;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B19_Collectors_groupingBy {
	
	public static void main(String[] args) {
		
//		gruppingBy_v1();
//		gruppingBy_v2();
//		kleineAufgabe();
//		kleineAufgabe2();
//		gruppingBy_v3();
		kleineAufgabe3();
	}
	
	static void kleineAufgabe3() {
		
		Integer[] array = {12,-22,0,77,0,-5,-5,33,6,77,77};
		
		Function<Integer, String> classifier = x -> x > 0 ? "positive" : x < 0 ? "negative" : "zero";
		
		Supplier<Map<String, TreeSet<Integer>>> mapFactory = TreeMap::new;
		
		Collector<Integer, ?, TreeSet<Integer>> downstream = Collectors.toCollection(TreeSet::new);
		
		Collector<Integer, ?, Map<String, TreeSet<Integer>>> c1 = Collectors.groupingBy(classifier, mapFactory, downstream);

		Map<String, TreeSet<Integer>> map2 = Stream.of(array).collect(c1);
		
		printGroups(map2);
	}
	
	static void gruppingBy_v3() {
		
		System.out.println("***** gruppingBy_v3");
		
		/*
		 * <T, K, D, A, M extends Map<K, D>> 
		 * 			 Collector<T, ?, M> groupingBy(Function<? super T, ? extends K> classifier,
         *                        Supplier<M> mapFactory,
         *                        Collector<? super T, A, D> downstream)
         *                        
         *  Unterchied zu groupingBy Version2: mit der groupingBy Version3 definieren wir selbst,     
         *  wie die Map aussehen soll, in der die Gruppen gespeichert werden. Dafur legen wir den Supplier mapFactory fest.
		 */
		
		Function<String, Integer> classifier = String::length;
		
		Supplier<Map<Integer, HashSet<String>>> mapFactory = LinkedHashMap::new;
		
		Collector<String, ?, HashSet<String>> downstream = Collectors.toCollection(HashSet::new);
		
		Collector<String, ?, Map<Integer, HashSet<String>>> c1 = Collectors.groupingBy(classifier, mapFactory, downstream);
		
		Map<Integer, HashSet<String>> map1 = Stream.of("abc", "hallo", "fff", "xy", "welt", "123", "CC").collect(c1);
		
		printGroups(map1);
		
	}
	
	static void kleineAufgabe2() {
		
		Integer[] array = {12,-22,0,77,0,-5,-5,33,6,77,77};
		
		Function<Integer, String> classifier = x -> x > 0 ? "positive" : x < 0 ? "negative" : "zero";
		
		Collector<Integer, ?, TreeSet<Integer>> downstream = Collectors.toCollection(TreeSet::new);
		
		Collector<Integer, ?, Map<String, TreeSet<Integer>>> c1 = Collectors.groupingBy(classifier, downstream);

		Map<String, TreeSet<Integer>> map2 = Stream.of(array).collect(c1);
		
		printGroups(map2);
	}
	
	public static void gruppingBy_v2() {
		
		System.out.println("***** gruppingBy_v2");
		
		/*
		 * <T, K, A, D> Collector<T, ?, Map<K, D>> groupingBy(Function<? super T, ? extends K> classifier,
                                          Collector<? super T, A, D> downstream)
                                          
         *	Unterchied zu groupingBy Version1: mit der groupingBy Version2 definieren wir selbst,
         * in welchen Container die Elemente einer Gruppe gespeichet werden.
         * Dafur definiert man den downstream - Collector
		 */
		
		Function<String, Integer> classifier = String::length;
		
		Collector<String, ?, HashSet<String>> downstream = Collectors.toCollection(HashSet::new);
		
		Collector<String, ?, Map<Integer, HashSet<String>>> c1 = Collectors.groupingBy(classifier, downstream);
		
		Map<Integer, HashSet<String>> map1 = Stream.of("abc", "hallo", "fff", "xy", "welt", "123", "CC").collect(c1);
		
		printGroups(map1);
		
	}
	
	static void kleineAufgabe() {
		
		Integer[] array = {12,-22,0,77,0,-5,-5,33,6};
		
		Function<Integer, String> classifier = x -> x > 0 ? "positive" : x < 0 ? "negative" : "zero";
		
		
		Collector<Integer, ?, Map<String, List<Integer>>> c1 = Collectors.groupingBy(classifier);
		
		Map<String, List<Integer>> map2 = Stream.of(array).collect(c1);
		
		printGroups(map2);
	}

	private static <T> void printGroups(Map<?, ? extends Collection<T>> map2) {
		
		Set<?> keySet = map2.keySet();
		for (Object gId : keySet) {
			System.out.println("Gruppen - ID: " + gId);
			Collection<?> elements = map2.get(gId);
			System.out.println("Elemente in der Gruppe: " + elements);
		}
		
	}
	

	public static void gruppingBy_v1() {
		
		System.out.println("***** gruppingBy_v1");
		
		/*
		 * static <T, K> Collector<T, ?, Map<K, List<T>>>
		 *		groupingBy(Function<? super T, ? extends K> classifier)
		 */
		
		Function<String, Integer> classifier = str -> str.length();
		
		Collector<String, ?, Map<Integer, List<String>>> c1 = Collectors.groupingBy(classifier);
		
		/*
		 * Die collect-Methode mit dem groupingBy - Collector unterteilt die Elemente einer Pipeline (hier Strings) in Gruppen
		 * 
		 * Jede Gruppe wird in einer List gespeichert (Hier List<String>)
		 * 
		 * Jede Gruppe wird einem Schlussel (hier Integer) zugeordnet. Solche Key-Value Paare (hier Integer -> List<Integer>)
		 * werden in einer Map gespeichert.
		 * 
		 * Die Function classifier sagt, wie ein jedes Element der Pipeline seiner Gruppe zugeordnet werden soll.
		 */
		
		Map<Integer, List<String>> map1 = Stream.of("abc", "hallo", "fff", "xy", "welt", "123", "CC").collect(c1);
		map1.forEach((a,b) -> System.out.println(a + " -> " + b));
		
		printGroups(map1);
		
	}
	
}
