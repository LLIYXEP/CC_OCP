package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class B03_Lesen_Schreiben_mit_eigenem_Puffer {

	public static void main(String[] args) throws IOException {
		
		// Die Datei hersteller.txt:
		//                  01 2 34567 8 901234567
		System.out.println("VW\r\nAudi\r\nMercedes"); // 18 Zeichen (Windows-Zeilenumbruch)

		System.out.println( (int)'\r' ); // 13
		System.out.println( (int)'\n' ); // 10
		
		
		try( Reader in = new FileReader("hersteller.txt"); 
				Writer out = new FileWriter("hersteller2.txt") ) {

			char[] cbuf = new char[8];
			
			int count;
			while( (count = in.read(cbuf)) != -1 ) { // <- besseres Lesen (als im Bsp. 02)
				
				System.out.println("* gelesen " + count + " Zeichen: ");
				System.out.println("|" + String.valueOf(cbuf, 0, count) + "|" );
				
				out.write(cbuf, 0, count); // <- besseres Schreiben (als im Bsp. 01)
				
			}
		}
		
	}

}
