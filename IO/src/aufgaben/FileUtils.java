package aufgaben;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileUtils {

	/**
	 * 
	 * Kopiert Datei source in Datei target. Wenn target existiert, wird sie überschrieben.
	 * 
	 * @param source
	 * @param target
	 * @throws FileNotFoundException wenn die Source-Datei nicht exisitiert.
	 * @throws IOException bei sonstigen IO-Problemen. 
	 */
	public static void copyTextFile(String source, String target) throws FileNotFoundException, IOException {
		
		try( Reader in = new FileReader(source);
				Writer out = new FileWriter(target) ) {
		
			char[] cbuf = new char[1048];
			
			int count;
			while( (count = in.read(cbuf)) != -1 ) {
				out.write(cbuf, 0, count);
			}
		}
	}
	
	/**
	 *  Kopiert Datei source in Datei target. 
	 *  Wenn target existiert und append ist false, wird sie überschrieben, bei appent gleich true wird sie erweitert.
	 * 
	 * @param source
	 * @param target
	 * @param append 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void copyTextFile(String source, String target, boolean append) throws FileNotFoundException, IOException {
		
		try( Reader in = new FileReader(source);
				Writer out = new FileWriter(target, append) ) {
			
			char[] cbuf = new char[1048];
			
			int count;
			while( (count = in.read(cbuf)) != -1 ) {
				out.write(cbuf, 0, count);
			}
		}
	}

	
}
