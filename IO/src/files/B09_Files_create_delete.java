package files;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B09_Files_create_delete {

	public static void main(String[] args) {
//		test_createFile();
//		test_createDirectory();
//		test_createDirectories();
		
//		test_delete();
		test_deleteIfExists();
	}
	
	/*
	 * Exam (?)
	 */
	static void test_deleteIfExists() {
		System.out.println("*** deleteIfExists");
		
		try {
			Path dir = Paths.get("javakurs");
			Files.createDirectories(dir);
			
			Path file = dir.resolve("dozent");
			Files.createFile(file);

			try {
				Files.deleteIfExists(dir); // DirectoryNotEmptyException
			} catch (IOException e) {
				System.err.println("Fehler: " + e); 
			}
			
			System.out.println("file " + file + " ist da: " + Files.exists(file));
			System.out.println( "Datei gelöscht? " + Files.deleteIfExists(file) ); // true
			System.out.println( "Datei gelöscht? " + Files.deleteIfExists(file) ); // false
			
			System.out.println("Verzeichnis " + dir);
			System.out.println( "Verzeichnis gelöscht? " + Files.deleteIfExists(dir) ); // true
			System.out.println( "Verzeichnis gelöscht? " + Files.deleteIfExists(dir) ); // false
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Exam (?)
	 */
	static void test_delete() {
		/*
		 *  void delete(Path path)
		 */
		System.out.println("*** delete");
		
		Path file = Paths.get("nichtda");
		
		/*
		 * 1. Exception, falls das Element (hier 'nichtda') nicht exisitiert
		 */
		try {
			Files.delete(file); // NoSuchFileException: nichtda
			
		} catch (IOException e) {
			System.err.println("1. Fehler: " + e); 
		}
		
		/*
		 * 2. Datei löschen
		 */
		try {
			Path tmpFile = Paths.get("tmp");
			Files.createFile(tmpFile);
			Files.delete(tmpFile);
			System.out.println("2. Datei gelöscht: " + tmpFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 3. Leeres Verzeichnis löschen
		 */
		try {
			Path tmpDir = Paths.get("y");
			Files.createDirectory(tmpDir);
			Files.delete(tmpDir);
			System.out.println("3. Verzeichnis gelöscht: " + tmpDir);
			System.out.println("3. Wirklich? => " + !Files.exists(tmpDir));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 4. Nichtleeres Verzeichnis löschen: 
		 */
		try {
			Path tmpDir = Paths.get("y");
			Files.createDirectory(tmpDir);
			Path tmpFile = tmpDir.resolve("x");
			Files.createFile(tmpFile);
			
			Files.delete(tmpDir);  // java.nio.file.DirectoryNotEmptyException: y
			
		} catch (IOException e) {
			System.err.println("4. Fehler: " + e); 
		}
		
	
		/*
		 * Aufräumen
		 */
		try {
			Files.delete(Paths.get("y/x"));
			Files.delete(Paths.get("y"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Exam (einfach, es geht die Verzeichnisse damit erzeugen))
	 */
	static void test_createDirectories() {
		System.out.println("*** createDirectories");
		
		Path dir = Paths.get( "a/b/c/d/e" );
		
		try {
			
			Path result = Files.createDirectories(dir);
			System.out.println("Erzeugt: " + result);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Aufräumen 
		 */
		try {
			Path parent = dir;
			
			while(parent!=null) {
				System.out.println("Lösche: " + parent);
				Files.delete(parent);
				parent = parent.getParent();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Exam (?)
	 */
	static void test_createDirectory() {
		/*
		 * Path createDirectory(Path dir, FileAttribute<?>... attrs)
		 */
		System.out.println("*** createDirectory");
		
		Path dir = Paths.get("zoo"); 

		/*
		 * 1. Wenn es das Verzeichnis zoo nicht gibt, wird es erzeugt
		 */
		try {
			Path result = Files.createDirectory(dir);
			System.out.println("Verzeichnis erstellt: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * 2. Falls das Verzeichnis bereits exisitiert, wird die FileAlreadyExistsException geworfen
		 */
		try {
			Files.createDirectory(dir);
			
		} catch (FileAlreadyExistsException e) {
			System.err.println("2. Fehler: " + e);  // Verzeichnis bereits exisitiert
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		/*
		 * 3. Falls eine Datei bereits exisitiert, die genauso heißt wie das anzulegende Verzeichnis,
		 *    wird die FileAlreadyExistsException geworfen
		 */
		try {
			Files.createFile(Paths.get("hunde")); // neue Datei zum Testen
			Files.createDirectory(Paths.get("hunde")); // FileAlreadyExistsException
			
		} catch (FileAlreadyExistsException e) {
			System.err.println("3. Fehler: " + e);  // Gleichnamige Datei bereits exisitiert
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		/*
		 * 4. Damit das Verzeichnis subdir erstellt werden kann, müssen alle Parent-Verzeichnisse
		 *    bereits exisitieren. In diesem Fall lieber die Methode createDirectories verwenden.
		 */
		try {
			
			Files.createDirectory( Paths.get("nichtda/a/b/c/subdir") ); // NoSuchFileException
			
		} catch (IOException e) {
			System.err.println("4. Fehler: " + e);  // NoSuchFileException
			
		}
		
		
		/*
		 * Aufräumen
		 */
		try {
			
			Files.delete(dir);
			Files.delete(Paths.get("hunde"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Exam (!)
	 */
	static void test_createFile() {
		/*
		 * Path createFile(Path path, FileAttribute<?>... attrs)
		 */
		System.out.println("*** createFile");

		Path file = Paths.get("tiere.txt");
		System.out.println("file: " + file);
		
		
		/*
		 * 1. Wenn es die Datei tiere.txt nicht gibt, wird sie erzeugt: 
		 */
		try {
			Path result = Files.createFile(file);
			System.out.println("1. Datei erzeugt: " + result); // dasselbe wie file
			
		}  catch (IOException e) {
			e.printStackTrace();
		}

		
		/*
		 * 2. Falls die Datei bereits exisitiert, wird die FileAlreadyExistsException geworfen
		 */
		try {
			Files.createFile(file);
			
		} catch (FileAlreadyExistsException e) {
			System.err.println("2. Fehler: " + e);  // Datei bereits exisitiert
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

		/*
		 * 3. Falls das Zielverzeichnis nicht existiert, wird die NoSuchFileException geworfen
		 */
		try {
			Files.createFile( Paths.get("nichtda/file.txt") );
			
		} catch (IOException e) {
			System.err.println("3. Fehler: " + e);  // java.nio.file.NoSuchFileException: nichtda\file.txt
			
		}
		
		
		/*
		 * Nach den Tests aufräumen
		 */
		try {
			Files.delete(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
