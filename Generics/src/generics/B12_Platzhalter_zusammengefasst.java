package generics;

import java.util.function.Consumer;

public class B12_Platzhalter_zusammengefasst {

	public static void main(String[] args) {
		Consumer<Number> cNumber = n -> System.out.println(n);
		
		/*
		 * ? extends Number erlaubt Parametrisierung mit Number oder abgeleitet von Number
		 */
		Consumer<? extends Number> cExtNumber;
		
		
		cExtNumber = cNumber;
		
		cNumber.accept(22);
		
		/*
		 * Mit einer ? extends parametrisierung Referenz lassen sich keine Methoden aufrufen,
		 * die den generischen Typparameter als Parameter haben
		 */
//		cExtNumber.accept(22); // CF
		
		
		/*
		 * ? super Integer
		 * 			erlaubt Parametrisierung mit Integer oder mit dem Basistyp fur Integer
		 */
		Consumer<? super Integer> cSuperInteger;
		
		cSuperInteger = cNumber;
		cSuperInteger.accept(22);
		
		Number n = 22;
//		cSuperInteger.accept(n); // CF n konnte ja auch Double sein/ Nur Integer-Argumente wurden kompilieren
		
		
		/*
		 * Die Parametrisierung <?> ist equivalent mit der Parametrisierung <? extends Object>
		 */
		
		Consumer<?> cExt;
		cExt = cNumber;
//		cExt.accept(22); // CF
		
		
		
		
		
		
		
		/*
		 * Unwahrscheinlich in der Prufung: 
		 * 
		 * Parametrisierung mit Platzhalter als Namen-Mengen
		 * 
		 * <Number>    -   Menge mit einem Namen
		 * 
		 * <? extends Number>   - Menge mit Namen: Number, Integer, Double, Float...
		 * 							Diese Menge ist oben mit Number beschränkt, nach unten ist sie offen
		 * 
		 * <? super Integer>	- Menge mit Namen: Integer, Number, Comparable, Serialicable, Object.
		 * 							Jede ? super Menge ist nach oben mit Object beschränkt, nach unten beschränkt mit Integer
		 * 
		 * Die Zuweisung der parametrisierten Referenzen kompiliert
		 * wenn die linke Menge der Namen  komplett die rechte Menge einschliesst.
		 */
		
		Consumer<? super Integer> cA = null;
		Consumer<? extends Number> cB = null;
		
//		cA = cB; // CF
//		cB = cA; // CF
		
		Consumer<? extends Integer> cC = null;
		
		cB = cC;
		cB = new Consumer<Integer>() {
			public void accept(Integer t) {
			}};
//		cC = cB; 
			Consumer<?> cD = cA;
		
			cD = cB;
	}
	
}
