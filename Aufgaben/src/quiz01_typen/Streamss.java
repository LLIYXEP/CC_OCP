package quiz01_typen;

import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamss {

public static void main(String[] args) {
		
		ToIntFunction<String> mapper = s -> Integer.parseInt(s);
		
		Collector<String, ? , Integer> collector = Collectors.summingInt(mapper);
		
		Integer summe = Stream.of("1","2","3")
			.collect(collector);
		
		System.out.println(summe);
		
		
//		IntStream.of(1,2,3)
//			.collect(supplier, accumulator, combiner);
	}
	
}
