package wrapper;

public class B01_API {

	public static void main(String[] args) {
		
//		konstruktoren();
//		boxingMethods();
//		unboxingMethods();
		parsingMethods();
		
	}
	
	static void parsingMethods() {
		
		/*
		 * valueOf(String)   //Byte ... Double
		 */
		Short v1 = Short.valueOf("12");
		System.out.println(v1);
		
//		Short v2 = Short.valueOf("(short)12");
		
		try {
			Short.valueOf("(short)12");
		} catch (NumberFormatException e) {
		}
		
		/*
		 * Character hat keine valueOf(String);
		 */
		
//		Character.valueOf("a"); // CF
		
		Boolean v2 = Boolean.valueOf("trye");
		
		/*
		 * parseXXX(String)  //Byte ... Double
		 */
		int x1 = Integer.parseInt("12");
		float x2 = Float.parseFloat("12");
		
//		Character.parseCharacter('a'); // CF
		
		Boolean.parseBoolean("true");
	}
	
	static void unboxingMethods() {
		Integer v1 = 12;
		int x1 = v1.intValue(); // unboxing
		
		Character v2 = 'a';
		char x2 = v2.charValue(); // unboxing
		
		Boolean v3 = true;
		boolean x3 = v3.booleanValue(); // unboxing
	}
	
	static void boxingMethods() {
		Byte v1 = Byte.valueOf((byte)12);
		Float v2 = Float.valueOf(12F);
		
		Character v3 = Character.valueOf('a');
		Boolean v4 = Boolean.valueOf(true);
	}
	
	static void konstruktoren() {
		Integer i = new Integer("12");
		System.out.println(i);
		
//		new Character("a");
		
		try {
			new Integer("hello");
		} catch (NumberFormatException e) {
			System.out.println("Fehler: " + e.getMessage());
		}
	}
	
}
