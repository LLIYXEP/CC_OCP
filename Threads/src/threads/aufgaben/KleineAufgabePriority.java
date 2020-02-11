package threads.aufgaben;

import java.util.Random;

public class KleineAufgabePriority {

	public static void main(String[] args) {
		
		Runnable target = new Runnable() {
			@Override
			public void run() {
				long sum = 0;
				for (int i = 0; i < 10000000; i++) {
					sum += new Random().nextInt(100);
				}
				Thread current = Thread.currentThread();
				System.out.println(current.getName() + ": " + sum);
			}
		};
		
		Thread th = new Thread(target, "Tom");
		Thread th2 = new Thread(target, "Jerry");
		
		th2.setPriority(Thread.MAX_PRIORITY);
		th.setPriority(Thread.MIN_PRIORITY);
		
		th.start();
		th2.start();
		
		
		
	}
	
}
