package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class B10_Files_copy_move {

	/*
	 * Exam: 
	 *
	 * 		Files.copy(source, target, options);
	 * 		Files.move(source, target, options);
	 * 
	 * source: Pfad zu der Quell-Datei
	 * target: Pfad zu der Quell-Datei - Dateiname inklusive (!!!)
	 * 
	 */
	public static void main(String[] args) {
//		test_copy();
		test_move();
	}
	
	static void test_move() {
		System.out.println("*** test move");

		Path source = Paths.get("abc.txt");
		Path sourceCopy = Paths.get("abc-kopie");
		
		// Eine Datei für den nächsten Test vorbereiten:
		try { Files.copy(source, sourceCopy, StandardCopyOption.REPLACE_EXISTING); } catch (IOException e) { e.printStackTrace(); }
		
		/*
		 * 1. 
		 */
		Path target1 = Paths.get("new-file.txt");
		try {
			System.out.println("source: " + sourceCopy + " ist da: " + Files.exists(sourceCopy));
			System.out.println("target: " + target1 + " ist da: " + Files.exists(target1));
			
			Path result = Files.move(sourceCopy, target1, StandardCopyOption.REPLACE_EXISTING);

			System.out.println("Datei erstellt: " + result);
			System.out.println("source: " + sourceCopy + " ist da: " + Files.exists(sourceCopy));
			System.out.println("target: " + target1 + " ist da: " + Files.exists(target1));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * Auf weitere Situationen reagiert die move ähnlich wie copy (s. test_copy())
		 */
		
		
		/*
		 * Aufräumen
		 */
		try {
			Files.delete(target1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void test_copy() {
		System.out.println("*** test copy");
		
		Path source = Paths.get("abc.txt");
		
		Path targetDir = Paths.get("myfiles");
		
		Path target = targetDir.resolve("abc.txt");
		
		
		/*
		 * static Path copy(Path source, Path target, CopyOption... options)
		 */
		
		/*
		 * 1. Eine Datei wird in das existierende Zielverzeichnis kopiert
		 */
		try {
			Files.createDirectories(targetDir);
			
			Path result = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("1. Datei kopiert in " + result);
			
			System.out.println("1. exists: " + Files.exists(target));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 2. Achtung in der Prüfung! hallo ist kein Verzeichnis, in dem eine Datei entsteht!
		 *    hallo ist der Pfad zu einer neuen Datei inklusive des Dateinamens.
		 */
		Path target2 = Paths.get("hallo");
		try {
			Files.createDirectories(targetDir);
			
			Path result = Files.copy(source, target2, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("2. Datei kopiert in " + result);
			
			System.out.println("2. exists: " + Files.exists(target2));
			System.out.println("2. Dateiname: " + target2.getFileName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 3. Wenn das Zielverzeichnis nicht exisitiert, gibt es eine NoSuchFileException
		 */
		Path target3 = Paths.get("myfiles3/abc.txt");
		try {
			Files.copy(source, target3); // java.nio.file.NoSuchFileException: abc.txt -> myfiles3\abc.txt
			
		} catch (Exception e) {
			System.err.println("3. Fehler: " + e);
		}
		
		
		/*
		 * Eher nicht in der Prüfung:
		 * 4. Wenn target ein leeres Verzeichnis ist, wird copy das Verzeichnis löschen, und eine Datei mit diesem Namen erstellen 
		 */
		Path target4 = Paths.get("myfiles4");
		
		try {
			Files.createDirectory(target4);
			System.out.println("4. ist myfiles4 ein Verzeichnis: " + Files.isDirectory(target4)); // true
			
			Path result = Files.copy(source, target4, StandardCopyOption.REPLACE_EXISTING); // target4 unlogisch für diesen Aufruf
			
			System.out.println("Datei erzeugt: " + result);
			
			System.out.println("4. ist myfiles4 ein Verzeichnis: " + Files.isDirectory(target4)); //false 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 5. Wenn target ein NICHT-leeres Verzeichnis ist:  
		 */
		Path target5 = Paths.get("myfiles5");
		Path tmpFile5 = target5.resolve("tmp.txt");
		
		try {
			// ein nicht-leeres Verzeichnis vorbereiten:
			Files.createDirectory(target5);
			Files.copy(source, tmpFile5, StandardCopyOption.REPLACE_EXISTING); 
			
			System.out.println("5. ist myfiles5 ein Verzeichnis: " + Files.isDirectory(target5)); // true
			
			// test copy
			Files.copy(source, target5, StandardCopyOption.REPLACE_EXISTING); // java.nio.file.DirectoryNotEmptyException: myfiles5
			
		} catch (IOException e) {
			System.err.println("5. Fehler: " + e);
		}
		
		/*
		 * copy ohne REPLACE_EXISTING wirft die FileAlreadyExistsException, wenn eine Datei unter dem Zielpfad (hier: tmpFile5)
		 * bereits existiert
		 */
		try {
			Files.copy(source, tmpFile5); // java.nio.file.FileAlreadyExistsException: myfiles5
			
		} catch (IOException e) {
			System.err.println("6. Fehler: " + e);
		}
		
		/*
		 * Aufräumen
		 */
		try {
			Files.delete(target);
			Files.delete(targetDir);
			
			Files.delete(target2);
			Files.delete(target4);

			Files.delete(tmpFile5);
			Files.delete(target5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
