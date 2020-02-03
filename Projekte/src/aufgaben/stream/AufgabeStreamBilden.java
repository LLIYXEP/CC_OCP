package aufgaben.stream;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;


public class AufgabeStreamBilden {
	
	 static Integer nextInt() {
	        return new Random().nextInt();
	    }
	
	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
		a4();
//		a5();
		
	}
	
	public static void a5() {
	
		//A
				Collection<Path> coll = new ArrayList<>();
				coll.add(Paths.get("/a"));
				coll.add(Paths.get("/a/b"));
				coll.add(Paths.get("/a/b/c"));
				coll.add(Paths.get("/a/b/c/d"));
				for(Path p : coll) {
					System.out.println(p);
				}
				// B
		
	}
	
	
	
	public static void a4() {
		
		String[] a1 = { "a", "b" };
        String[] a2 = { "c", "d" };
        
        // A
//        String[][] a3 = { a1, a2 };
//        for (String[] arr : a3) {
//            for (String s : arr) {
//                System.out.println(s);
//            }
//        }
        // B
        
        Stream.concat(Arrays.stream(a1), Arrays.stream(a2));
		
        Stream.concat(Stream.of(a1), Stream.of(a2))
        		.forEach(System.out::println);
		
	}
	
	
		public static void a3() {
		
//		for (int i = 100; i >= 1; i--) {
//		    System.out.println( i );
//		}
		
		Integer seed = 100;
		UnaryOperator<Integer> f = x -> x-1;
		Stream.iterate(seed, x -> --x)
				.limit(10)
				.forEach(System.out::println);
		
	}
	
	
	
	public static void a2() {
		
//		for (int i = 1; i < 100; i++) {
//            System.out.println( nextInt() );
//        }
		
		Stream.generate(() -> AufgabeStreamBilden.nextInt())
							.limit(2)
							.forEach(System.out::println);
		
		Random r = new Random();
		Stream.generate(r::nextInt)
				.limit(2)
				.forEach(System.out::println);
				
		
	}
	

	public static void a1() {
		
		List<Integer> list1 = Arrays.asList( 1, 2, 3 );
		List<Integer> list2 = Arrays.asList( 55, 77 );
		
		// A
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for(List<Integer> e : list3) {
		    System.out.println("size = " + e.size() + ". elements = " + e);
		}
		// B
		
		
		Stream.of(list1, list2)
			.forEach(e -> 
				System.out.println("size = " + e.size() + ". elements = " + e));
	}
	
}
