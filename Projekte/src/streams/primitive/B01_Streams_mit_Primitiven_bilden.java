package streams.primitive;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class B01_Streams_mit_Primitiven_bilden {

	public static void main(String[] args) {
		
		/*
		 * Es gibt nur die drei XxxStream fur int, long, double
		 */

		IntStream s1;
		
		LongStream s2;
		
		DoubleStream s3;
		
//		methodenAusXxxStream();
		methodenAusDerKlasseArrays();
		
	}
	
	static void methodenAusDerKlasseArrays() {
		
		System.out.println(" statische Methoden aus der Klasse Arrays ");
		
		/*
		 * Anlich in IntStream, LongStream, DoubleStream
		 * 
		 */
		int[] array = {1, 2, 3};
		IntStream s1 = Arrays.stream(array);
		
		Arrays.stream(array, 1, 3).forEach(System.out::println); // 2, 3
		
		/*
		 * Aus einem Referenzen-Stream mit speziellen intermediate Operation
		 * 
		 * mapToXxxx
		 * flatMapToXxxx
		 * 
		 * s. das nachste Bcp.
		 */
		
		/*
		 * Weitere Moglichkeiten sind in der Prufung unwarscheinlich:
		 */
		IntStream intStr = "hallo welt".chars();
		
	}
	
	static void methodenAusXxxStream() {
		
		System.out.println(" statische Methoden aus XxxStream ");
		
		/*
		 * Da ide Moglichkeiten fast gleich auch im Interface Stream gibt, gibt es hier keine aktivierten Pipelines
		 */
		
		IntStream.empty();
		
		IntSupplier intSupplier = () -> 2;
		IntStream.generate(intSupplier);
		
		IntUnaryOperator intUnaryOperator = x -> x + 1;
		IntStream.iterate(1, intUnaryOperator);
		
		IntStream sA = IntStream.of(1);
		IntStream sB = IntStream.of(1,2,3);
		
		
		IntStream.concat(sA, sB);
		
		/*
		 * keine Anliche methode im Interface Stream
		 * 
		 * LongStream range(long startInclusive, final long endExclusive)
		 * IntStream range(int startInclusive, final int endExclusive)
		 * 
		 * IntStream rangeClosed(int startInclusive, int endInclusive)
		 * LongStream rangeClosed(long startInclusive, long endInclusive)
		 */
		System.out.println("range");
		IntStream.range(1, 3).forEach(System.out::println); // 12
		
		System.out.println("rangeClosed");
		IntStream.rangeClosed(1, 3).forEach(System.out::println); // 123
		
		
	}

}
