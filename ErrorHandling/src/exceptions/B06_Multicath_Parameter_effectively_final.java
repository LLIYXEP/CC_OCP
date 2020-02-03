package exceptions;

public class B06_Multicath_Parameter_effectively_final {
	
//	static void m1() {
//		throw new Exception(); // checked
//	}
	
//	static void m2() {
//		throw new ArithmeticException(); // unchecked
//	}
//	
//	static void m3() {
//		Exception e = new ArithmeticException(); // unchecked
//		throw e; // checked-Typ der Referenz
//	}
//	
//	static void m4() {
//		ArithmeticException e = new ArithmeticException(); 
//		throw e;
//	}

	public static void main(String[] args) {
		
		try {
			
		} catch (Exception e) {
			e = new ArithmeticException();
		}
		
		/*
		 * Achtung !
		 * der parameter in Multicath ist 'effectivly final'
		 */
		try {
			
		} catch (NullPointerException | ArithmeticException e) {
			e = new ArithmeticException(); // CF e is effectively final
//			e = null; // geth auch nicht
		}
		
	}
	
}
