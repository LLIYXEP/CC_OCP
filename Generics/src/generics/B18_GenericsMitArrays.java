package generics;

public class B18_GenericsMitArrays {
	
	static class Test <T> {
		
		void m1 (T... arr) { // Warnung (nicht in der Prufung)	
//			T[] arr1 = new T[]; // CF
		}
		
		void m2 (T e1, T e2) {
			
			T[] arr1 = null; // OK 
			
//			T[] arr2 = new T[2]; // CF
			
			boolean result = e1 instanceof Integer;
			
//			result = e1 instanceof T; // CF
		}
		
	}

	public static void main(String[] args) {
		
		Test<Integer> var1 = new Test<Integer>();
		var1.m1(1, 2, 3, 4);
		
	}
	
}
