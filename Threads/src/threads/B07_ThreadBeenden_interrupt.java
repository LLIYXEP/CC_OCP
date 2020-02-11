package threads;

public class B07_ThreadBeenden_interrupt {
	
	static class MyExtraThreadLogic implements Runnable {
		@Override
		public void run() {
			while (true) {
				System.out.println("* laufe...");
				try {
					Thread.sleep(1000);
					// wenn die InterruptedException geworfen wird,
					//wird der Zustand 'interrupted' geloscht
				} catch (InterruptedException e) {
					System.out.println("* Thread interrupted " + Thread.currentThread().getId());
					System.out.println("* Thred ist Interrupted? " + Thread.currentThread().isInterrupted());
					break;  // Schleife beenden
				}
			}
			System.out.println("Methode run ist gleich fertig, Thread " + Thread.currentThread().getId());
		}	
	}

	public static void main(String[] args) {
		
		MyExtraThreadLogic logic = new MyExtraThreadLogic();
		Thread th = new Thread(logic);
		
		th.start();
		
		MyThreadUtils.pause(5000);
		
		System.out.println("main ruft interrupt auf fur den Thread " + th.getId());
		
		th.interrupt();  // den Thread auf 'interrupted' setzen
		
		
		
	}
	
}
