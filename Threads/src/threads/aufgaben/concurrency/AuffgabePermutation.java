package threads.aufgaben.concurrency;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import threads.MyThreadUtils;


public class AuffgabePermutation {

	public static void main(String[] args) {
		
		char[] arr = { 'a', 
				'b', 
				'c',
				'd',
				};
	
		/*
		 * Bitte die Methode 'factorial' realisieren.
		 * 
		 * Berechnet: 1*2*3*4*...*LängeDesArrays
		 */
		BigInteger arrayLen = BigInteger.valueOf(arr.length);
		BigInteger countPerm = factorial( arrayLen );
		
		int capacity = 100;
		ArrayBlockingQueue<String> data = new ArrayBlockingQueue<String>(capacity);
		
		Runnable taskBuildData = () -> {
			try {
				permutate(data, arr, arr.length);
			} catch (Exception e) {
				System.out.println("Interrupted");
			}
		};
		Thread threadBuildData = new Thread();
		threadBuildData.start();
		
		Runnable taskPrintData = () -> {
			try {
				while (true) {
					String string = data.take();
					System.out.println(string);
				}
			} catch (Exception e) {
				System.out.println("Interrupted");
			}
		};
		
		Thread threadPrintData = new Thread(taskPrintData);
		threadPrintData.start();
		
		try {
			threadBuildData.join();
			MyThreadUtils.pause(2000);
			threadPrintData.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.printf("Array, Länge = %d %n", arr.length);
		System.out.printf("Permutationen: %s %n", countPerm);
		
	} // end of main
	
	static BigInteger factorial(BigInteger bi) {
		if( bi.intValue() == 1 ) {
			return bi;
		}
		
		return bi.multiply( factorial(bi.subtract(BigInteger.ONE)) );
	}

	/*
	 * https://en.wikipedia.org/wiki/Heap%27s_algorithm
	 */
	public static void permutate( BlockingQueue<String> datQueue,char[] arr, int pointer) throws InterruptedException {
	    if(pointer==1) {
//	        System.out.printf("%s %n", Arrays.toString(arr));
	    	String data = String.format("%s %n",  Arrays.toString(arr));
	    	datQueue.put(data);
	        return;
	    }
	    
		for (int i = 0; i < pointer-1; i++) {
		   permutate(datQueue, arr, pointer-1);
		    
			if(pointer%2==0) {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[i];
			    arr[i] = tmp;
			} else {
			    char tmp = arr[pointer-1];
			    arr[pointer-1] = arr[0];
			    arr[0] = tmp;
			}
		}
		
		permutate(datQueue, arr, pointer-1);
	}
	
}
