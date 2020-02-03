package aufgaben;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class AufgabeMapFunctional {

	public static void main(String[] args) {
		//1
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "Mo");
		map.put(2, "Di");
		map.put(3, "Mi");
		
		map.forEach((a,b) -> System.out.println(a + " = " + b));
		System.out.println();
		
		//2
		BiFunction<Integer, String, String> remappingFunction = (a,b) -> b.equals("Di") ? "Dienstag" : b;
		map.compute(2, remappingFunction);
		
		map.forEach((a,b) -> System.out.println(a + " = " + b));
		System.out.println();
		
		//3
		map = new HashMap<Integer, String>();
		
		map.put(1, "Mo");
		map.put(2, "Di");
		map.put(3, "Mi");
		
		map.computeIfAbsent(2, k -> "Dienstag");
		map.forEach((a,b) -> System.out.println(a + " = " + b));
		System.out.println();
		
		//4
		map = new HashMap<Integer, String>();
				
		map.put(1, "Mo");
		map.put(2, "Di");
		map.put(3, "Mi");
		
		map.computeIfPresent(2, (k,v) -> "Dienstag");
		map.forEach((a,b) -> System.out.println(a + " = " + b));
		System.out.println();
		
		//5
		map = new HashMap<Integer, String>();
						
		map.put(1, "Mo");
		map.put(2, "Di");
		map.put(3, "Mi");
				
		map.merge(2, "Dienstag", (existingValue, additionalValue) -> { 
			System.out.println("existing: " + existingValue);
			System.out.println("additiona: " + additionalValue);
			return existingValue + " (" + additionalValue + ")";
		} );
		
		map.merge(4, "Do", (existingValue, additionalValue) -> { 
			System.out.println("existing: " + existingValue);
			System.out.println("additiona: " + additionalValue);
			return existingValue + " (" + additionalValue + ")";
		} );
		
		map.forEach( (i,v) -> System.out.println( i + " = " + v ) );	
		System.out.println("g 34 as asa");
	}
	
}
