package io;

import java.io.Console;
import java.time.LocalDate;

/*
 * Folgende main wird nicht in der Eclipse-Konsole laufen. 
 * Zum Ausproblieren muss die Anwendung in der richtigen Konsole gestartet werden:
 * 
 * 		java -cp bin io.B07_Console
 * 
 * Zum Starten unter Eclipse kann man das Plugin 'Terminal' verwenden:
 * 		Window->Show View->Other->Terminal->Terminal
 * 
 * Besser:
 * 		- eine Batch-Datei anlegen (s. run_console_bsp.bat)
 * 		- Rechte Maustaste -> Show In -> Terminal
 * 
 * 
 */

public class B07_Console2 {

	public static void main(String[] args) {


//		Console console = new Console(); // exam (Compilerfehler)
		Console console = System.console();
		
		/*
		 * Ausgeben
		 */
		
		
		console.format("heute ist %s %n", LocalDate.now());	
		console.printf("morgen ist %s %n", LocalDate.now().plusDays(1));		
		
		/*
		 * Benutzereingaben Einlesen, Variante 1:
		 */
		console.format("Geben Sie etwas ein: %n");
		String eingabe = console.readLine();						// exam: liefert String zurück
		
		console.format("Ihre Eingabe war: %s %n", eingabe);
		
		/*
		 * Benutzereingaben Einlesen, Variante 2:
		 */
		eingabe = console.readLine("Geben Sie noch etwas ein: %n"); // exam: liefert String zurück
		
		console.format("Ihre 2. Eingabe war: %s %n", eingabe);

		/*
		 * Passwort einlesen, Variante 1:
		 */
		console.format("Bitte das Passwort eingeben: ");
		// String pwd = console.readPassword();						// exam: Compilerfehler, liefert char[]
		
		char[] pwd = console.readPassword();						// exam: liefert char[]
		console.format("Danke! %n");
		
		/*
		 * Passwort einlesen, Variante 2:
		 */
		pwd = console.readPassword("Bitte nochmal das Passwort eingeben: ");// exam: liefert char[] 
		console.format("Danke nochmal! %n");
		
	}

}
