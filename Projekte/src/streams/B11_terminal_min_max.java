package streams;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class B11_terminal_min_max {

	public static void main(String[] args) {
		
//		Comparator<Integer> comparator = (a,b) -> a - b;
		Comparator<Integer> comparator = Comparator.naturalOrder();
		
		Optional<Integer> min = Stream.of(1, 3, 2, 5, -7)
			.min(comparator);
		
		System.out.println(min); // -7
		
		
		Optional<Integer> max = Stream.of(1, 3, 2, 5, -7)
				.max(comparator);
			
			System.out.println(max); // 5
			
			//Locale
			
			/*
			 * Exam
			 * 
			 */
//			Integer erg = Stream.of(1,2,3).min(Comparator.naturalOrder()); // CF -> Optional<Integer> return
			
			Stream.of(1,2,3)
				.map(i -> i + "")
				.filter(s -> s.length() > 0)
				.forEach(System.out::println);
	}
	
}
