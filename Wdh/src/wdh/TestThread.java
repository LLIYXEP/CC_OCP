package wdh;

public class TestThread {
	
	static class MyThread extends Thread {
		
	}

	public static void main(String[] args) {
		
		MyThread th = new MyThread();
		Thread th2 = new Thread(th);
		
	}
	
}
