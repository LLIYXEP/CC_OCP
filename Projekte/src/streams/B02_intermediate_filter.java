package streams;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class B02_intermediate_filter {

	public static void main(String[] args) {
		
		Predicate<Integer> predicate = x -> x != 0; // die Elemente, die ungleich 0 sind, werden an die weitere Station ubergeben
		
		Stream.of(1, 2, 3, 0, 5, 0, 7) //Stream <Integer>
				.filter(predicate)
				.forEach(System.out::println);
		
		
//		kleineAufgabe();
		kleineFrage();
		
		
		
	} // main
	
	static void kleineFrage() {
		 Stream.of(1,2,3,4,5);
	}
	
	static void kleineAufgabe() {
		
		String[] arr = {"mo", "di", "mi", "do", "fr"};
		
		
		Predicate<String> pr = new Predicate<String>() {
			public boolean test(String t) {
				for (int i = 0; i < t.length(); i++) {
					char charAt = t.charAt(i);
					if (charAt == 'm') {
						return true;
					}
					
				}
				return false;
			}
		};
		Stream.of(arr)
			.filter(pr)
			.forEach(System.out::println);
		
		Stream.of(arr)
		.filter(s -> s.indexOf('m') != -1)
		.forEach(System.out::println);
		
	}
	
}
