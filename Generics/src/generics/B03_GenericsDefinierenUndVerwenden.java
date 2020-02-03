package generics;

import java.util.ArrayList;
import java.util.Map;

/*
 * Definieren (generischer typ: MyValue <T>)
 * 
 * 		T - Typparameter (Instanzbezogen)
 * 
 * 		T extends Number - Type Bound (Typeinschrenkung) extends steht hier fur IS-A
 */

class MyValue <T extends Number> {
//	static T att;				// CF (T ist nur fur Instanz-Methodenbzw. Instanz- Attribute definiert)
//	static void use(T t) {}		// CF (T ist nur fur Instanz-Methodenbzw. Instanz- Attribute definiert)
	
	T value;
	void set(T value) {
		this.value = value;
	}
	T get() {return value;}
}

public class B03_GenericsDefinierenUndVerwenden {

	public static void main(String[] args) {
		
		/*
		 * Verwenden und dabei parametrisieren
		 */
		MyValue<Integer> v1;
		
		class MyIntValue extends MyValue<Integer> {}
		
		Map<Integer, String> map;
		
		/*
		 * Achtung! Bitte Immer parametrisieren
		 * 
		 * Obwohl es auch ohne Parametrisierung geht:
		 */
		
		MyValue v2; // MyValue ohne Parametrisierung: raw type (original typ)
		
		ArrayList list; //ArrayList: raw type
	}
	
}
