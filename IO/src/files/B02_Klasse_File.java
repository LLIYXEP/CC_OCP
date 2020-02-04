package files;

import java.io.File;

public class B02_Klasse_File {

	public static void main(String[] args) {
		
		/*
		 * 1. Klasse File hilft Pfade  beschreiben und arbeiten
		 * 2. Klasse File hilft mit Dateien und Verzeichnissen zu arbeiten
		 */

		
		/*
		 * Konstruktoren
		 * File(String)
		 * File(String, String)
		 * File(File, String)
		 */
		
		File p1 = new File("bin"); // <- File - Obkect ist nur eine Pfadbeschreibung
		simpleMethods(p1);
		
		File p2 = new File("tmp/hallo.txt");
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
		
		
	} // main
	
	static void simpleMethods(File path) {
		
		System.out.println("******* ");
		
		System.out.println("toString(): " + path);
		System.out.println("exists(): " + path.exists());
		System.out.println("getAbsolutePath(): " + path.getAbsolutePath());
		System.out.println("isDirectory(): " + path.isDirectory());
		System.out.println("isFile()(): " + path.isFile());
		System.out.println("getParentFile(): " + path.getParentFile());
		
		//....
	}
	
}
