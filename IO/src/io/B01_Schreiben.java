package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class B01_Schreiben {
	
	public static void main(String[] args) {
		
		vorJava7();
		tryMitResources();
	}
	
	public static void tryMitResources()  {

		try (Writer out = new FileWriter("def.txt");) {
			out.write('d');   // <- bitte in der Praxis nicht so schreiben (ein char pro read-Aufruf)
			out.write('e');
			out.write('f');
		} catch (IOException e) {
			System.out.println("Fehler beim Offnen oder Schreiben. " + e);
		}
		
		System.out.println("fertig");
	}
		
	

	public static void vorJava7()  {
		
		Writer out = null;
		
		try {
			out = new FileWriter("def.txt");
			out.write('d');
			out.write('e');
			out.write('f');
		} catch (IOException e) {
			System.out.println("Fehler beim Offnen oder Schreiben. " + e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				System.out.println("Fehler beim Schliessen der Datei. " + e);
			}
			
		}
		
		
		
		System.out.println("fertig");
		
	}
	
}
