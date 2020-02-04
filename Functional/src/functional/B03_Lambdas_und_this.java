package functional;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class B03_Lambdas_und_this {

	public static void main(String[] args) {
		
		Predicate<String> p1 = new Predicate<String>() {	
			@Override
			public boolean test(String s) {
				System.out.println("test von " + this);
				return s!=null;
			}
		};
		
		p1.test("Tom");
		
		System.out.println(p1.getClass()); // class functional.B03_Lambdas_und_this$1
		
		/*
		 * Achtung! Lambdas haben keine this - Referenzen!
		 */
		
		Predicate<String> p2 = (String s) -> {
//			System.out.println("test von " + this); // CF
			return s!=null;
		};
		
		System.out.println(p2.getClass()); // functional.B03_Lambdas_und_this$$Lambda$1/0x0000000100060840

	}
	
}
