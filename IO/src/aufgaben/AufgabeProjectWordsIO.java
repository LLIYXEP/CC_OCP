package aufgaben;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import words.ResourceLoader;

public class AufgabeProjectWordsIO {
	
	public static void main(String[] args) {

		List<String> words = ResourceLoader.loadEnglishWords();
		
		System.out.println("words loaded: " + words.size());
		
		Function<String, Character> classifier = s -> s.charAt(0);
		
		Collector<String, ?, Map<Character, List<String>>> collector = Collectors.groupingBy(classifier);
		
		Map<Character, List<String>> groups = words.stream().collect(collector);

		System.out.println("groups created: " + groups.size());
		
		Path dir = Paths.get("words"); 
		
		try {
			if(!Files.exists(dir)) {
				Files.createDirectory(dir);
			}
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		BiConsumer<Character, List<String>> action = (ch, list) -> save( dir.resolve(ch + ".txt"), list );
		
		groups.forEach(action);

		System.out.println("Files created");
		
		
//		try(DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
//			
//			for (Path file : ds) {
//				Files.delete(file);
//			}
//			
//		} catch (IOException e) {
//			throw new UncheckedIOException(e);
//		}
//		
//		System.out.println("Files deleted");
	}

	
	private static void save(Path file, List<String> words) throws UncheckedIOException {
		System.out.println("Save file: " + file);
		
		try( BufferedWriter out = new BufferedWriter(new FileWriter(file.toFile())) ) {
			
			for( String w : words) {
				out.write(w); 
				out.newLine();
			}
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
