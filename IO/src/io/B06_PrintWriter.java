package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class B06_PrintWriter {

	public static void main(String[] args) {

		String fileName = "heute";
		
		// PrintWriter ist der Klasse PrintStream sehr ähnlich (s. System.out)
		
		try ( PrintWriter out = new PrintWriter(fileName) ) {
			
			out.println("Hallo PrintWriter!");
			
			out.format("Heute ist %s %n", LocalDate.now());
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("fertig");
	}

}
