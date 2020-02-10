package io;

import java.io.Console;
import java.time.LocalDate;

/*
 * Folgende main wird nicht in der Eclipse-Consolelaufen.
 * Zum Ausprobieren muss die Anwendung in der richtigen Console gestartet werden:
 * 
 * 	java io.B07_Console
 * 
 * Zum Starten unter Eclipse kann man das Plugin 'terminal' verwenden
 */

public class B07_Console {

	public static void main(String[] args) {
		
//		Console console = new Console(); // exam Compilerfehler
		
		Console console = System.console();
		
		
		console.format("heute ist %s %n", LocalDate.now());
		console.format("heute ist %s %n", LocalDate.now());
		
	}
	
}
