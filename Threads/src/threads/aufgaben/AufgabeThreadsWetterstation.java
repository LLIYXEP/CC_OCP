package threads.aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AufgabeThreadsWetterstation {
	
//	static class myRunn implements Runnable{
//		public void run() {
//		}
//	}
	
	static class MeThTemp extends Thread {
		private int temperatur;
		List<Integer> tempList = new ArrayList<Integer>();
		@Override
		public void run() {
//			for (int i = 0; i < 10; i++) {
				while (true) {
					this.temperatur = new Random().nextInt(10) -5;
					this.tempList.add(temperatur);
					System.out.println(temperatur);
					try {
						Thread.currentThread().sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					
					Thread th2 = new Thread() {
						
						public void run() {
							try {
								Thread.currentThread().sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							int size = tempList.size();
							if ((tempList.get(size-1) + tempList.get(size-2) + tempList.get(size-3) < 0)) {
								System.out.println("Poholodanie");
							} else {
								System.out.println("Poteplenie");
							}
							
						}
					};
					th2.start();
				}
//			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		
		MeThTemp th1 = new MeThTemp();
		th1.start();
		
		th1.join();
		
		System.out.println("temperatur: " + th1.temperatur);
		
		
		
	}
	
}
