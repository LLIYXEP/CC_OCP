package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class B02_Atomic {
	
	public static void main(String[] args) throws InterruptedException {
		
//		testThreadSafety();
		api();
		
	}
	
	public static void api() {
		AtomicInteger x  = new AtomicInteger();
		System.out.println("x: " + x);
		
		AtomicInteger y = new AtomicInteger(12);
		System.out.println("y: " + y);
		
//		int z = x;  // CF: kein Autounboxing
		
		System.out.println(x.get()); // 0
		x.set(25);
		System.out.println(x.getAndIncrement()); //25
		System.out.println(x); // 26
		System.out.println(x.incrementAndGet()); // 27
		System.out.println(x); // 27
		
		System.out.println(x.decrementAndGet()); // 26
		System.out.println(x.getAndDecrement()); // 26
		
		int delta = 3;
		System.out.println(x.addAndGet(delta)); // 28
		System.out.println(x.getAndAdd(delta)); // 28
		System.out.println(x); // 31
		
		
	}

	public static void testThreadSafety() throws InterruptedException {
		
		AtomicInteger x = new AtomicInteger();
		
		int value = x.get();
		System.out.println("value: " + value); // 0
		
		Runnable target = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				x.getAndIncrement();
			}
		};
		
		Thread t1 = new Thread(target);
		Thread t2 = new Thread(target);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("x: " + x);  // 2000000
	}
	
}
