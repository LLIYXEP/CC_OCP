package set;

import java.util.HashSet;

public class HashSetMitStrings {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		System.out.println("1. size: " + set.size()); // 0
		
		set.add("mo");
		set.add("mo");
		set.add(new String("mo"));
		String s = "m";
		set.add(s + "o");
		
		System.out.println("2. size: " + set.size()); // 1
		System.out.println("containe mo " + set.contains("mo")); // true
		
		set.add("di");
		set.add("mi");
		set.add("a");
		

		System.out.println("2. size: " + set); // Die Reinfolge ist nicht gleich whie added

		
		System.out.println("abc".hashCode());
		System.out.println("abc".equals("abc"));
		
	}
	
}
