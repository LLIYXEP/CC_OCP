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
		test_deletIfExists();
		
	}
	
	public static void test_deletIfExists() {
		
		System.out.println("****** deletIfExists *******");
		
		try {
			
			Path dir = Paths.get("javakurs");
			Files.createDirectories(dir);
			
			Path file = dir.resolve("dozent");
			Files.createFile(file);
			
			System.out.println("file: " + file + "ist da: " + Files.exists(file));
			
			try {
				Files.deleteIfExists(dir);
			} catch (IOException e) {
				System.out.println(e);
			}

			System.out.println("Datei loschen: " + Files.deleteIfExists(file)); // true
			System.out.println("Datei loschen: " + Files.deleteIfExists(file)); // false
			
			System.out.println("Verzeichnis: " + dir);
			System.out.println("Verzeichnis loschen: " + Files.deleteIfExists(dir)); // true
			System.out.println("Verzeichnis loschen: " + Files.deleteIfExists(dir)); // false
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void test_delet() {
		
		System.out.println("****** dlete *****");
		
		Path file = Paths.get("nichtda");
		/*
		 * Exc - Element nicht existiert
		 */
		try {
			Files.delete(file);       // NoSuchFileException
			System.out.println("a");
		} catch (IOException e) {
			System.out.println("Fehler 1: " + e);
		}
		
		/*
		 * Datei loschen
		 */
		try {
			Files.createFile(Paths.get("tmp"));
			Files.delete(Paths.get("tmp"));      
			System.out.println("Datei geloscht: " + Paths.get("tmp")); // tmp
		} catch (IOException e) {
			System.out.println("Fehler 2: " + e);
		}
		
		/*
		 * Leeres Verzeichnis loschen
		 */
		try {
			Path tmp = Paths.get("y");
			Files.createDirectory(tmp);
			Files.delete(tmp);       
			System.out.println("Verzeichniss geloscht: " + tmp);   // y
			System.out.println("Existiert: " + !Files.exists(tmp));  // true
		} catch (IOException e) {
			System.out.println("Fehler 2: " + e);
		}
		
		/*
		 * Nicht leeres Verzeichnis loschen  - DirectoryNotEmptyException
		 */
		try {
			Path tmp = Paths.get("y");
			Files.createDirectory(tmp);
			Path tmpFile = tmp.resolve("x");
			Files.createFile(tmpFile);
			Files.delete(tmp);       
			System.out.println("Verzeichniss geloscht: " + tmp);   // y
			System.out.println("Existiert: " + !Files.exists(tmp));  // true
		} catch (IOException e) {
			System.out.println("Fehler 3: " + e);  // DirectoryNotEmptyException
		}
		
		
		/*
		 * Aufraume
		 */
		try {
			Files.delete(Paths.get("y/x"));
			Files.delete(Paths.get("y"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void test_createDirectories() {
		
		System.out.println("***********");
		
		Path dirName = Paths.get("a/b/c/d/e");
	
		/*
		 * 1 Erzeugt alle Verzeichnisse
		 */
		try {
			Path  result = Files.createDirectories(dirName);
			System.out.println(result);
		} catch (IOException e) {
			System.out.println("Fehler : " + e);
		}
		
		/*
		 * 
		 */
		try {
			
			Path parent = dirName;
			while (parent!=null) {
				System.out.println("Losche: " + parent);
				Files.delete(parent);
				parent = parent.getParent();
			}
			
		} catch (IOException e) {
			System.out.println("Fehler 2: " + e);
		}
		
		
	}
	
	public static void test_createDirectory() {
		
		System.out.println("***********");
		
		Path dir = Paths.get("zoo");
		
		/*
		 * 1
		 */
		
		try {
			Path result = Files.createDirectory(dir);
			System.out.println("Verzeichnis erstellt " + result);
		} catch (IOException e) {
			System.out.println("Fehler: " + e);
		}
		
		/*
		 * 2 Falls existiert - FileAlreadyExistsException:
		 */
		
		try {
			Path result = Files.createDirectory(dir);
			System.out.println("Verzeichnis erstellt " + result);
		} catch (FileAlreadyExistsException e) {
			System.out.println("Fehler 1: " + e); // FileAlreadyExistsException
		} catch (IOException e) {
			System.out.println("Fehler: " + e);
		}
		
		/*
		 * 3 Falls existiert , di genau so heisst wie das auszulegende Verzeichnis - FileAlreadyExistsException
		 */
		
		try {
			Files.createFile(Paths.get("hunde"));
			Path result = Files.createDirectory(Paths.get("hunde"));
			System.out.println("Verzeichnis erstellt " + result);
		} catch (FileAlreadyExistsException e) {
			System.out.println("Fehler 2: " + e); // FileAlreadyExistsException
		} catch (IOException e) {
			System.out.println("Fehler: " + e);
		}
		
		
		/*
		 * 4 Mussen alle Parent-Verzeichnisse bereits existieren
		 */
		try {
			Files.createDirectory(Paths.get("nichtda/a/b/c/subdir"));
		} catch (Exception e) {
			System.out.println("Fehler 2: " + e); // NoSuchFileException
		}
		
		
		
		
		/*
		 * Aufroumen
		 */
		try {
			Files.delete(dir);
			Files.delete(Paths.get("hunde"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

	public static void test_createFile() {
		
		Path file = Paths.get("tiere.txt");
		
		System.out.println("file: " + file);
		
		
		/*
		 * Path createFile(Path path, FileAttribute<?>... attrs)
		 */
		
		
		/*
		 * 1. Wenn es die Datei tiere.txt nicht gibt, wird sie erzeugt:
		 */
		try {
			Path result = Files.createFile(file);
			System.out.println("Datei erzeugt: " + result); // dasselbe wie file
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 2. Falls die Datei tiere.txt existiert , FileAlreadyExistsException:
		 */
		try {
			Files.createFile(file);
		}  catch (FileAlreadyExistsException e) {
			System.out.println("Fehler: " + e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * 3 Falls das Zielverzeichnis nicht existiert, wird die NoSuchFileException
		 */
		try {
			Files.createFile(Paths.get("nichtda/file.txt"));
		} catch (IOException e) {
			System.out.println("Fehler: " + e);  // NoSuchFileException
		}

		
		
		/*
		 * Nach den Tests aufroumen
		 */
		try {
			Files.delete(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
