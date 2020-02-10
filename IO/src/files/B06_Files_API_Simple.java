package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B06_Files_API_Simple {

	public static void main(String[] args) {

		testExists();
		testIsSameFile();
		
		testInfoMethoden();

	} // end of main

	static void testInfoMethoden() {
		System.out.println("*** ");
		
		Path path = Paths.get("abc.txt");
		System.out.println("path: " + path);
		
		try {
			// int size = Files.size(path); // Compilerfehler.
			long size = Files.size(path);
			System.out.println("size in byte: " + size);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println( "isDirectory: " + Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS) );
	
		System.out.println( "isRegularFile: " + Files.isRegularFile(path, LinkOption.NOFOLLOW_LINKS) );

	}
	
	static void testIsSameFile() {
		
		System.out.println("*** isSameFile");
		
		Path p1 = Paths.get("a/b/c");
		Path p2 = Paths.get("a/b/../b/c");
		
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("equals: " + p1.equals(p2));
		
		boolean result;
		
		try {
			result = Files.isSameFile(p1, p2); // Exception: Element nicht gefunden
			
		} catch (IOException e) {
			System.err.println("Fehler: " + e); // java.nio.file.NoSuchFileException: a\b\c
		}
		

		p1 = Paths.get("src");
		p2 = Paths.get("../IO/src");
		
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.println("equals: " + p1.equals(p2));

		try {
			result = Files.isSameFile(p1, p2); 
			System.out.println("isSameFile: " + result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	static void testExists() {
		System.out.println("*** exists");
		
		Path p1 = Paths.get("nichtda");
		
		/*
		 * static boolean exists(Path path, LinkOption... options)
		 */
		LinkOption[] options = { LinkOption.NOFOLLOW_LINKS };
		boolean result = Files.exists(p1, options);
		
		result = Files.exists(p1, LinkOption.NOFOLLOW_LINKS);

		result = Files.exists(p1);
		System.out.println("p1: " + p1);
		System.out.println("exists: " + result);
		
		p1 = Paths.get("src");

		result = Files.exists(p1);
		System.out.println("p1: " + p1);
		System.out.println("exists: " + result);
	}

}
