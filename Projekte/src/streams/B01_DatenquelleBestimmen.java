package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class B01_DatenquelleBestimmen {
	
	public static void main(String[] args) {
		
//		mitMethodenVonstream();
//		mitMethodenVonArrays();
		mitMethodenVonCollection();
		
	}

	public static void mitMethodenVonCollection() {
		
		Collection<Integer> coll = Arrays.asList(1,2,3,4);
		
		coll.stream().forEach(System.out::println);
		
		
		
	}
	
	
	
	
		public static void mitMethodenVonArrays() {
		Integer[] array = {2,4,6,8};
		
		/*
		 * <T> Stream<T> stream(T[] array)
		 */
		Arrays.stream(array).forEach(System.out::print);
		System.out.println();
		
		/*
		 * <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive)
		 */
		Arrays.stream(array, 0, 4).forEach(System.out::println);
	}
	
	
	
		public static void mitMethodenVonstream() {
		
		/*
		 * Stream empty()
		 */
		Stream.empty()
					.forEach(System.out::println);
		
		/*
		 * <T> Stream<T> generate(Supplier<? extends T> s)
		 */
		System.out.println("******* generate *********");
		
		Supplier<Integer> s = () -> 2;
		Stream.generate(s)
					.limit(5)
					.forEach(System.out::println);
		
		/*
		 * <T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
		 */
		System.out.println("******* iterate *********");
		
		Integer seed = 1;
		UnaryOperator<Integer> operator = i -> i+1;
		Stream.iterate(seed, operator)
						.limit(3)
						.forEach(System.out::println);
		
		
		/*
		 * c<T> Stream<T> of(T... values)
		 */
		System.out.println("******* of(T... values) *********");
		
		Integer[] arrInt = {2, 4, 6, 8};
		Stream.of(arrInt)
					.forEach(System.out::println);;
		
	}
	
}
