package io.aufgaben.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class ArrayUtils {
	static int[] createRandomIntArray(int len, int min, int max) {
		int[] newArr = new int[len];
		
		for (int i = 0; i < len; i++) {
			int random = new Random().nextInt(max - min + 1) + min;
			newArr[i] = random;
		}
		
		return newArr;
	}

	public static void saveToFile(int[] arr1, String string) {
		
		try (BufferedWriter in = new BufferedWriter(new FileWriter(string))) {
			char[] newArr = new char[arr1.length];
			
			for (int i = 0; i < newArr.length; i++) {
				in.write(Integer.toString(arr1[i]));
				in.newLine();
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

	public static int[] loadFromFile(String string) {
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		try (BufferedReader out = new BufferedReader(new FileReader(string))) {
			
			String s = "";
			while ((s = out.readLine()) != null) {
				
				System.out.print(s + ", ");
				newArr.add(Integer.valueOf(s));
				
			}
		} catch (Exception e) {
			
		}
		return null;
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
		
		ArrayUtils.saveToFile(arr1, "array.txt");
		
		int[] arr2 =  ArrayUtils.loadFromFile("array.txt");
		
		System.out.println(Arrays.toString(arr2));
		
		
		
		System.out.println("Referenzenvergleich: " + (arr1 == arr2)); // false
		
		System.out.println("InhaltVergleich: " + Arrays.equals(arr1, arr2)); // true
	}
	
	
	
	
	
}
