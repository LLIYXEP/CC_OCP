package designpatterns;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/*
 * Pattern Factory Method: das Bilden eines Objektes verstecken und so vom Code der Anwendung trennen.
 */

abstract class Fahrbar{
	public static Fahrbar createInst() {
		return new VW();
	}
}

class VW extends Fahrbar{}
class Mercedes extends Fahrbar{}

public class Pattern_FactoryMethod {

	public static void main(String[] args) {
		
		//statt uberall im Projekt mit dem Konstruktor einer konkreten Klasse:
		Fahrbar f1 = new Mercedes();
		
		//uberall im Projekt die 'fabrikmethode' verwenden um Objekte vom 'Standard-Typ' zu bilden:
		Fahrbar f2 = Fahrbar.createInst();
		
		/*
		 * Bsp aus der Standartbibliotek
		 * 
		 * DateFormat ist eine abstrakte Klasse
		 * in der die Details zum Bilden des konkreten Objektes von der Anwendung versteckt sind
		 */
		DateFormat df = DateFormat.getInstance();
		String s1 = df.format(new Date());
		
		/*
		 * weitere Beispiele
		 */
		NumberFormat nf = NumberFormat.getInstance();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
		
	}
	
}
