package deque;

import java.sql.ResultSet;
import java.util.ArrayDeque;

public class ArrayDequeMitInteger {

	public static void main(String[] args) {
		
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		/*
		 * TAIL - ZUGRIFF
		 * 
		 * boolean add(E)
		 * boolean offer(E)
		 */
		boolean result = deque.add(7);
		System.out.println("add(7): " + result);
		
		System.out.println("add(3): " + deque.add(3));
		
		System.out.println("1: " + deque); // [7, 3]
		
		result = deque.offer(11);
		System.out.println("offer(11): " + result);
		System.out.println("offer(5): " + deque.add(5));
		
		System.out.println("2: " + deque); // [7, 3, 11, 5]
		
		/*
		 * E element()
		 * E peek()
		 * 
		 * E remove()
		 * E poll()
		 */
		System.out.println("element(): " + deque.element()); // 7
		System.out.println("peek(): " + deque.peek()); // 7
		
		System.out.println("remove(): " + deque.remove()); // 7
		System.out.println("poll(): " + deque.poll()); // 3
		
		System.out.println("3: " + deque); // [11, 5]
		
		/*
		 * Stack Methoden (Head - ZUGRIFF)
		 * 
		 * void push(E)
		 * pop() : E
		 * peek() : E
		 */
//		System.out.println("push(2): " + deque.push(2)); // CF return void
		deque.push(2);
		System.out.println("4: " + deque); // [2, 11, 5]
		
		System.out.println("pop(): " + deque.pop()); // 2
		System.out.println("5: " + deque); // [11, 5]

		System.out.println("peek(): " + deque.peek()); // 11
		System.out.println("6: " + deque); // [11, 5]
		
		/*
		 * viele xxxLast und xxxFirst Methoden
		 */
		System.out.println(deque.offerFirst(16));
//		System.out.println(deque.addFirst(77)); // CF addFirst liefert void
		System.out.println("7: " + deque); // [16, 11, 5]
		
		deque.addFirst(77); // void
		deque.addLast(101); // void
		System.out.println("8: " + deque); // [77, 16, 11, 5, 101]
		
		System.out.println(deque.getFirst()); // 77

	}
	
}
