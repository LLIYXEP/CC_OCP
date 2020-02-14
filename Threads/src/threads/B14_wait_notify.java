package threads;

class Producer extends Thread {
	
	// <- simuliert big job
	static int bigJob() {
		MyThreadUtils.pause(5000);
		return 1;
	}
	
	private int daten;
	
	public void run() {
		while (true) {
			System.out.println("Producer produziert...");
			int tmp = bigJob();
			synchronized (this) {
				daten = tmp;
				this.notifyAll();
			}
			
			System.out.println("Producer hat neue Daten erzeugt!");
		}
	}
	
	public boolean hatDaten() {
		synchronized (this) {
			return daten > 0;
		}
	}
	
	public int getDaten() {
		synchronized (this) {
			int back = daten;
			daten=0;
			return back;
		}
	}
}

class Consumer extends Thread{
	
	private Producer producer;
	
	public Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		while (true) {
			if (!producer.hatDaten()) {
				System.out.println("Consumer hat nichts neues");
				
				synchronized (producer) {
					try {
						producer.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				int daten = producer.getDaten();
				System.out.println("Consumer hat neue Daten erhalten und verarbeitet sie " + daten);
			}
		}
	}
}

public class B14_wait_notify {

	public static void main(String[] args) throws InterruptedException {
		
		Producer p1 = new Producer();
		p1.start();
		
		Consumer c1 = new Consumer(p1);
		c1.start();
		Consumer c2 = new Consumer(p1);
		c2.start();
	}
	
}
