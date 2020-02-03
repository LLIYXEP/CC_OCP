package nested;

import java.util.ArrayList;
import java.util.List;

class Baum {
	int alter;
	
	public Baum() {
	}

	public Baum(int alter) {
		this.alter = alter;
	}
	
	public int getAlter() {
		return alter;
	}
}

public class B06_Anonymous_nochmal {

	public static void main(String[] args) {
		
		Baum b1 = new Baum() {}; // anonyme Klasse
		
		Baum b2 = new Baum(1200) {}; // anonyme Klasse
		
		System.out.println(b2.getAlter()); // 1200
		
		System.out.println(b2.getClass().getName()); // nested.B06_Anonymous_nochmal$1
		
		System.out.println(b2 instanceof Baum); // true
		
		Baum b3 = new Baum(7) {
			@Override
			public int getAlter() {
				return super.getAlter() * 1000;
			}
		};
		
		System.out.println(b3.getAlter()); // 7000
		
		@SuppressWarnings("serial")
		List<Integer> list = new ArrayList<Integer>() { // anonyme Klasse
			// init Block (wird in den Konstruktor eingebaut)
		  {
			add(1);
			add(2);
			add(3);
		  }
		};
		
		System.out.println(list.size());
		
	}
	
}
