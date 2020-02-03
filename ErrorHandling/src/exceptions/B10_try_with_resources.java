package exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class B10_try_with_resources {

	public static void main(String[] args) throws IOException {
		
		String file = "abc.txt";
		
//		try(FileReader in = new FileReader(file)) {
//			
//		} // in wird inplizit ( und NullPointer-sicher) beim Beenden vom try  geschlossen (mit in.close())
		
		try(FileReader in = new FileReader(file)) {
			System.out.println(in.read());
		} // in wird inplizit ( und NullPointer-sicher) beim Beenden vom try  geschlossen (mit in.close())
		catch (IOException e) {	// IOException aus try-Block aber auch die aus der close-Methode konnen den catch aktivieren
			System.err.println("Fehler beim Offen, Lesen ODER Schliessen");
		}
		
		
	}
	
}
