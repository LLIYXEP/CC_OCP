package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class B08_Chaining {

	public static void main(String[] args) throws IOException {

		/*
		 * Bitte immer nur den äußeren Stream zum Lesen/Schreiben verwenden!
		 */
		
		/*
		 * Bitte NICHT SO:
		 */
		
		FileWriter fw = new FileWriter("xyz.txt");
		
		BufferedWriter out = new BufferedWriter(fw);
		
		out.write('x'); // zwischenpuffern in out-Puffer [x]
		
		fw.write('z'); // zwischenpuffern in fw-Puffer: [z]
		
		out.close(); // dadurch wird auch der FileWriter geschlossen,
					 // aber zuerst wird zwischenpuffer aus out an das Ziel geschoben:
					 // so sieht dann der Puffer von fw aus: [zx]	
		
				
		
		/*
		 * besser mit Constructor-Chaining und dann immer nur einer Writer-Variable:
		 */
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("hallo.txt"));
		
		writer.write("ha");
		writer.write("llo");
		
		writer.close();
		
		
		System.out.println("fertig");
		
	}

}
