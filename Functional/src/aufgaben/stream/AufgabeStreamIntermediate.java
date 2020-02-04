package aufgaben.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class AufgabeStreamIntermediate {

	public static void main(String[] args) {
		
//		a1();
//		a2();
//		a3();
//		a4();
//		a5();
		a6();
		
	}
	
	
	static void a6() {
		
		List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
		List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
		List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");
		
		Function<List<String>, Stream<String>> mapper = list -> list.stream();
		
		
		Stream.of(mailsErsthelfer, mailsIT, mailsQM)
			.flatMap(mapper)
			.map(email -> email.substring(0, email.indexOf('@')))
			.distinct()
			.forEach(x -> System.out.println(x));
		
	}
	
	
	static void a5() {
		class Tier implements Comparable<Tier> {
			private String name;

			public Tier(String name) {
				this.name = name;
			}
			public String toString() {
				return "Tier " + name;
			}
			@Override
			public boolean equals(Object obj) {
				if (getClass() != obj.getClass())
					return false;
				Tier other = (Tier) obj;
				return name.equals(other.name);
			}
			@Override
			public int compareTo(Tier o) {
				return name.compareTo(o.name);
			}
			
			
		}
		
		Tier[] array = {
				new Tier("Rex"),
				new Tier("Tom"),
				new Tier("Jerry"),
				new Tier("Tom"),
				new Tier("Jerry"),
			};
		
		Stream.of(array)
			.sorted()
			.distinct()
			.forEach(System.out::println);
		
	}
	
	
	
	static void a4() {
		
		Integer random = new Random().nextInt((20 + 20) + 1) -20;
		System.out.println(random);
		
		Stream.generate( () -> new Random().nextInt(41) - 20)
			.limit(30)
			.filter( x -> (x > -10) || (x < -15))
			.map(Integer::doubleValue)
//			.map(Double::new)
			.map(Double::valueOf)
			.forEach(System.out::println);
		
			
		
	}
	
	static void a3() {
		class Tier {
			private String name;

			public Tier(String name) {
				this.name = name;
			}
			public String toString() {
				return "Tier " + name;
			}
		}
		
		List<String> list = Arrays.asList("Tom", "Jerry", "Rex");
		
//		//A
//		for(String name : list) {
//			Tier t = new Tier(name);
//			System.out.println(t);
//		}
//		//B
		
		list.stream()
			.map(x -> new Tier(x))
			.forEach(System.out::println);
	}
	
	
	
	static void a2() {
		
		Integer[] array = { 1, 4, 7, 3, -8 };
		
//		//A
//		for (Integer x : array) {
//			System.out.println( x%2==0 ? "gerade" : "ungerade" );
//		}
//		//B	
		
		Arrays.stream(array)
			.map(x -> x%2 == 0 ? "gerade" : "ungerade")
			.forEach(System.out::println);
	}
	
	
	
	static void a1() {
		
		List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);
		
		// A
		for(Integer x : list) {
			if(x==15 || x==19) {
				System.out.println("Treffer: " + x);
			}
		}
		// B
		
		list.stream()
			.filter(x -> x == 15 || x == 19)
			.forEach(x -> System.out.println("Treffer: " + x));
		
	}
	
}
