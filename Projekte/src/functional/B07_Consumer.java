package functional;

import java.util.function.Consumer;

public class B07_Consumer {

	public static void main(String[] args) {
		
		/*
		 * Consumer mit einer anonyme Klasse
		 */
		
		Integer var = 22;
		
		Consumer<Integer> c1 = new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("Result " + t);
			}
		};
		
		c1.accept(44);
		
		Consumer<Integer> c2 = (t) -> System.out.println("Result " + t);
		
		c2.accept(var);
		
		weitereMethode();
		
	}
	
	static void weitereMethode() {
		System.out.println("****** default Consumer andThen(Consumer) **********");
		
		Consumer<String> c1 = s -> System.out.println(s);
		
		Consumer<String> c2 = s -> System.out.println(s);
		
		Consumer<String> c3 = c1.andThen(c2);
		c3.accept("Hello");
	}
	
}
