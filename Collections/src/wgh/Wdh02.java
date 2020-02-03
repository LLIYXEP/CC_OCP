package wgh;

import java.util.ArrayDeque;
import java.util.Deque;

public class Wdh02 {

	public static void main(String[] args) {
		
		Deque<Integer> deque = new ArrayDeque<>();
		
		deque.add(1);
		deque.offer(2);
		deque.add(3);
		deque.offer(4);
		
		System.out.println(deque); // [1, 2, 3, 4]
		
		deque.add(1);
		System.out.println(deque); // [1, 2, 3, 4, 1]
		
		deque.push(5);
		System.out.println(deque); // [5, 1, 2, 3, 4, 1]
		
		System.out.println(deque.peek()); // 5
		
		System.out.println(deque.element()); // 5
		
		System.out.println(deque.poll()); // 5
		
		System.out.println(deque.remove()); // 1
		
		System.out.println(deque.remove()); // 1
		
		deque.remove();
		deque.remove();
		System.out.println(deque.remove());
		System.out.println(deque.poll()); // null
//		System.out.println(deque.push(7)); // CF: void push
		
//		System.out.println(deque.remove()); // NoSuchElementException
		System.out.println(deque.peek()); // null
		
//		System.out.println(deque.addFirst(7)); // CF void
		System.out.println(deque.offerFirst(7)); // true
		System.out.println(deque.peekLast()); // true
		System.out.println(deque);
		
		
		
		
		
		
	}
	
}
