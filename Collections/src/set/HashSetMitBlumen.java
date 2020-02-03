package set;

import java.util.HashSet;

class Blume {
	private int size;

	public Blume(int size) {
		super();
		this.size = size;
	}

	@Override
	public String toString() {
		return "B - " + size ;
	}
	
	/*
	 * equals sollte die Objekte nach Inhalten (Attributen) vergleichen
	 */
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass()) {
			return false;
		}
		return size == ((Blume)obj).size;
	}
	

	/*
	 * Nach Inhalt Gleiche Objekte mussen denselben Hashcode haben
	 * Sinvolle hashcode sollte den Hashcode aus den Attributen berechnen, die in der equals vergleichen werden
	 */
	
	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + size;
//		return 7; // korrektt (nicht sinvoll)
		return size; // sinvoll
	}


	
	
}

public class HashSetMitBlumen {

	public static void main(String[] args) {

		Blume b1 = new Blume(3);
		
		HashSet<Blume> set = new HashSet<Blume>();
		set.add(b1);
		
		System.out.println("1. size : " + set.size()); // 1
		
		set.add(b1);
		
		System.out.println("2. size : " + set.size()); // 1
		
		Blume b2 = new Blume(5);
		
		set.add(b2);
		
		System.out.println("3. size : " + set.size()); // 2
		
		Blume b3 = new Blume(3);
		
		set.add(b3);
		
		System.out.println("4. size : " + set.size()); // 3
		
		System.out.println(set);
		
		System.out.println(b1.equals(b3));
	}

}
