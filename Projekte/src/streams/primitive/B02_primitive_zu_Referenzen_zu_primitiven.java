package streams.primitive;

import java.time.LocalDate;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class B02_primitive_zu_Referenzen_zu_primitiven {
	
	public static void main(String[] args) {
		
//		referenzen_zu_primitiven();
		primitiven_zu_referenzen();
//		referenzen_zu_referenzen();
//		primitiven_zu_primitiven();
		
	}
	
	public static void primitiven_zu_primitiven() {
		
		System.out.println("Streams mit primitiven zu Streams mit primitiven");
		
		/*
		 * asLongStream() und asDoubleStream()
		 */
		
		IntStream.of(1, 2, 3) // IntStream
//			.asLongStream()	  // LongStream
			.asDoubleStream() // DoubleStream
			.forEach(System.out::println);
		
		
		
		
		
		/*
		 * In jedem XxxString:
		 * 
		 * YyyStream mapToYyy(XxxToYyyFunction mapper)
		 */
		IntToDoubleFunction mapper = new IntToDoubleFunction() {
			public double applyAsDouble(int value) {
				return value;
			}
		};
		IntStream.of(1, 2, 3) // IntStream
			.mapToDouble(mapper)
			.forEach(System.out::println);
		
	}
	

	public static void referenzen_zu_referenzen() {
		
		System.out.println("Referenzen Streams zu Referenzen Streams (mit anderen Typ)");
		
		Stream.of(LocalDate.now().minusDays(1), LocalDate.now(), LocalDate.now().plusDays(1))	// Stream<LocalDate>
				.map(LocalDate::toString)	 // Stream<String>
				.forEach(System.out::println);

	}
	
	
	public static void primitiven_zu_referenzen() {
		
		System.out.println("Streams mit primitiven zu Referenzen Streams");
		
		System.out.println(" mapToObj: ");
		
		/*
		 * <U> Stream<U> mapToObj(IntFunction<? extends U> mapper);
		 */
		
		IntFunction<String> mapper = new IntFunction<String>() {
			public String apply(int value) {
				return "<" + value + ">";
			}
		};
		IntStream.of(1, 2, 3)
			.mapToObj(mapper)
			.forEach(System.out::println);
		
		
		System.out.println(" Extra fur Wrapper-Klassen-Streams: ");
		
		LongStream.of(6,7,8).boxed();
		
		IntStream.of(4,5,6)		//IntStream
			.boxed()			//Stream<Integer>
			.forEach(System.out::println);
		
	}

	public static void referenzen_zu_primitiven() {
		
		System.out.println("Referenzen Streams zu Streams mit primitiven");
		
		/*
		 * XxxStream mapToXxx(ToXxxFunction)
		 * 
		 * mapToInt(ToIntFunction<? super T> mapper)
		 */
		
		ToIntFunction<String> mapper = new ToIntFunction<String>() {
			
			public int applyAsInt(String value) {
				return Integer.parseInt(value);
			}
		};
		
		Stream.of("12", "13", "14") // Stream<String> <- Referenzen Stream
			.mapToInt(mapper)		// IntStream	  <- Stream mit primitiven
			.forEach(System.out::println);
		
	}
	
}
