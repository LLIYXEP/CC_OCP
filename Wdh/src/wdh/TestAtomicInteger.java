package wdh;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestAtomicInteger {

	public static void main(String[] args) {
		
		incrementTest();
		
		AtomicInteger x = new AtomicInteger();
		
		System.out.println(x.addAndGet(1)); // 1
		System.out.println(x.getAndAdd(1)); // 1
		System.out.println(x.decrementAndGet()); // 1
		
	}
	
	static AtomicInteger value = new AtomicInteger();
	
	static void incrementTest() {
		
		Runnable task = () -> {
			for (int i = 0; i < 1_000_000; i++) {
				value.incrementAndGet();
				value.getAndAdd(1);
//				value.set(value.get() + 1); // falsch
			}
		};
		
		List<Thread> list = Stream.generate(() ->task)
				.limit(3)
				.map(Thread::new)
				.collect(Collectors.toList());
		
		list.stream().forEach(Thread::start);
		
		list.stream().forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		System.out.println(value); //3_000_000
		
	}
	
}
