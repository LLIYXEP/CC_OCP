package files;

import java.io.File;

public class B02_Klasse_File {

	public static void main(String[] args) {
		
		/*
		 * 1. Klasse 'File' hilft Pfade beschreiben und damit zu arbeiten
		 * 2. Klasse 'File' hilft mit Dateien und Verzeichnissen zu arbeiten
		 * 
		 * 
		 * Achtung! Ein File-Objekt ist nur eine Pfadbeschreibung
		 */
		
		
		/*
		 * Konstruktoren
		 * 
		 * 	File(String)
		 * 	File(String, String)
		 * 	File(File, String)
		 */
		
		File p1 = new File("bin"); // <- File-Objekt ist nur eine Pfadbeschreibung
		simpleMethods(p1);
		
		File p2 = new File("C:\\tmp\\hallo.txt");
		simpleMethods(p2);

		File p3 = new File("parent", "child");
		simpleMethods(p3);
		
		File p4 = new File("a/b", "c/d");
		simpleMethods(p4);
		
		File parent = new File("parent");
		File p5 = new File(parent, "child");		
		simpleMethods(p5);
		
		/*
		 * Beispiele
		 */
		File p6 = new File(".project");
		simpleMethods(p6);
	}
	
	
	/*
	 * Methoden der Klasse 'File' sind nicht in der Prüfung
	 */
	static void simpleMethods(File path) {
		System.out.println("******* ");
		
		System.out.println("toString(): " + path);
		System.out.println("exists(): " + path.exists() );
		
		System.out.println("getAbsoluteFile(): " + path.getAbsoluteFile());
		
		System.out.println("isDirectory(): " + path.isDirectory());
		System.out.println("isFile(): " + path.isFile());
		
		System.out.println( "getParentFile(): " + path.getParentFile() );
		
//		path.mkdir();
//		path.createNewFile();
//		path.renameTo(dest);
//		path.delete();
		
	}

}
