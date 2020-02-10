package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;

public class B08_Files_walk_find_vs_lines_readAllLines {
	
	public static void main(String[] args) throws IOException {
		walk_und_find();
		lines_und_readAllLines();
	}
	
	static void lines_und_readAllLines() throws IOException {
		
		System.out.println("*** lines und readAllLines");
		
		Path textFile = Paths.get("zeilen.txt");
		
		long count;
		/*
		 * Stream<String> lines(Path path) 
		 */
		count = Files.lines(textFile) //Stream<String>    !!!
						.peek(System.out::println)
						.count();
		
		System.out.println("1. Zeilen: " + count);
		
		/*
		 *  List<String> readAllLines(Path path)
		 */
		count = Files.readAllLines(textFile) // List<String>    !!!
						.stream() 
//						.filter(x -> !x.isEmpty())
						.peek(System.out::println) // ???
						.count();
		
		System.out.println("2. Zeilen: " + count);
	}

	static void walk_und_find() throws IOException {
		
		System.out.println("*** walk und find");
		
		Path start = Paths.get("autos"); // hat 4 Verzeichnisse (inklusive autos selbst)
		
		System.out.println("start: " + start);
		
		long count;
		
		/*
		 * Stream<Path> walk(Path start, FileVisitOption... options)
		 */
		count = Files.walk(start) // Stream<Path>    !!!
						.filter(Files::isDirectory)
						.peek(System.out::println)
						.count();
		
		System.out.println("1. count: " + count); 
	
		/*
		 * Stream<Path> find(Path start, int maxDepth, BiPredicate<Path, BasicFileAttributes>  matcher, FileVisitOption... options)
		 */
		BiPredicate<Path, BasicFileAttributes> matcher = (path, atts) -> Files.isDirectory(path);
		
		int maxDepth = Integer.MAX_VALUE;
		
		count = Files.find(start, maxDepth, matcher) // Stream<Path>    !!!
						.peek(System.out::println)
						.count();

		System.out.println("2. count: " + count);
		
	}

	
	
}
