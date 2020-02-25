package files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B07_Files_Walking {
	
	public static void main(String[] args) {
//		Path dir = Paths.get("C:\\Program Files\\7-Zip");
		Path dir = Paths.get(".");
		
		System.out.println("**************************");
		System.out.println("*** mit newDirectoryStream"); // nicht in der Prüfung 
		mit_newDirectoryStream(dir);
		
		System.out.println("**************************");
		System.out.println("*** mit walk v1");
//		mit_walk_v1(dir);
		
		System.out.println("**************************");
		System.out.println("*** mit walk v2");
//		mit_walk_v2(dir);
		
		System.out.println("**************************");
		System.out.println("*** mit walkFileTree"); // nicht in der Prüfung
		// s. im Package 'aufgaben.filescounter', Klasse DeepFilesCounterWalkFileTree
		
	} // end of main
	
	static void mit_walk_v2(Path dir) {
		
		/*
		 * Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options)
		 */
		try {
			int maxDepth = 1; // nur die direkten Elemente aus dir
			
			Files.walk(dir, maxDepth) // Stream<Path>
					.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void mit_walk_v1(Path dir) {
	
		/*
		 * Stream<Path> walk(Path start, FileVisitOption... options)
		 */
		try {
			Files.walk(dir) // Stream<Path>
					.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void mit_newDirectoryStream(Path dir) {
		
		/*
		 * newDirectoryStream ist nicht in der Prüfung 
		 */
		try ( DirectoryStream<Path> ds = Files.newDirectoryStream(dir) ) {
			for( Path item : ds ) {
				System.out.println(item);
				
				if(Files.isDirectory(item)) {
					mit_newDirectoryStream(item); // rekursion
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
}
