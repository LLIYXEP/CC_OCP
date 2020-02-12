package threads.aufgaben;

public class KleineAufgabeJoin {
	
	volatile static int value;

	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000_000; i++) {
				value++;
			}
		});
		
		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Second Thread value after join: " + value);
		
	}
	
}
