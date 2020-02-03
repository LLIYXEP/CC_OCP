package queue;

import java.util.LinkedList;
import java.util.Queue;

public class AlsQueue {

	public static void main(String[] args) {
		
		Queue<Integer> intQueue = new LinkedList<Integer>();
		
		intQueue.add(7); // hinzufugen
		intQueue.add(3);
		
		System.out.println("1. queue " + intQueue); // [7, 3]
		
		intQueue.offer(9); // hinzufugen
		System.out.println("2. queue " + intQueue); // [7, 3, 9]

		System.out.println("element() " + intQueue.element()); // 7 ( Nachschlagen )
		System.out.println("remove() " + intQueue.remove()); // 7 (Enfernen)
		
		System.out.println("3. queue " + intQueue); // [3, 9]
		System.out.println("peek() " + intQueue.peek()); // 3 ( Nachschlagen )
		System.out.println("pool() " + intQueue.poll()); // 3 (Enfernen)
		
		System.out.println("4. queue " + intQueue); // [9]
		
		intQueue.remove();
		System.out.println("5. queue " + intQueue); // []
		System.out.println(intQueue.poll()); // null
		System.out.println(intQueue.peek()); // null
		
//		intQueue.element(); // NoSuchElementException
//		intQueue.remove(); // NoSuchElementException
		
		
	}
	
}
