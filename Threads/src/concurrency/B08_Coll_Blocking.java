package concurrency;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import threads.MyThreadUtils;

public class B08_Coll_Blocking {
	
	public static void main(String[] args) throws InterruptedException {
		
//		normaleMethoden();
//		blockingMethoden();
		blockingMethodenMitTeimer();
	}
	
	public static void blockingMethodenMitTeimer()  {
		System.out.println("**** offer(e, timeout, timeunit) , poll(timeout, timeunit)");
		
		int capacity = 2;
		ArrayBlockingQueue<String> queu = new ArrayBlockingQueue<String>(capacity);  //FIFO
		
		long timeout = 3;
		TimeUnit unit = TimeUnit.SECONDS;
		
		
		
		try {
			queu.offer("a", timeout, unit);
			queu.offer("b", timeout, unit);
			
			System.out.println("1. " + queu); // [a, b]
			
			boolean erg = queu.offer("c", timeout, unit); // blockiert maximal 3 Sekunden
			System.out.println(erg); // false
			
			System.out.println("2. " + queu); // [a, b]
			
			String poll = queu.poll(timeout, unit);
			System.out.println(poll); // a
			
			System.out.println("3. " + queu); // [b]
			
			queu.poll(timeout, unit); // b
			
			queu.poll(timeout, unit); // blockiert maximal 3 Sekunden // null
			
			System.out.println("4. " + queu); // []
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	public static void blockingMethoden() throws InterruptedException {
		System.out.println("**** out , take");
		
		int capacity = 2;
		ArrayBlockingQueue<String> queu = new ArrayBlockingQueue<String>(capacity);  //FIFO
		
		queu.add("a");
		queu.offer("b");
		
		
		Runnable target = () -> {
			MyThreadUtils.pause(2000);
			System.out.println(" extra-thread: " + queu.remove()); // a
		};
		new Thread(target).start();
		
		try {
			System.out.println("1: " + queu);
			queu.put("c"); // blockiert bis es wieder Platz gibt
			System.out.println("2: " + queu); // [b, c]
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		target = () -> {
			MyThreadUtils.pause(2000);
			queu.offer("d");
			System.out.println(" extra-thread: offer"); // a
		};
		new Thread(target).start();
		System.out.println(queu.take()); // b
		System.out.println(queu.take()); // c
		
		System.out.println("3: " + queu); // []
		System.out.println(queu.take()); // blockiert bis es etwas in der Queue gibt
		
		System.out.println("4: " + queu); // []
		
	}

	public static void normaleMethoden() {
		
		ArrayBlockingQueue<Integer> q1;
		LinkedBlockingQueue<Integer> q2;
		LinkedBlockingDeque<Integer> d1;
		PriorityBlockingQueue<Integer> q3;
		
		int capacity = 2;
		ArrayBlockingQueue<String> queu = new ArrayBlockingQueue<String>(capacity);  //FIFO
		
		queu.add("a");
		queu.offer("b");
		try {
			queu.add("c");
		} catch (IllegalStateException e) {
			System.out.println("queu ist voll!");
		}
		
		
		System.out.println("1: " + queu);
		
		
		System.out.println(queu.offer("c")); // false
		
		System.out.println("2: " + queu);
		
		System.out.println("remove " + queu.remove() ); // a
		
		System.out.println("poll " + queu.poll() ); // b
		
		try {
			queu.remove();
		} catch (NoSuchElementException e) {
			System.out.println("queu ist leer!");
		}
		
		System.out.println(queu.poll()); // null
		
		
	}
	
}
