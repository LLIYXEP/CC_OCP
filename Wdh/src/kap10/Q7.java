package kap10;


class Baekerei extends Thread{
	
	public void run() {
		
		try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
		
		synchronized (this) {
			System.out.println("Backen in Thread " + Thread.currentThread().getId());
			try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
			System.out.println("Brotchen sind fertig in Thread " + Thread.currentThread().getId());
			
			notify();
//			notifyAll();
			
		}
	}
	
}

class Person extends Thread {
	
	Baekerei baekerei;
	
	public Person(Baekerei baekerei) {
		super();
		this.baekerei = baekerei;
	}

	public void run() {
		
		System.out.println("Warten auf Brotchen in Thread " + Thread.currentThread().getId());
		
			try {
				synchronized (baekerei) {
						baekerei.wait();
			}
			System.out.println("Einkaufen in Thread " + Thread.currentThread().getId());
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
}

public class Q7 {

	public static void main(String[] args) {
		
		Baekerei b1 = new Baekerei();
		Baekerei b2 = new Baekerei();
		
		Person pA = new Person(b1);
		pA.start();
		
		Person pB = new Person(b1);
		pB.start();
		
		b1.start();
//		b2.start();
	}
	
}
