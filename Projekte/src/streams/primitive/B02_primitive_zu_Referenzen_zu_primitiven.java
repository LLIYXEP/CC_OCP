package streams.primitive;

import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class B02_primitive_zu_Referenzen_zu_primitiven {

	public static void main(String[] args) {
		
		/*
		 * XxxStream mapToXxx(ToIntFunction)
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
