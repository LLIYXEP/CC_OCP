package aufgaben;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import aufgaben.Task.Priority;

public class AufgabeQueueTask {

	public static void main(String[] args) {
		
		Task t1 = new Task("Autowäsche", Priority.LOW);
		Task t2 = new Task("Einkaufen", Priority.NORMAL);
		Task t3 = new Task("Rechnung bezahlen", Priority.HIGH);
		
//		Comparator<Task> cmp = (task1,task2) -> task2.getPriority().getSize() - task1.getPriority().getSize();
		Comparator<Task> cmp = (task1,task2) -> {
			int erg = task2.getPriority().compareTo(task1.getPriority());
					if (erg == 0) {
						erg = task1.getDescription().compareTo(task2.getDescription());
					}
					return erg;
					};
		Queue<Task> queue = new PriorityQueue<>(cmp);
		queue.offer(t1);
		queue.add(t2);
		queue.add(t3);
		queue.add(new Task("Java lernen", Task.Priority.NORMAL));
		
		System.out.println(queue);
		
		queue.remove();
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	
}
