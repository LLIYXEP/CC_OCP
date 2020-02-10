package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class B08_Chaining {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new  FileWriter("xyz.txt");
		
		BufferedWriter out = new BufferedWriter(fw);
		
		out.write('x'); // zwischenpuffer in out
		
		fw.write('z');	// zwischenpuffer in fw
		
		out.close(); // z x
		
		
		/*
		 * Besser mit Constructor Chaining und dann immer nur einer Writer-Variable
		 */
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("hallo.txt"));
		
		writer.write("ha");
		writer.write("llo");
		
		writer.close();
		
		System.out.println("fertig");
		
	}
	
}
