package wrapper;

public class B02_API_Boolean {

	public static void main(String[] args) {
		
//		Integer.parseInt("hello"); // NumberFormatException
//		Integer.valueOf("hello"); // NumberFormatException
		
		/*
		 * Boolean kann Akke String in Boolean vwerwandeln
		 * 
		 * die Zeichen 'true' (egal klein oder gross) ergeben true, alle anderen Strings ergeben false.
		 */
		
		Boolean v1 = Boolean.valueOf("true"); 
		System.out.println("1: " + v1);
		
		Boolean v2 = Boolean.valueOf("tRue"); 
		System.out.println("2: " + v2);
		
		System.out.println("3: " + Boolean.valueOf("wahr")); // false
		
		String s = null;
		System.out.println("4: " + Boolean.valueOf(s));  // false
		
	}
	
}
