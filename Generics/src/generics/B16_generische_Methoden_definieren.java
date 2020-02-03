package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Utils {
//	static Number getRandom(Number a, Number b) {return null;}
	
	static <T> T getRandom(T a, T b) {
		if (new Random().nextBoolean()) {
			return a;
		}
		return b;
	}
}

public class B16_generische_Methoden_definieren {
	


	public static void main(String[] args) {
		
		Integer x1 = Utils.getRandom(2, 3); // Integer detRandom(Integer, Integer)
		System.out.println(x1);
		
		Double x2 = Utils.getRandom(2.3,  5.7); // Double detRandom(Double, Double)
		
		Number x3 = Utils.getRandom(12, .5); // Number detRandom(Number, Number)
		
		String x4 = Utils.getRandom("a", "b"); // String detRandom(String, String)
		
		
		
		/*
		 * Syntaktisch korrektes Verwenden (Aufrufen) einer gerenische Methode:
		 */
		
		List<Integer> listInt =  new ArrayList<Integer>();
		
		Collections.sort(listInt);
		
		Collections.<Integer>sort(listInt); // Achtung geht auch
		
		System.out.println(listInt);
		
		Utils.getRandom(12, 22);
		Utils.<Integer>getRandom(12, 22); // geht auch
		Utils.<Number>getRandom(12, 22); // geht auch
		Utils.<Object>getRandom(12, 22); // geht auch
//		Utils.<Double>getRandom(12, 22); // CF
		
		
	}
	
}
