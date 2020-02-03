package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B18_Collectors_mapping {

	public static void main(String[] args) {
		
		String[] array = {"aaaa", "bb", "cccc", "dd"};
		
		/*
		 * einfach mit toList-Collector
		 * 
		 * 		Aus String-Elementen wird List<String>
		 */
		Collector<String, ?, List<String>> c0 = Collectors.toList();
		
		List<String> list0 = Arrays.stream(array).collect(c0);
		System.out.println(list0);
		
		/*
		 * einfach mit toList-Collector
		 * 
		 * 		Aus Integer-Elementen wird List<Integer>
		 */
		List<Integer> list1 = Arrays.stream(array).map( x -> x.length()).collect(Collectors.toList());
		System.out.println(list1);
		
		/*
		 * etwas komplizierter gleichzeitig die Logik zum Andern des Types und auch furs Sammlen der geanderten Elemente in einer Liste
		 * 
		 * <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper,
                               Collector<? super U, A, R> downstream)
                               
	       @param <T> the type of the input elements
	     * @param <U> type of elements accepted by downstream collector
	     * @param <A> intermediate accumulation type of the downstream collector
	     * @param <R> result type of collector
		 */
		
		Function<String, Integer> mapper = String::length;
		
		Collector<Integer, ?, List<Integer>> downstream = Collectors.toList();
		
		Collector<String, ?, List<Integer>> c2 = Collectors.mapping(mapper, downstream);
		
		List<Integer> list2 = Arrays.stream(array).collect(c2);
		
		System.out.println(list2);
		
		a1();
	}
	
	static void a1() {
		Integer[] zahlen = {1,22,333,4444};
		
		Collector<Integer, ?, TreeSet<String>> c3 = Collectors.mapping(String::valueOf, Collectors.toCollection(TreeSet::new));
		
		TreeSet<String> set = Arrays.stream(zahlen).collect(c3);
		
		System.out.println(set);
		
		Collector<Integer, ?, TreeSet<String>> collector = Collectors.mapping(x -> new String().valueOf(x), Collectors.toCollection(TreeSet::new));
		
		TreeSet<String> set2 = Arrays.stream(zahlen).collect(collector);
		
		System.out.println(set2);
		
	}
	
}
