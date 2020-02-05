package aufgaben.filescounter;

import java.nio.file.Path;

public class FileUtils {

	
	/*
	 * true: 
	 * 	file.txt
	 * 	file.abc.txt
	 *	file...txt
	 *
	 * false:
	 * 	.txt
	 */
	
	public static boolean hasExtension(Path file, String extension) {
		String fileName = file.getFileName().toString();
		
		int intPosition = fileName.lastIndexOf('.');
		
		if (intPosition <= 0 || intPosition == fileName.length() - 1) {
			return false;
		}
		
		return fileName.substring(intPosition+1).equals(extension);
	}
	
}
