package files;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B04_Path_Paths_und_FileSystem {

	public static void main(String[] args) {

		/*
		 * Klasse Paths:
		 * 
		 * static Path get(String first, String... more)
		 */
		
		Path p1 = Paths.get("C:\\", "Program Files", "7-Zip");
		System.out.println("p1: " + p1);
		
		/*
		 * Klasse FileSystem:
		 * 
		 * Path getPath(String first, String... more)
		 */
		Path p2 = FileSystems.getDefault().getPath("C:\\", "Program Files", "7-Zip");
		System.out.println("p2: " + p2);
		
		
		
		
	}

}
