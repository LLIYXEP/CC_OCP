package kap10;

public class q6 {

	public static void main(String[] args) throws InterruptedException {
		
		Object objB = new Object();
		
		Thread thrreadA = new Thread("threadA") {
			@Override
			public void run() {
				synchronized (objB) {
					try {
						System.out.println("vor");
						objB.wait(2000);
						System.out.println("nach");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		
		thrreadA.start();
		
//		Thread.sleep(1000);
		System.out.println("main vor synchronised");
		synchronized (objB) {
//			System.out.println("main vor notify");
//			objB.notify();
			
			System.out.println("main vor sleep");
			Thread.sleep(5000);
		}
		
	}
	
}
