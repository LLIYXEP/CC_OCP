package map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class MapApi_Iterieren {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		map.put("mo", 1000);
		map.put("di", 2000);
		map.put("mi", 3);
		map.put("do", 2000);
		
//		for (String string : map) { // CF . Map is nicht Iterable
//			
//		}
		
		/*
		 * forEach(s. auch das Project 'Functional')
		 */
		BiConsumer<String, Integer> action = (key, value) -> {
			System.out.println("key = " + key + ", value= " + value);
		};
		map.forEach(action);
		
		System.out.println("*********************");
		
		/*
		 * Set keySet()
		 */
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Integer value = map.get(key);
			System.out.println("key = " + key + ", value= " + value);
		}
		
		System.out.println("******* values() *******");
		
		/*
		 * Collection values()
		 */
		Collection<Integer> allValues = map.values();
		System.out.println("all values: " + allValues); // [2000, 2000, 3, 1000]
		
		/*
		 * Set entrySet()
		 */
		System.out.println("********* entrySet() ********");
		Set<Map.Entry<String, Integer>> allEntries = map.entrySet();
		System.out.println(allEntries);
		
		for (Map.Entry<String, Integer> entry : allEntries) {
			System.out.println(entry);
			System.out.println("" + entry.getKey() + "=" + entry.getValue());
		}
		
		/*
		 * toString()
		 */
		System.out.println("toString(): " + map);
	}
	
}
