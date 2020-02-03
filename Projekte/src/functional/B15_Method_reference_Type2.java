package functional;

import java.util.function.Function;
import java.util.function.Supplier;

class MyNumber {
	int value;

	public MyNumber(int value) {
		super();
		this.value = value;
	}
	public MyNumber() {
	}
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}

/*
 * Typ 2. referenz auf einen Konstruktor
 */

public class B15_Method_reference_Type2 {

	public static void main(String[] args) {
		
		/*
		 * anonyme Klasse
		 */
		Supplier<MyNumber> s0 = new Supplier<MyNumber>() {
			public MyNumber get() {
				return new MyNumber();
			}
		};
		
		/*
		 * Lambda
		 */
		Supplier<MyNumber> s1 = () -> new MyNumber();
		
		/*
		 * referenz auf einen Konstruktor
		 */
		Supplier<MyNumber> s2 = MyNumber::new;
		
		kleineAufgabe();
		
	} // main
	
	static void kleineAufgabe() {
		
		Function<Integer, MyNumber> var0 = new Function<Integer, MyNumber>()  {
				public MyNumber apply(Integer value) {
					return new MyNumber(value);
				}
		};
		
		
		Function<Integer, MyNumber> var2 = MyNumber::new;
		
	}
	
}
