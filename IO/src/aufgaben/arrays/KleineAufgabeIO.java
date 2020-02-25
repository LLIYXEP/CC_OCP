package aufgaben.arrays;

import java.util.Arrays;
import java.util.Random;

public class KleineAufgabeIO {

	public static void main(String[] args) {

		/*
		 * A1.
		 * 
		 * Bitte die Methode createRandomIntArray erzeugen.
		 * 
		 * Sie soll ein int-Array der Länge len bilden 
		 * und mit Zufallswerten aus dem Bereich [min, max] füllen 
		 * 
		 */
		int len = new Random().nextInt(20) + 1;
		int min = 1, max = 15; 
		
		int[] arr1 = ArrayUtils.createRandomIntArray(len, min, max);
		
		System.out.println("arr1: " + Arrays.toString(arr1));
		
		/*
		 * A2, A3
		 * 
		 * Bitte die Methoden saveToFile (Array in eine Datei speichern)
		 * und loadFromFile (Array aus einer Datei laden) entwickeln.
		 */
		
//		ArrayUtils.saveToFile(arr1, "array.txt"); 
		ArrayUtils.saveToFile2(arr1, "array.txt"); 
		
//		int[] arr2 = ArrayUtils.loadFromFile("array.txt");
		int[] arr2 = ArrayUtils.loadFromFile2("array.txt");

		System.out.println("arr2: " + Arrays.toString(arr2));
		
		System.out.println("Referenzenvergleich: " + (arr1 == arr2)); // false!
		System.out.println("Inhaltsvergleich: " + Arrays.equals(arr1, arr2)); // true!
	}

}
