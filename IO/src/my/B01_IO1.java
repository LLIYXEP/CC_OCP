package my;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class B01_IO1 {

	public static void main(String[] args) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("hersteller.txt"));
				BufferedWriter wr = new BufferedWriter(new FileWriter("home-test.txt"))) {
			char[] cbuf = new char[8];
//			String str;
			int count;
			while( (count = br.read(cbuf)) != -1 ) { // <- besseres Lesen (als im Bsp. 02)
				
				System.out.println("* gelesen " + count + " Zeichen: ");
				System.out.println("|" + String.valueOf(cbuf, 0, count) + "|" );
				
				wr.write(cbuf, 0, count); // <- besseres Schreiben (als im Bsp. 01)
				
			}
		}
		
	}
	
}
