package threads.aufgaben;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import threads.MyThreadUtils;

public class AufgabeThreadsSimpleAPI {

	public static void main(String[] args) {
		
//		a1();
//		a2();
//		a3();
		a4();
		
	}
	
	static void a4() {
		
		class PrintChar implements Runnable {
			char ch;

			public PrintChar(char ch) {
				super();
				this.ch = ch;
			}
			
			public void run() {
				System.out.println(ch);;
			}
		}
		
		for (char ch = 'A'; ch < 'Z'; ch++) {
			PrintChar target = new PrintChar(ch);
			new Thread(target).start();
		}
		
	}
	
	static void a3() {
		
		Runnable target = () -> System.out.println(Thread.currentThread().getId());
		
		List<Thread> list = Stream.generate(() -> new Thread(target))
								.limit(37)
								.collect(Collectors.toList());
//		list.forEach(th -> System.out.println(th.getId()));
		list.forEach(Thread::start);
		
	}
	
	static void a1() {
	
		new Thread() {
			public void run() {
				while (true) {
					System.out.println(getName() + ": " + getId());
					MyThreadUtils.pause(1000);
				}
			};
		}.start();
	}
	
	static void a2() {
		Runnable target = () -> {
			while (true) {
				Thread th = Thread.currentThread();
				System.out.println(th.getName() + ": " + th.getId());
				MyThreadUtils.pause(1000);
			}
		};
		
		new Thread(target).start();
	}
	
}
