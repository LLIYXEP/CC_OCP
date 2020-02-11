package threads;

public class MyThreadUtils {

	static void pause(long millis)  {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
