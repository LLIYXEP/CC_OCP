package threads;

public class B04_Thread_API_einfach {

	public static void main(String[] args) {
		
		/*
		 * Konstruktoren
		 * 
		 * - Thread();
		 * - Thread(Runnable);
		 * - Thread(String);
		 * - Thread(Runnable, String);
		 */
		
		new Thread();
		
		Runnable target = () -> {};
		new Thread(target);
		
		String name = "Tom";
		new Thread(name);
		
		new Thread(target, name);

		/*
		 * einfache Instanz Methoden
		 */
		
		Thread t1 = new Thread();
		
		System.out.println(t1); // Thread[Thread-2,5,main]
		
		/*
		 * long getId()
		 */
		long id = t1.getId();
		System.out.println("id: " + id); // 16
		
		/*
		 * getName, setName
		 */
		String n = t1.getName();
		System.out.println("name: " + n); // Thread-2
		
		t1.setName("Jerry");
		
		n = t1.getName();
		System.out.println("name: " + n); // Jerry
		
		/*
		 * getPriority, setPriority
		 */
		int priority = t1.getPriority();
		System.out.println("priority: " + priority); // 5
		
		int minPriority = Thread.MIN_PRIORITY;
		int maxPriority = Thread.MAX_PRIORITY;
		int normPriority = Thread.NORM_PRIORITY;
		t1.setPriority(minPriority);
		
		
		priority = t1.getPriority();
		System.out.println("priority: " + priority); // 1 --- 5 --- 10
		
		/*
		 * einfache statische Methoden
		 */
		
		/*
		 * currentThread
		 */
		Thread current = Thread.currentThread();
		System.out.println("current Thread: " + current); // Thread[main,5,main]
		
		/*
		 * yield()
		 */
		Thread.yield();  // The scheduler is free to ignore this hint. 
		
	}
	
}
