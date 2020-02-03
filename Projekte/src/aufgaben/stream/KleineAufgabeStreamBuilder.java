package aufgaben.stream;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class KleineAufgabeStreamBuilder {

	public static void main(String[] args) {
		
		String[] a1 = {"mo","di"};
		String[] a2 = {"mi","do","fr"};
		
		String[][] a3 = {a1,a2};
		Integer[] a4 = {1,2};
		
		
		Stream.of(77)
				.forEach(System.out::println); //77
		
		
		Stream.<Integer[]>of(a4)
		.forEach(System.out::println); // Ljava.lang.Integer;@3c679bde
		
		
		/*
		 * A1
		 */
		Stream.of(a3)
			.forEach(new Consumer<String[]>() {
				public void accept(String[] str) {
					for (String string : str) {
						System.out.print(string + " ");
					}
					System.out.println();
				}
			});
	}
	
}
