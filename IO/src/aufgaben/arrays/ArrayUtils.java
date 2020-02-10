package aufgaben.arrays;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.util.Random;

public class ArrayUtils {

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

}
