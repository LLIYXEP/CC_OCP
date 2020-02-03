package set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;


class Kreis implements Comparable<Kreis>{
	int radius;

	public Kreis(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "K: " + radius;
	}

	@Override
	public int compareTo(Kreis o) {
		return radius - o.radius;
	}
	
}

public class TreeSetMitKreisen {

	public static void main(String[] args) {
		
		Set<Kreis> set = new TreeSet<>();
		
		set.add(new Kreis(7));
		set.add(new Kreis(3));
		set.add(new Kreis(3));
		set.add(new Kreis(7));
		
		System.out.println(set.size());
		System.out.println(set);
		
		set = new TreeSet<>((a,b) -> b.compareTo(a));
		
		set.add(new Kreis(5));
		set.add(new Kreis(3));
		set.add(new Kreis(3));
		set.add(new Kreis(17));
		set.add(new Kreis(20));
		
		System.out.println(set); // [K: 20, K: 17, K: 5, K: 3]
	}
	
}
