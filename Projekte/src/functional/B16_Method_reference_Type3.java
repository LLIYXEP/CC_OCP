package functional;

import java.util.function.UnaryOperator;

/*
 * Type 3: Referenz auf eine Instanzemethode von einem speziellen (vorhadenen) Objekt
 */

public class B16_Method_reference_Type3 {

	public static void main(String[] args) {
		
		String var = "Java";
		
		/*
		 * anonyme Klasse
		 */
		UnaryOperator<String> op0 = new UnaryOperator<>() {
			public String apply(String s) {
				return var.concat(s);
			}
		};
		
		/*
		 * Lambda
		 */
		UnaryOperator<String> op1 = s -> var.concat(s);
		
		/*
		 * referenz auf eine Instanz Methode von einem speziellen Objekt (hier das Objekt hinter der var)
		 */
		UnaryOperator<String> op2 = var::concat; // var muss nich effectively final sein
		
		String apply = op2.apply("!");
		System.out.println(apply);
		
		
		
	} // main
	
}
