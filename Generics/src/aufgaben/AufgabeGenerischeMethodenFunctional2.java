package aufgaben;

import java.util.function.Supplier;

class IntPositive {
	
	private static <T extends Exception> void checkAndThrow(boolean check, Supplier<T> s) 
			throws T {
			
		if(!check) {
			throw s.get();
		}
	}

	void setValue(int value) {
		checkAndThrow(value>0, IllegalArgumentException::new);
	}	
	void writeValue(int value) {
		checkAndThrow(value>0, java.io.IOException::new);
	}
	
	
}

public class AufgabeGenerischeMethodenFunctional2 {

	public static void main(String[] args) {
		
		
		
	}
	
}
