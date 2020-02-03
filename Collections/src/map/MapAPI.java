package map;

import java.util.HashMap;
import java.util.Map;

public class MapAPI {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<>();
		/*
		 * V put(K, V)
		 */
		String oldValue = map.put(1, "mo"); // null
		System.out.println("old value for key = 1: " + oldValue); // null
		
		System.out.println("1: " + map); // {1=mo}
		
		map.put(2, "di");
		map.put(3, "mi");
		
		System.out.println("2: " + map); // {1=mo, 2=di, 3=mi}
		
		oldValue = map.put(1, "Montag"); // mo
		System.out.println("old value for key = 1: " + oldValue); //mo
		
		System.out.println("3: " + map); // {1=Montag, 2=di, 3=mi}
		
		/*
		 * V get(K, V)
		 */
		Integer key = 1;
		String value = map.get(key); // Montag
		System.out.println("value for key=1: " + value); // Montag
		
		System.out.println("value mit bad key: " + map.get("blod, ich kann kein kein Schlussel fur diesen Map sein")); // null
		
		System.out.println("value for key=112: " + map.get(112)); // null
		
		/*
		 * V remove(Object key)
		 */
		String remove = map.remove(1);
		System.out.println(remove); // Montag
		
		System.out.println("4: " + map); // {2=di, 3=mi}
		
		/*
		 * int size()
		 */
		System.out.println(map.size()); // 2
		
		/*
		 * boolean isEmpty()
		 */
		System.out.println(map.isEmpty()); // false
		
		/*
		 * void clear()
		 */
		map.clear();
		System.out.println(map.isEmpty()); // true
	}
	
}
