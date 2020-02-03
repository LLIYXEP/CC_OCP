package generics;

import java.util.Comparator;
import java.util.function.Function;

/*
 * Mehrere Basistypen bei dem Type bound sind moglich
 */
class UseRunnableStringComparator <T extends Runnable & Comparator<String>> {
	void go(T value) {
		value.run();
		value.compare("aaa", "bbb");
	}
}

public class B066_TypeBound_Erweitert {
	
	static class RunnableStringCmpImpl implements Runnable, Comparator<String>{
		public int compare(String o1, String o2) {
			System.out.println("In den compare");
			return 0;
		}

		public void run() {
			System.out.println("In den run");
		}
		
	}
	
	interface Combined extends Runnable, Comparator<String> {
		
	}

	public static void main(String[] args) {
		
		UseRunnableStringComparator<RunnableStringCmpImpl> launcher = new UseRunnableStringComparator<>();
		launcher.go(new RunnableStringCmpImpl());
		
		UseRunnableStringComparator<Combined> var = null;
	}
	
}
