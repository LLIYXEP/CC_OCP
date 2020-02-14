package threads;

public class Wdh {
	
	static void doStuff(int x) {
		
		Object a = x > 0 ? String.class : Wdh.class;
		Object b = a == String.class ? Wdh.class : String.class;
		
		/*
		 * Achtung! Deadlock Sehr wahrscheilich
		 */
		synchronized (a) {
			MyThreadUtils.pause(1000);
			synchronized (b) {
				
			}
		}
		System.out.println(x);
	}

	public static void main(String[] args) {
		
		Runnable targetA = () -> doStuff(1);
		Runnable targetB = () -> doStuff(-1);
		new Thread(targetA).start();
		new Thread(targetB).start();
		
		System.out.println("main");
	}
	
}
