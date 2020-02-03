package queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueMitStrings {

	public static void main(String[] args) {
		
		
		/*
		 * das kleinste Element hat die hochste Prioritat
		 */
		Queue<String> queue = new PriorityQueue<>();
		
		queue.offer("uu");
		queue.offer("bb");
		queue.offer("aa");
		queue.offer("cc");
		queue.offer("oo");
		
		
		while (!queue.isEmpty()) {
			System.out.println(queue);
			System.out.println(queue.poll());
		}
		
		
	}
	
}
