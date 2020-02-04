package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B17_Collectors_toXXX {
	
	public static void main(String[] args) {
		
//		toList_toSet_toCollection();
		toMap();
		
	}
	
	static void toMap() {
		
		Integer[] array = {22, 3, 22, 5, 22, -1, 22};
		
		/*
		 * 
		 * <T, K, U> Collector<T, ?, Map<K,U>> toMap(Function<? super T, ? extends K> keyMapper,
                                    Function<? super T, ? extends U> valueMapper)
		 * 
		 *  <T> the type of the input elements
		 *  <K> the output type of the key mapping function
		 *  <U> the output type of the value mapping function
		 */
		
		Function<Integer, Integer> keyMapper = x -> x;
		
		Function<Integer, String> valueMapper = x -> "<" + x + ">";
		
		Collector<Integer, ?, Map<Integer, String>> c1 = Collectors.toMap(keyMapper, valueMapper);
		
		Map<Integer, String> map = Arrays.stream(array)
				.distinct()   // einzigartige Elemente, sonst Exception collect
				.collect(c1);
		
		System.out.println(map);
		
		/*
		 * weitere uberladene toMap sind in der Prufung unwarscheinlich
		 */
		
	}
	

	static void toList_toSet_toCollection() {
		
		Integer[] array = {22, 3, 22, 5, 22, -1, 22};
		
		/*
		 * <T> Collector<T, ?, List<T>> toList()
		 */
		System.out.println("****** toList()");
		Collector<Integer, ?, List<Integer>> c1 = Collectors.toList();   // keine Angaben zu der List-Art
		
		List<Integer> list1 = Arrays.stream(array).collect(c1);
		System.out.println("list1: " + list1);
		System.out.println("list1: " + Arrays.stream(array).collect(Collectors.toList()));		// [22, 3, 22, 5, 22, -1, 22]
		
		
		/*
		 * <T>Collector<T, ?, Set<T>> toSet()
		 */
		System.out.println("****** toSet()");
		
		Collector<Integer, ?, Set<Integer>> c2 = Collectors.toSet(); // keine Angaben zu der Set-Art
		
		Set<Integer> set1 = Arrays.stream(array).collect(c2);
		System.out.println("set1: " + set1);
		System.out.println("set1: " + Arrays.stream(array).collect(Collectors.toSet()));		//set1: [-1, 3, 5, 22]
		
		
		/*
		 * <T, C extends Collection<T>> Collector<T, ?, C> toCollection(Supplier<C> collectionFactory)
		 */
		System.out.println("****** toCollection()");
		
//		Collector<Integer, ?, Set<Integer>> c3 = Collectors.toCollection(TreeSet::new);
//		TreeSet<Integer> treeSet = Arrays.stream(array).collect(c3);
//		System.out.println("set1: " + treeSet);
//		System.out.println("set1: " + Arrays.stream(array).collect(Collectors.toCollection(TreeSet::new)));		//set1: [-1, 3, 5, 22]
		
		Supplier<Collection<Integer>> collectionFactory = TreeSet::new;
		
		Collector<Integer, ?, Collection<Integer>> c3 = Collectors.toCollection(collectionFactory);
//		TreeSet<Integer> collect = Arrays.stream(array).collect(c3); // CF TreeSet <= Collection
		Collection<Integer> collect = Arrays.stream(array).collect(c3);
		System.out.println("coll1: " + collect); // [-1, 3, 5, 22]

		TreeSet<Integer> set2 = Arrays.stream(array).collect(Collectors.toCollection(TreeSet::new));
		System.out.println("treeSet: " + set2); // [-1, 3, 5, 22]
		
		
		
	}
	
}
