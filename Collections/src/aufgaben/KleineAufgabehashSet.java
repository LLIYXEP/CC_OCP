package aufgaben;

import java.util.Collection;
import java.util.HashSet;

class Kreis {
	private int radius;

	public Kreis(int radius) {
		super();
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Kreis (" + radius + ")";
	}

	@Override
	public int hashCode() {
		return radius;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		
		return radius == ((Kreis)obj).radius;
	}
	
}

public class KleineAufgabehashSet {

	public static void main(String[] args) {
		
		Collection<Kreis> set = new HashSet<Kreis>();
		
		Kreis k1 = new Kreis(3);
		Kreis k2 = new Kreis(77);
		Kreis k3 = new Kreis(3);
		
		set.add(k1);
		set.add(k2);
		set.add(k3);
		set.add(new Kreis(12));
		set.add(new Kreis(-1));
		set.add(new Kreis(-9));
		
		System.out.println(set);
		
	}
	
}
