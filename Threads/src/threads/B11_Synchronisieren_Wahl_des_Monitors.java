package threads;

class ValueHolder {
	volatile int value;
}

class DecrementValue extends Thread {
	
	/*
	 * static final Object monitor = new Object();
	 * 
	 * In diesem Bsp. keine gute Wahl.
	 * 
	 * Denn t3 muss gar nicht mit t1 oder t2 syncronisiert werden
	 */
	
	
	
	ValueHolder holder;
	
	public DecrementValue(ValueHolder holder) {
		this.holder = holder;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1_000_000; i++) {
			
			synchronized (holder) {
				holder.value--;
			}
			
		}
	}
}

public class B11_Synchronisieren_Wahl_des_Monitors {

	public static void main(String[] args) throws InterruptedException {
		
		ValueHolder holderA = new ValueHolder();
		
		Thread t1 = new DecrementValue(holderA);
		Thread t2 = new DecrementValue(holderA);
		
		t1.start();
		t2.start();
		
		
		ValueHolder holderB = new ValueHolder();
		Thread t3 = new DecrementValue(holderB);
		Thread t4 = new DecrementValue(holderB);
		
		t3.start();
		t4.start();
		
//		new Thread(() -> { holderA.value = 7000000; }).start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("holderA: " + holderA.value);
		System.out.println("holderB: " + holderB.value);
		
	}
	
}
