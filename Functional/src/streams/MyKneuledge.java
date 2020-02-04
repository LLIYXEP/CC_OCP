package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MyKneuledge {

	public static void main(String[] args) throws IOException {
		
		// 4. Stream.of, sorted and findFirst
		// Array Stream
//		Stream.of("Ava", "Aneri", "Alberto")
//			.sorted()
//			.findFirst()
//			.ifPresent(s -> System.out.println(s));
			
		
		// 5. Stream from Array, sort, filter and print
		//Stream from Array
//		String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah"};
//		Arrays.stream(names) // Stream.of(names)
//			.filter(x -> x.startsWith("S"))
//			.sorted()
//			.forEach(System.out::println);
		
		
		
		// 6. average of squares of an int array
		//Average of squares of an int array
//		Arrays.stream(new int[] {2,4,6,8,10})
//			.map(x -> x * x)
//			.average()
//			.ifPresent(System.out::println);
		
		
		// 7. Stream from List, filter and print
//		Function<String, String> mapper = s -> s.toLowerCase();
//		
//		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
//		people
//			.stream()
//			.map(mapper)
//			.filter(x -> x.startsWith("a"))
//			.forEach(System.out::println);
		
		
		// 8. Stream rows from text file, sort, filter, and print
//		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
//		bands
//			.sorted()
//			.filter(x -> x.length() > 4)
//			.forEach(System.out::println);
//		bands.close();
		
		
		// 9. Stream rows from text file and save to List
//		List<String> bands2 = Files.lines(Paths.get("bands.txt"))
//				.filter(x -> x.contains("An"))
//				.collect(Collectors.toList());
//			bands2.forEach(x -> System.out.println(x));
		
		
		// 10. Stream rows from CSV file and count
//		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
//		int rowCount = (int)rows1
//			.map(x -> x.split(","))
//            .filter(x -> x.length == 3)
//			.count();
//		System.out.println(rowCount + " rows.");
//		rows1.close();
//			
//		
//		
//		long rowCount2 = Stream.of("a,s", "as,as", "asas,asa")
//			.map(x -> x.split(","))
//			.filter(x -> x.length == 2)
//			.count();
//		
//		System.out.println(rowCount2); //3 massiva s 2 elementami
			
//			.forEach(x -> {for (String string : x) {
//				System.out.println(string);
//			}});
		
		
		// 11. Stream rows from CSV file, parse data from rows
//				Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
//				rows2
//					.map(x -> x.split(","))
//		            .filter(x -> x.length == 3)
//					.filter(x -> Integer.parseInt(x[1]) > 15)
//					.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
//				rows2.close();
		
		// 12. Stream rows from CSV file, store fields in HashMap
//				Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
//				Map<String, Integer> map = new HashMap<>();
//				map = rows3
//					.map(x -> x.split(","))
//		            .filter(x -> x.length == 3)
//					.filter(x -> Integer.parseInt(x[1]) > 15)
//					.collect(Collectors.toMap(
//		                x -> x[0],
//		                x -> Integer.parseInt(x[1])));
//				rows3.close();
//				for (String key : map.keySet()) {
//					System.out.println(key + "  " + map.get(key));
//				}
		
		
		Stream<Integer> dropWhile = Stream.of(1,2,3,4,5,6)
				.filter(x -> x % 2 == 0)
				.dropWhile(x -> x < 4);
		
		dropWhile.forEach(System.out::println);
		
		
	}
	
}
