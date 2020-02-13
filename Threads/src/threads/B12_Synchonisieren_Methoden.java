package threads;

class IncrementValue{
	private int value;
	
//	public void increment() {
//		synchronized (this) {
//			value++;
//		}
//	}
	
	/*
	 * Als synchronized markierten Instanzmethoden synchtonisieren den ganzen Methodenrumpf mit this
	 */
	public synchronized void increment() {
		value++;
	}

	//witere Methoden...
}

class IncrementStaticVlaue {
	private static int value;
	
//	public static void increment() {
//		synchronized (IncrementStaticVlaue.class) {
//			value++;
//		}
//	}
	
	/*
	 * Als synchronized markierten Statischemethoden synchtonisieren 
	 * den ganzen Methodenrumpf mit dem Klassenobjekt
	 */
	public synchronized static void increment() {
			value++;
	}
	
	//witere Methoden...
}

public class B12_Synchonisieren_Methoden {

	public static void main(String[] args) {
		
		
		
	}
	
}
