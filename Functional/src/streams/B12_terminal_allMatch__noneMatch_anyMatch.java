package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class B12_terminal_allMatch__noneMatch_anyMatch {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(12, 0, 17);
		
		/*
		 * allMatch(Predicate<? super T> predicate)
		 */
		
		Predicate<Integer> isPositiv = x -> x > 0;
		Predicate<Integer> isNotNegative = x -> x >= 0;
		
		boolean result = list.stream()
			.allMatch(isPositiv);
		
		System.out.println("sind alle positiv: " + result); // false (nicht alle grosser als 0)
		
		System.out.println("sind alle nicht negative: " + list.stream().allMatch(isNotNegative)); // true
		
		/*
		 * boolean anyMatch(Predicate<? super T> predicate)
		 */
		boolean anyMatch = list.stream().anyMatch(isPositiv);
		System.out.println("ist mindestens ein Element positive: " + anyMatch); // true
		
		boolean anyMatch2 = list.stream().anyMatch(isNotNegative.negate());
		System.out.println("ist mindestens ein Element negative: " + anyMatch2); // true
	
			
		/*
		 * noneMatch(Predicate<? super T> predicate)
		 */
		result = list.stream().noneMatch(isPositiv);
		System.out.println("ist kein einziges Element positiv: " + result); // false
		
		result = list.stream().noneMatch(x -> x < 0);
		System.out.println("ist kein einziges Element negative: " + result); // true
		
		
		
		System.out.println("****** fur leere Pipelines *****");
		
		System.out.println("allMatch(isPositive): " + Stream.<Integer>empty().allMatch(isPositiv)); // true
		System.out.println("anyMatch(isPositive): " + Stream.<Integer>empty().anyMatch(isPositiv)); // false
		System.out.println("noneMatch(isPositive): " + Stream.<Integer>empty().noneMatch(isPositiv)); // true
		
		
		/*
		 * Achtung! Wenn das ergebniss steht (hier bereits beim 1. Element der Pipeline) wird die Pipeline beendet
		 */
		System.out.println("******* Lazy!!! *******");
		
		System.out.println("list: " + list);
		
		boolean result3 = list.stream()
				.peek(System.out::println) // nur 12, danach wird die Pipeline beendet
			.allMatch(i -> i < 0);
		
		System.out.println(result3);
	}
	
}
