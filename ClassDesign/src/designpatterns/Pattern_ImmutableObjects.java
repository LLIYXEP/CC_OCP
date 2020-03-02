package designpatterns;

import java.util.ArrayList;
import java.util.List;

/*
 * MyIntValue nach 'Immutable Objects' entwickelt:
 * (gut gekapselt + final)
 */

final class MyIntValue {
	private int value;

	public MyIntValue(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	
}

//class X extends MyIntValue{
//	int i;
//	
//	public X(int value) {
//		super(value);
//		
//	}
//
//	
//	public int getValue() {
//		return super.getValue() + i++;
//	}
//	
//}

/*
 * Immutable Objects Pattern : Klasse so gestalten, dass Ihre Objecte niicht geandert werden konnen
 */

public class Pattern_ImmutableObjects {

	public static void main(String[] args) {
		
		/*
		 * Klassen aus der Standartbibliotek:
		 * String, LocalDate...
		 */
		
		MyIntValue v1 = new MyIntValue(3);
		
		System.out.println(v1.getValue());
		System.out.println(v1.getValue());

		
	}

	
	//So lange die ArrayList erreichbar bleibt, wird Immutable Objects nicht realisiert.
	
	public class laden{
		List<String> produkte = new ArrayList<String>();

		public List<String> getProdukte() {
			return produkte;
		}
		
	}
	
}
