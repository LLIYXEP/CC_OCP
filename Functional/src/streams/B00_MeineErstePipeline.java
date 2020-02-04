package streams;

import java.util.Arrays;
import java.util.List;

public class B00_MeineErstePipeline {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(8, 7, 45, 33);
		
		list.stream()	// <- Datenquelle fur die Pipeline bestimmen
			.map(x -> x+1)	// <- intermediate operation
			.map(x -> x*2)	// <- intermediate operation
			.forEach(System.out::println); // <- terminal operation (Pipeline aktivieren)
		
		System.out.println(list);
		
	}
	
}
