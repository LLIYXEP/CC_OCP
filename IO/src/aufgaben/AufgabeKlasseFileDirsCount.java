package aufgaben;

import java.io.File;

public class AufgabeKlasseFileDirsCount {

	public static void main(String[] args) {
		
		/*
		 * - Suchen Sie ein einfaches Verzeichnis aus
		 *    (z.B. "C:\\Program Files\\7-Zip")
		 *    
		 * - Durchsuchen Sie es rekursiv und ermitteln Sie die Anzahl alle Unterverzeichnisse
		 * 
		 *  Tipp: Methode listFiles verwenden
		 *  
		 * - Die Lösung mit komplexereren Verzeichnissen testen.
		 */
		
		File dir = new File("C:\\Program Files\\7-Zip");
		System.out.println("1: " + getCountDirs(dir));
		
		dir = new File("C:\\Local\\jdk-11.0.5+10");
		System.out.println("2: " + getCountDirs(dir));
		
		dir = new File("C:\\");
		System.out.println("3: " + getCountDirs(dir));
	} // end of main
	
	
	/*
	 * - Finde direkte Unterverzeichnisse
	 * - Ermittle die Anzahl
	 * - für jedes Unterverzeichnis: 
	 * 		- aktiviere den Algorithmus
	 * 		- erhalte die Ergebnisse
	 * 		- addiere zu der lokalen Anzahl 
	 * - Liefere die Anzahl zurück
	 */
	static int getCountDirs(File dir) {
		
		File[] subdirs = dir.listFiles(File::isDirectory);
		
		int count = 0;
		
		if(subdirs==null) {
			System.out.println("kein Zugriff: " + dir);
		}
		
		if(subdirs!=null) { // if-Abfrage für die Verzeichnisse ohne Rechte zum Lesen
			count = subdirs.length;
			
			for(File sDir : subdirs) {
				count += getCountDirs(sDir);
			}
		}
		
		return count;
	}

}
