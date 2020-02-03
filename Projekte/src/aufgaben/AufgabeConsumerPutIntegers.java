package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AufgabeConsumerPutIntegers {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		putIntegers( i -> sb.append(i).append(" ") );
		System.out.println(sb); 	// Zeile A

		
		List<Integer> list = new ArrayList<>();
		putIntegers( i -> list.add(i) );
		System.out.println(list); // Zeile B

		
		putIntegers( System.out::print ); 	// Zeile C, optionale Aufgabe, 
													// die Zeile C kann entfernt werden
		
	}
	
	static void putIntegers(Consumer<Integer> cons) {
		for (int i = 1; i <= 4; i++) {
			cons.accept(i);
		}
	}
	
}
