package wrapper;

public class B03_Autoboxing_Autounboxing {

	public static void main(String[] args) {
		
		Integer v1 = 12; // Autoboxing: Integer = Integer.valueOf(12)
		Byte v2 = 12; 
		Short v3 = 12; 
//		Long v4 = 12; 	// CF
//		Float v5 = 12; 	// CF
//		Double v7 = 12; // CF
		
		int x1 = v1; // Autounboxing:    int x1 = v1.intValue();
		
		/*
		 * Falls sowohl Autoboxing als Autounboxing
		 * helfen konnen wird das Autounboxing eingesetzt
		 */
		System.out.println(x1 == v1); // Autounboxing: x1 == v1.intValue();
		
		double d1 = 11;
		System.out.println(d1 < v1); // Autounboxing: d1 < v1.intValue();
		
		System.out.println(d1 == v1); 
		
		Double d2 = d1;
		
		// Achtung bei != oder == gibt es kein Autounboxing!!!
//		System.out.println(d2 == v1); 	// CF: Referenzen von Geschwisterklassen
	}
	
	
}
