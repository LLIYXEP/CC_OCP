package nested;

class Zoo {
	
	// Innere (inner, nested) Klasse
	class Hund {
		public String toString() {return "Hund aus dem Zoo: " + Zoo.this;}
	}
	
	// Innere statische Klasse
	static class Katze {
	}
	
	Object att = new Object() {
		public String toString() {return "Object aus dem Zoo: " + Zoo.this;}
	};
	
	static Object staticAtt = new Object() {
//		public String toString() {return "Object aus dem Zoo: " + Zoo.this;}
	};
	
	
	static void staticMethod() {
		
		// Lokale Klasse
		class Affe {
//			public String toString() {return "Affe aus dem Zoo: " + Zoo.this;}
		}
		
		new Object() {
//			public String toString() {return "Object aus dem Zoo: " + Zoo.this;}
		};
	}
	
	
	void method() {
		
		// Lokale Klasse
		class Zebra {
			public String toString() {return "Zebra aus dem Zoo: " + Zoo.this;}
		}
		
		new Object() {
			public String toString() {return "Object aus dem Zoo: " + Zoo.this;}
		};
		
	}
	
} // end of Zoo

public class B08_AlleArtenInnererKlassen {

	public static void main(String[] args) {
		
		new Zoo().new Hund();
		new Zoo.Katze();
		
		Object x = new Zoo().att;
		System.out.println(x);
		
		Object x2 = new Zoo().staticAtt;
		
	}
	
}
