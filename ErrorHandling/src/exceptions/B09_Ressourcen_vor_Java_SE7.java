package exceptions;

import java.io.FileReader;
import java.io.IOException;

public class B09_Ressourcen_vor_Java_SE7 {

	public static void main(String[] args) {
		
		String file = "abc.txt";
		
		FileReader in = null;
		
		try {
			in = new FileReader(file);
		
			System.out.println(in.read());
		
//			in.close(); // keine Garantie, dass diese Zeile erreicht wird
			
		} catch (IOException e) {
			System.err.println("Fehler beim Offnen oder Lesen der Datei");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				System.err.println("Fehler beim schliesen der datei");
			}
		}
		
		
		
		
	} // end of main
	
}
