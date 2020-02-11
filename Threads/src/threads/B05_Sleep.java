package threads;

public class B05_Sleep {

	public static void main(String[] args) {
		
		System.out.println("1. Gleich geht es weiter...");
		
		long millis = 2000;
		
		/*
		 * static void sleep(long millis) throws InterruptedException
		 */
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("2. Fertig...");
	}
	
}
