package files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class B07_Files_Walking {
	
	public static void main(String[] args) {
		
//		Path dir = Paths.get("C:\\CCLauncher-Client-3");
		Path dir = Paths.get(".");
		
//		mit_NewDirectoryStream(dir);
//		mit_walk_v1(dir);
//		mit_walk_v2(dir);
		mit_walk_v3(dir); // mit walkFileTree
		
	} // end main
	
	static void mit_walk_v3(Path dir) {
		
		
		
	}
	
	
	
	/*
	 * Stream<Path> walk(Path start, int maxDepth,  FileVisitOption... options)
	 */
	static void mit_walk_v2(Path dir) {
		try {
			int maxDepth = 1; // nur die directe Elemente aus dir
			Files.walk(dir, maxDepth)
				.forEach(System.out::println);
		} catch (IOException e) {
		}
	}
	
	
	
	/*
	 * Stream<Path> walk(Path start, FileVisitOption... options)
	 */
	static void mit_walk_v1(Path dir) {
		try {
			Files.walk(dir)
				.forEach(System.out::println);
		} catch (IOException e) {
		}
	}
	

	/*
	 * Nicht Prufung relevant
	 */
	public static void mit_NewDirectoryStream(Path dir) {
		
		try {
			DirectoryStream<Path> ds = Files.newDirectoryStream(dir);
			for (Path item : ds) {
				System.out.println(item);
				if (Files.isDirectory(item)) {
					mit_NewDirectoryStream(item);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
