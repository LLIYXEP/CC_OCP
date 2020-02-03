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

	public static List<String> loadEnglishWords() {

		try {
			InputStream is = ResourceLoader.class.getResourceAsStream("/res/english_words_lowercase.zip");
			
			ZipInputStream zis = new ZipInputStream(is);
			
			ZipEntry ze = zis.getNextEntry();
			
			if(ze.isDirectory()) {
				throw new IllegalStateException("bad input file");
			}
			
			
			try( BufferedReader in = new BufferedReader( new InputStreamReader(zis) ) ) {
			
				List<String> list = new ArrayList<>();
				String line;
				
				in.readLine(); // Quellenangaben in der 1. Zeile ignorieren
				while( (line = in.readLine()) != null ) {
					list.add(line);
				}
				
				return list;
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	public static List<String> loadPasswords() {
		// TODO Auto-generated method stub
		return null;
	}

}
