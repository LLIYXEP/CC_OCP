package functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Wdh01 {

	public static void main(String[] args) {
		
		Predicate<?> v1 = x -> true;
		
		Function<Integer, Double> v2 = (Integer x) -> 22.0;
		
		Supplier<Double> v3 = () -> 22.0;
		
		Consumer<?> v4c = x -> {};
		
		/*
		 * losung 1
		 */
		Function<String, Consumer<String>> v4 = s -> x -> x.concat(s);
		Consumer<String> applyb = v4.apply("s");
		applyb.accept("s2");
		
		
		// mit anonyme Klassen
		Function<String, Consumer<String>> v4b = new Function<String, Consumer<String>>() {

			public Consumer<String> apply(String s) {
				return new Consumer<String>() {

					public void accept(String x) {
						x.concat(s);
					}
				};
			}
		};
		
		/*
		 * Losung 2
		 */
		
		Function<String, UnaryOperator<String>> v5 = s -> x -> x.concat(s);
		UnaryOperator<String> apply = v5.apply(" Hello welt");
		String apply2 = apply.apply("Guten Morgen");
		System.out.println(apply2);
//		
//		Function<String, Function<String, String>> v6 = s -> x -> x.concat(s);
	}
	
}
