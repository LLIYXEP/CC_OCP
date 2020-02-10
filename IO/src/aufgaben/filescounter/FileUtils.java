package aufgaben.filescounter;

import java.nio.file.Path;

public class FileUtils {
	
	
	/**
	 * true:
	 * 	
	 * 	file.txt
	 * 	file.abc.txt
	 * 	file...txt
	 * 
	 * false:
	 * 
	 *  file
	 * 	.txt
	 *  file.
	 * 
	 */
	public static boolean hasExtension(Path file, String extension) {
		String fileName = file.getFileName().toString();
		
		int posOfPoint = fileName.lastIndexOf('.');
		
		if(posOfPoint<=0 || posOfPoint==fileName.length()-1) {
			return false;
		}
		
		return fileName.substring(posOfPoint+1).equals(extension);
	}
	

}
