package words;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ResourceLoader {

	private static List<String> loadFromZipResource(String zipResourceName) {
		try {
			//Eine Ressource-Datein aus einem Package zum Lesen öffnen
			InputStream is = ResourceLoader.class.getResourceAsStream(zipResourceName);
			
			// Eine Zip-Ressorce Lesen
			ZipInputStream zis = new ZipInputStream(is);

			try {
				ZipEntry ze = zis.getNextEntry();
				
				if(ze.isDirectory()) {
					throw new IllegalStateException("Falsche Datei! Die zip-Datei muss eine einzige ASCII-Textdatei beinhalten");
				}
				
			} catch (Exception e) {
				zis.close();
				throw e;
			}
			
			// Eine Text-Ressource lesen:
			try( BufferedReader in = new BufferedReader( new InputStreamReader(zis) ) ) {
			
				List<String> list = new ArrayList<>();
				
				String sourceLine = in.readLine(); // Quellenangaben in der 1. Zeile ignorieren
				if(!sourceLine.startsWith("Quelle:")) {
					throw new IllegalStateException("Falsche Datei! Die Textdatei muss in der ersten Zeile die Quellenangabe haben");
				}
				
				String line;
				while( (line = in.readLine()) != null ) {
					list.add(line);
				}
				
				return list;
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static List<String> loadEnglishWords() {
		return loadFromZipResource("/res/english_words_lowercase.zip");
	}

	public static List<String> loadPasswords() {
		return loadFromZipResource("/res/10k_most_common_passwords.zip");
	}

}

