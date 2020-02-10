package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class B04_BufferedReader_BufferedWriter {

	public static void main(String[] args) throws IOException {

		Reader r = new FileReader("hersteller.txt");
		
//		BufferedReader in = new BufferedReader(r); // mit default-buffer-size
		BufferedReader in = new BufferedReader(r, 32); // buffer size: 32 chars
		
		Writer w = new FileWriter("hersteller3.txt");
		
//		BufferedWriter out = new BufferedWriter(w);
		BufferedWriter out = new BufferedWriter(w, 32); // buffer size: 32 chars
		
		String line;
		while( (line = in.readLine()) != null ) { // readLine liefert Zeile ohne Zeilenumbruch-Zeichen
			System.out.println("Zeile gelesen: " + line);
			
			out.write(line);
			out.newLine();
		}
		
		out.close();
		in.close();
		
	}

}
