package files;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B04_Path_und_Paths {

	public static void main(String[] args) {
		
		/*
		 * Klasse Paths:
		 * 
		 * Path get(String first, String... more)
		 */
		
		Path p1 = Paths.get("C:\\", "ProgramFiles", "Adobe");
		System.out.println("p1: " + p1);
		
		Path p2 = FileSystems.getDefault().getPath("C:\\", "ProgramFiles", "Adobe");
		System.out.println("p2: " + p2);
		
		
		
	}
	
}
