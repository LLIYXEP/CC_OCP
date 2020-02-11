package threads;

class MyRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("run");
	}
}

public class B03_MyRunnable {

	public static void main(String[] args) {
		
		Runnable target = new MyRunnable();
		
		Thread th = new Thread(target);
		
		th.start();	// ab hier: 2 Threads
		
		System.out.println("main");
		
	}
	
}
