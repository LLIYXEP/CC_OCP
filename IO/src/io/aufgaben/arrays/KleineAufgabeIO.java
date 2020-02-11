package io.aufgaben.arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

class ArrayUtils {
	public static int[] createRandomIntArray(int len, int min, int max) {
		int[] arr = new int[len];
		
		Random random = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(max - min + 1) + min;
		}
		
		return arr;
	}

	public static void saveToFile(int[] arr, String fileName) {

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(arr);
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public static int[] loadFromFile(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			return (int[]) ois.readObject();
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	
	
	
	
	public static void saveToFile2(int[] arr, String fileName) {
		try (PrintWriter out = new PrintWriter(fileName)) {
			for (int x : arr) {
				out.println(x);
			}
		} catch (FileNotFoundException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static int[] loadFromFile2(String fileName) {
		
		try {
			return Files.lines(Paths.get(fileName))
					.mapToInt(Integer::parseInt)
					.toArray();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
//		int[] arr = new arr[];
//		
//		
//		
//		return arr;
	}
}





public class KleineAufgabeIO {

	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		int len = new Random().nextInt(20) + 1;
		int min = 0, max = 15;
		
		int[] arr1 = ArrayUtils.createRandomIntArray(len, min, max);
		
		System.out.println(Arrays.toString(arr1));
		
		
		/*
		 * A2
		 */
		
//		ArrayUtils.saveToFile(arr1, "array.txt");
		ArrayUtils.saveToFile2(arr1, "array.txt");
		
//		int[] arr2 =  ArrayUtils.loadFromFile("array.txt");
		int[] arr2 =  ArrayUtils.loadFromFile2("array.txt");
		
		System.out.println(Arrays.toString(arr2));
		
		
		
		System.out.println("Referenzenvergleich: " + (arr1 == arr2)); // false
		
		System.out.println("InhaltVergleich: " + Arrays.equals(arr1, arr2)); // true
	}
	
	
	
	
	
}
