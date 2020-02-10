package aufgaben;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileUtils {
	
	/**
	 * 
	 * Kopiert Datei source in Datei target. Wenn target existiert, wird sie uberschreiben
	 * 
	 * @param source
	 * @param target
	 * @throws IOException 
	 */
	public static void copyTextFile(String source, String target) throws IOException {
		
		try (Reader in = new FileReader(source);
			Writer out = new FileWriter(target)) {
		
			char[] cbuf = new char[1046];
		
			int count;
			while ((count = in.read(cbuf)) != -1) {
			
			out.write(cbuf, 0, count);
		}
		
		}
		
	}
	
public static void copyTextFile(String source, String target, boolean append) throws IOException {
		
		try (Reader in = new FileReader(source);
			Writer out = new FileWriter(target, append)) {
		
			char[] cbuf = new char[1046];
		
			int count;
			while ((count = in.read(cbuf)) != -1) {
			
			out.write(cbuf, 0, count);
		}
		
		}
		
	}
	
}
