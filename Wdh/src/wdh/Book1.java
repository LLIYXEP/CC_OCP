package wdh;

import java.util.PriorityQueue;

public class Book1 {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(2);
		pq.add(4);
		System.out.println(pq.peek());
		pq.offer(1);
		pq.add(3);
//		pq.remove(1);
//		System.out.println(pq.poll());
		System.out.println(pq);
		
	}
	
}
