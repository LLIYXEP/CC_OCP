package wdh;

/*
 * Oracle: Bitte Thread - Objecte als Monitore fur wait-notify nicht verwenden
 */
public class B14Wdh extends Thread {
	
	public static void main(String[] args) throws InterruptedException {
		
//		falsch();
		richtig();
		
	}
	
	
public static void richtig() throws InterruptedException {
		
		Object monitor = new Object();
		
		Thread th = new Thread() {
			@Override
			public void run() {
				synchronized (monitor) {
					System.out.println("th vor notify");
					monitor.notify();
				}
			}
		};
		
		
		
		for (int i = 0; i < 2; i++) {
			new Thread() {
				@Override
				public void run() {
					synchronized (monitor) {
						try {
							System.out.println(getName() + " " + " vor wait");
							monitor.wait();
							System.out.println(getName() + " " + " nach wait");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		
		Thread.sleep(2000);
		th.start();
		
		System.out.println("end of main");
	} 

/*
 * Falsch
 */

	public static void falsch() throws InterruptedException {
		
//		Object obj = new Object();
		
		Thread th = new Thread() {
			@Override
			public void run() {
				synchronized (this) {
					System.out.println("th vor notify");
					this.notify();
				}
			}
		};
		
		
		
		for (int i = 0; i < 2; i++) {
			new Thread() {
				@Override
				public void run() {
					synchronized (th) {
						try {
							System.out.println(getName() + " " + " vor wait");
							th.wait();
							System.out.println(getName() + " " + " nach wait");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		
		Thread.sleep(2000);
		th.start();
		
		System.out.println("end of main");
	} 

}
	
		 	

