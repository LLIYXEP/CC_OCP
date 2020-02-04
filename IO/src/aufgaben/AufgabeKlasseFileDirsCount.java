package aufgaben;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabeKlasseFileDirsCount {

	public static void main(String[] args) {

		File pf = new File("C:\\Program Files\\Adobe");
		System.out.println(test(pf));
		File pf2 = new File("C:\\");
		System.out.println(test(pf2));
		
		
	} // end of main
	
	static int test(File file) {
		
		File[] subdirs = file.listFiles(File::isDirectory);
		int count = subdirs.length;
		
		
		
		if (subdirs != null) {
			
			for (File sDir : subdirs) {
				if (sDir == null) {
					System.out.println("kein zugriff" + sDir);
				}
			count += test(sDir);
			}
		}
		
		return count;
	}

}
