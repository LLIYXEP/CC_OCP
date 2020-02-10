package aufgaben.filescounter;

import java.io.IOException;

/*
 * Achtung! Bei der Lösung wurde die Aufgabestellung etwas modifiziert.
 * 
 * Unterschiedliche FilesCounter-Realisierungen werden entweder direkt (flach, 'flat') 
 * oder rekursiv ('deep') nach Dateien in der Methode 'count' suchen (also keine zusätzliche Methode 'countDeep').
 */
public class AufgabeFilesCounter {

	public static void main(String[] args) throws IOException {
		String dirName = "C:\\Program Files\\7-Zip";
//		String dirName = "C:\\Windows";
//		String dirName = "C:\\";
		
		System.out.println("*** Flat-Search mit Files.newDirectoryStream");
		testFilesCounterRealisation( new FlatFilesCounterV1(dirName) ); // 3
		
		
		
		System.out.println("*** Deep-Search mit Files.walk");
		try {
			testFilesCounterRealisation( new DeepFilesCounterWalk(dirName) ); // 91
			
		} catch (Exception e) {
			System.out.println("Fehler!!!: " + e);
		}
		
		
		System.out.println("*** Deep-Search mit Files.walkFileTree");
		testFilesCounterRealisation( new DeepFilesCounterWalkFileTree(dirName) ); // 91
		
	}

	static void testFilesCounterRealisation(FilesCounter fc) throws IOException {
		String extension = "txt";
		
		int count = fc.count(extension);
		System.out.println("count: " + count);
	}
	
}
