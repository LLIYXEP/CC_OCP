package aufgaben;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AufgabeFilesCounter {
	
	static class FilesCounter {
		
		private String path;

		public FilesCounter(String path) {
			super();
			this.path = path;
		}
		
		public int countDeep(String test) {
			Path dir = Paths.get(this.path);
			long result = 0;
			try {
				result = Files.walk(dir).filter(x -> x.toString().contains(test)).count();
			} catch (IOException e) {
			}
			return (int)result;
		}
		
		public int count(String test) {
			Path dir = Paths.get(this.path);
			long result = 0;
			try {
				result = Files.walk(dir, 1).filter(x -> x.toString().contains(test)).count();
			} catch (IOException e) {
			}
			return (int)result;
		}
	}
	
	
	public static void main(String[] args) {
		
		FilesCounter fc = new FilesCounter("C:\\local");
		
		int count = fc.countDeep("txt");
		System.out.println(count);
		
		int anzahl = fc.count("txt");
		System.out.println(anzahl);
		
	}
	
}
