package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class B04_BufferedReader_BufferedWriter {

	public static void main(String[] args) throws IOException {
		
		Reader r = new FileReader("hersteller.txt");
		
//		BufferedReader in = new BufferedReader(r);  // default-buffer-size
		BufferedReader in = new BufferedReader(r, 32);  // buffer - size: 32
		
		String line;
		while ((line = in.readLine()) != null) {  // readLine lieferte Zeile ohne Zeilenumbruch-Zeichen
			System.out.println("Zeile gelesen: " + line);
		}
		
	}
	
}
