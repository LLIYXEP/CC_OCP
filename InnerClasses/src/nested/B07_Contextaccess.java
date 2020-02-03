package nested;

public class B07_Contextaccess {
	
	 static int nummer = 1;

	public static void main(String[] args) {
		
//		b1();
//		b2();
		b3();
		
	} // end of main
	
	static void b3() {
		int nummer = 3;
		
		System.out.println(new Object() {
			@Override
			public String toString() {
//				nummer = 5; // Compilerfehler
				return "Object " + nummer; // 3 ( geht wenn die lokale Variable nummer ' effectively final' ist)
			}
		}); // Object 3
		
		nummer = 4; // lokale Variable andern
	}
	
	static void b2() {
		class Tier {
			int nummer = 2;
		}
		
		class Hund extends Tier {
			public String toString() {
				return "Hund " + nummer;
			}
		}
		System.out.println(new Hund()); // Hund 2
	}
	
	static void b1() {
		class Katze {
			public String toString() {
				return "Katze " + nummer;
			}
		}
		System.out.println(new Katze());
		nummer = 4; // statische Variable andern
		
	}
}
