package io;

import java.io.PrintWriter;
import java.time.LocalDate;

public class B06_PrintWriter {

	public static void main(String[] args) {
		
		String file = "heute";
		
		// PrintWriter ist der Klasse PrintStream sehr anlich
		try (PrintWriter out = new PrintWriter(file)) {
			out.println("Hallo welt");
			out.format("Heute ist %s %n", LocalDate.now());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("fertig");
		
	}
	
}
