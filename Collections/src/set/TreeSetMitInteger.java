package set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetMitInteger {

	public static void main(String[] args) {
		
		Set<Integer> set = new TreeSet<Integer>();
		
		set.add(7);
		set.add(7);
		set.add(3+4);
		set.add(new Integer(7));
		
		
		System.out.println(set.size()); // 1
		
		set.add(-9);
		set.add(11);
		set.add(-27);
		set.add(19);
		
		System.out.println(set); // [-27, -9, 7, 11, 19]
		
	}
	
}
