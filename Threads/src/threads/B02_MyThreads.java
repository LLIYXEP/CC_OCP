package threads;

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println("run");
	}
}

public class B02_MyThreads {

	public static void main(String[] args) {
		
		Thread th = new MyThread();
		
		th.start(); // ab hier: 2 gleichberechtige Threads
		
		System.out.println("main");
		
		
	}
	
}
