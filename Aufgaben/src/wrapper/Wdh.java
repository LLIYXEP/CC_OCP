package wrapper;

class Ozean{
	Long tiefe = 12L;
}

class Berg{
	Long tiefe = 1200L;
}

public class Wdh {

	public static void main(String[] args) {

		frage1();
		frage2();
		
		
	}
	
	static void frage2() {
		Berg b1 = new Berg();
		Berg b2 = new Berg();
		
		b1 = null;
		b2 = null;
		
		// Zeile A 4 Objekte GC
		
		
	}
	
	static void frage1() {
		Ozean o1 = new Ozean();
		Ozean o2 = new Ozean();
		
		o1 = null;
		o2 = null;
		
		// Zeile A 2 Objekte GC
		
	}
	
}
