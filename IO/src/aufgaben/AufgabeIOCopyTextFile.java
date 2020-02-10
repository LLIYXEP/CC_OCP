package aufgaben;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AufgabeIOCopyTextFile {

	public static void main(String[] args) throws IOException {
		
		FileUtils.copyTextFile("hersteller.txt", "hersteller4.txt", false);
		
		
		System.out.println("Datei kopiert!");
		
	}
	
}
