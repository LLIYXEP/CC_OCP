package concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class B03_Coll_Legacy {

	public static void main(String[] args) {
		
//		test_GuteModerneNichtthreadsichereCollection();
		test_LegacyNichtSichereCollection();
		
		System.out.println("main");
		
	}
	
	static void test_LegacyNichtSichereCollection() {
		
		List<Integer> list = new Vector<Integer>(); // sicher aber nicht empfohlen
		
		Runnable taskA = () -> {
			for (int i = 0; i < 1_000; i++) {
				list.add(i);
			}
		};
		
		Runnable taskB = () -> {
			for (int i = 0; i < 1_000; i++) {
				list.add(i);
			}
		};
		
		new Thread(taskA).start();
		new Thread(taskB).start();
		
	}
	
	static void test_GuteModerneNichtthreadsichereCollection() {
		
		List<Integer> list = new ArrayList<Integer>();
		
		/*
		 * in dem folgenden (schlechtem) Code ist
		 * eine ArrayIndexOutOfBoundExc moglich
		 * 
		 * Z.B. ArrayIndexOutOfBoundsException: arraycopy: last source index 62 out of bounds for object array[49]
		 */
		
		Runnable taskA = () -> {
			for (int i = 0; i < 1_000; i++) {
				list.add(i);
			}
		};
		
		Runnable taskB = () -> {
			for (int i = 0; i < 1_000; i++) {
				list.add(i);
			}
		};
		
		new Thread(taskA).start();
		new Thread(taskB).start();
		
	}
	
}
