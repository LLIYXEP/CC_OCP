package aufgaben;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class AufgabeListBenchmark {
	static final int N = 10_000;
	static final int M = 1_000;
	

	public static void main(String[] args) {
		
	pause(5000);

	testList(() -> new LinkedList<>());
	
	System.gc();
	
	pause(5000);
	
	testList(() -> new ArrayList<>());

		
	}
	
	static void testList(Supplier<List<String>> listSupplier) {
		
		List<String> list = listSupplier.get();
		
		System.out.printf("****** Test for %s. N (number of Strings): %d, M (number of Lists): %d %n ******", list.getClass().getName(), N, M);
		
		long timeTotal = 0;
		
		for (int i = 0; i < M; i++) {
			List<String> target = listSupplier.get();
			long startCall = System.currentTimeMillis();
			testAddFirst(N, target);
			long endCall = System.currentTimeMillis();
			
			long timeCall = endCall - startCall;
			
			timeTotal += timeCall;
		}
		
		System.out.printf("****** Time total: %d Millis. %n", timeTotal);
		System.out.printf("****** Avrg. time: %f Millis. %n", (double)timeTotal / M);
	}
	
	static void testAddFirst(int numberOfStrings, List<String> target) {
		for (int i = 0; i < numberOfStrings; i++) {
			String s = "" + i;
			target.add(0, s);
		}
	}
	
	static void pause(long millis) {
		try {
			System.out.println("Pause " + millis);
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
