package generics;

import java.util.Arrays;
import java.util.Random;

public class B01_OhneGenerics {

	public static void main(String[] args) {
		
		/*
		 * Hier wird eine Situation simuliert, bei der der logische Fehler im Program nur selten
		 * und nur zur Laufzeit erkannt werden kann.
		 */
		
		Object[] arr = {
				12,
				"22",
				5
		};
		
		if (new Random().nextInt(1000) == 1) {
			Arrays.sort(arr); // sort(Object[])
		}
		
		System.out.println(arr[0]);
	}
	
}
