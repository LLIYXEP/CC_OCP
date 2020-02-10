package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class B01_Schreiben {
	
	public static void main(String[] args) {
//		vorJava7();

		mitTryWithResources();
		
		System.out.println("fertig");
	}

	/*
	 * Empfohlener Weg: try-with-resources
	 */
	static void mitTryWithResources() {
		
		try (Writer out = new FileWriter("def.txt")) {
			out.write('d'); // <- bitte in der Praxis nicht so schreiben (ein char pro write-Aufruf)
			out.write('e');
			out.write('f');
		} catch (IOException e) {
			System.out.println("Fehler beim Öffnen, Schreiben oder Schliessen.");
		} 
	}
	
	/*
	 * Ressourcen vor Java 7. finally-Block war nötig, um die Methode close aufzurufen
	 */
	static void vorJava7() {

		Writer out = null;
		
		try {
			out = new FileWriter("def.txt");
			
			out.write('d');
			out.write('e');
			out.write('f');
			
		} catch(IOException e) {
			System.out.println("Fehler beim Öffnen oder Schreiben.");
			
		} finally {
			try {
				if(out!=null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("Fehler beim Schliessen.");
			}
		}
	}

}
