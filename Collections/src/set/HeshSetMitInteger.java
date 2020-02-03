package set;

import java.util.HashSet;

public class HeshSetMitInteger {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(17);
		set.add(-11);
		set.add(33);
		set.add(9);
		
		System.out.println(set); // [17, 33, 9, -11]
		
		Integer x = 3;
		int hashCode = x.hashCode(); // ubershcrieben
		System.out.println(hashCode); // 3
		
		Integer x2 = 3;
		System.out.println(x.equals(x2)); // ubershcrieben
	}
	
}
