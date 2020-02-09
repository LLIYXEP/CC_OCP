package files;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class B08_Files_walk_find_vs_lines_readAllLines {
	
	public static void main(String[] args) throws IOException {
		
//		walk_und_find();
		lines_und_readAllLines();
		
	}
	
	public static void lines_und_readAllLines() throws IOException {
		
		System.out.println("**** lines_und_readAllLines()");
		
		Path textFile = Paths.get("zeilen.txt");
		
		long count;
		
		/*
		 * Strean <String>
		 */
		
		count = Files.lines(textFile) // Strean <String>
			.peek(System.out::println)
			.count();
		
		System.out.println("1. zeilen: " + count); // 5
		
		/*
		 * List<String>
		 */
		
		count = Files.readAllLines(textFile) // List<String>
				.stream()
				.peek(System.out::println)
				.count();
	
		System.out.println("2. zeilen: " + count); // 5
		
		List<String> list = Files.readAllLines(textFile);
		System.out.println(list);
		
		list.stream()
//			.filter(x->!x.isEmpty())
			.peek(System.out::println)
			.count();
	}

	public static void walk_und_find() throws IOException {
		
		System.out.println("**** walk_und_find(");
		
//		Path start = Paths.get(".").toAbsolutePath().normalize();
		Path start = Paths.get("autos");
		
		
		System.out.println("start: " + start);
		
		long count;
		
		/*
		 * Stream<path> walk
		 */
		
		count = Files.walk(start)
			.filter(Files::isDirectory)
			.peek(System.out::println)
			.count();
		
		System.out.println("1 count: " + count);
			
		
		/*
		 * Stream<path> Stream<Path> find(Path start, int maxDepth,
                                    BiPredicate<Path, BasicFileAttributes> matcher,
                                    FileVisitOption... options)
		 */
		
		BiPredicate<Path, BasicFileAttributes> matcher = (path, atrrs) -> Files.isDirectory(path);
		
		int maxDepth = Integer.MAX_VALUE;
		
		count = Files.find(start, maxDepth, matcher)
					.peek(System.out::println)
					.count();
		
		System.out.println("2 count: " + count);
		
	} // end of main
	
	
	
}
