package files;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class B10_Files_copy_move {
	
	public static void main(String[] args) {
		
		test_copy();
//		test_move();
		
	}

	public static void test_move() {
		
		System.out.println("***** test move");
		
		Path source = Paths.get("abc.txt");
		Path sourceCopy = Paths.get("abc-kopie");
		try {
			Files.copy(source, sourceCopy, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.err.println("1. Fehler: " + e);
		}
		
		
		/*
		 * 1
		 */
		Path target1 = Paths.get("new-file.txt");
		try {
			System.out.println("sourceCopy: " + sourceCopy + " : " + Files.exists(sourceCopy));
			System.out.println("target1: " + target1 + " : " + Files.exists(target1));
			Path result = Files.move(sourceCopy, target1, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("Datei erstellt: " + result);
			System.out.println("sourceCopy: " + sourceCopy + " : " + Files.exists(sourceCopy));
			System.out.println("target1: " + target1 + " : " + Files.exists(target1));
		} catch (IOException e) {
			System.err.println("2. Fehler: " + e);
		}
		
		
		
		/*
		 * Auf weitere Situationen reagiert die move anlich wie copy
		 */
		
		
		
		
		try {
			Files.delete(target1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void test_copy() {

		/*
		 * Exam
		 * 
		 * 			Files.copy(source, target, options);
		 * 			Files.move(source, target, options);
		 * 
		 * source: Pfad zu der Quell - Datei
		 * target: Pfad zu der Quell - Datei - Dateiname inklusive !!! 
		 */
		
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
			System.out.println("1. result: " + result);
			System.out.println("1. exists: " + Files.exists(target));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 2 . Achtung in der Prufung ! Hallo ist kein Vrzeichniss, in dem eine Datei entsteht!
		 * 		hallo ist der Pfad zu einer neuen datei inklusive des Dateinames.
		 */
		Path target2 = Paths.get("hello");
		try {
			Files.createDirectories(targetDir);
			Path result = Files.copy(source, target2, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("2. result: " + result);
			System.out.println("2. exists: " + Files.exists(target2));
			System.out.println("2. getFileName: " + target2.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 3 Wenn das Zielverzeichnis nicht existiert, gibt es eine NoSuchFileException
		 */
		Path target3 = Paths.get("myfiles3/abc.txt"); 
		
		try {
			Files.copy(source, target3);
		} catch (Exception e) {
			System.err.println("1. Fehler: " + e); // NoSuchFileException: abc.txt -> myfiles3\abc.txt
		}
		
		
		
		/*
		 * 4 Wenn target ein leeres Verzeichnis ist , wird copy das Verzeichnis loschen, und eine Datei mit diesem Namen ersetzt
		 */
		Path target4 = Paths.get("myfiles4"); 
		
		try {
			Files.createDirectories(target4);
			System.out.println("4. myfiles4 ist Verzeichniss: " + Files.isDirectory(target4)); // true
			
			Files.copy(source, target4, StandardCopyOption.REPLACE_EXISTING); // target4 unlogisch fur diesen Aufruf
			System.out.println("Erzeugt: " + target4);
			System.out.println("4. myfiles4 ist Verzeichniss: " + Files.isDirectory(target4));  // false
		} catch (IOException e) {
			System.err.println("1. Fehler: " + e); 
		}
		
		/*
		 * 5 Wenn target ein NICHT leeres Verzeichnis ist:
		 */
		Path target5 = Paths.get("myfiles5"); 
		Path tmpFile5 = target5.resolve("tmp.txt"); 
		
		try {
			// ein nicht leeres Verzeicnis vorbereiten
			Files.createDirectories(target5);
			Files.copy(source, tmpFile5, StandardCopyOption.REPLACE_EXISTING);
			
			System.out.println("5. myfiles5 ist Verzeichniss: " + Files.isDirectory(target5)); // true
			
			// test copy
			Files.copy(source, target5, StandardCopyOption.REPLACE_EXISTING); 
		} catch (IOException e) {
			System.err.println("5. Fehler: " + e);  // DirectoryNotEmptyException: myfiles5
		}
		
		
		
		/*
		 * 6 Copy ohne REPLACE_EXISTING
		 */
		try {
			Files.copy(source, tmpFile5);			// FileAlreadyExistsException: myfiles5\tmp.txt
		} catch (Exception e) {
			System.err.println("6. Fehler: " + e); 
		}
		
		
		
		/*
		 * Auroumen
		 */
		try {
			Files.deleteIfExists(target);
			Files.deleteIfExists(targetDir);
			
			Files.deleteIfExists(target2);
			Files.deleteIfExists(target4);
			
			Files.deleteIfExists(tmpFile5);
			Files.deleteIfExists(target5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
