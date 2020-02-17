package threads;

import java.util.Random;

class SummeBerechnen extends Thread {
	volatile double summe = 0;
	
	@Override
	public void run() {
		
		Random r = new Random();
		
		for (int i = 0; i < 1000_000; i++) {
			summe += r.nextDouble();
		}
		
		System.out.println("summe in thread: " + summe);
		
	}
}

public class B08_join {

	public static void main(String[] args) {
		
		SummeBerechnen s1 = new SummeBerechnen();
		SummeBerechnen s2 = new SummeBerechnen();
		
		s1.start();
		s2.start();
		
		
		try {
			/*
			 * Der Thread in dem die Methode join aufgerufen wird (hier: main Thread)
			 * wird angehalten, solange der Thread zu dem die join aufgerufen wurde  ausgefuhrt wird.
			 * 
			 * Wenn s1 im Zustand 'NEW' ist, wird der main - Thread nicht angehalten.
			 * 
			 * InterruptedExc kann auch den Zustand 'JOINING' fruher beenden (mann kann aus einem weiteren Thread die Methode interrupt zu dem angehaltenem Thread aufrufen)
			 */
			s1.join();
			s2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("gesamtsumme - main: " + (s1.summe + s2.summe));
		
	}
	
}
