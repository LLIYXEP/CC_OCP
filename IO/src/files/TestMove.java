package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestMove {

	public static void main(String[] args) throws IOException {
		
		Path source = Files.createTempFile("blumen", ".pdf");
		
		Path target = Files.createTempDirectory("moin");
		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
		System.out.println(Files.isRegularFile(target)); // true
		
		
		target = Files.createTempDirectory("hello");
		Files.copy(source, target.resolve("hi"), StandardCopyOption.REPLACE_EXISTING);
		
		System.out.println(Files.isRegularFile(target.resolve("hi"))); // NoSuchFileException
		
//		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING); // Exc
	
		
	}
	
}
