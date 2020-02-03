package aufgaben.putIntegers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PutIntegers {

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
		Integer[] intArr = {1,2,3,4};
		for (int i = 0; i < intArr.length; i++) {
			cons.accept(i+1);
		}
	}
	
}
