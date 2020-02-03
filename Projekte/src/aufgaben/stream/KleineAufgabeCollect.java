package aufgaben.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KleineAufgabeCollect {
	
	static class Kreis implements Comparable<Kreis> {
		int radius;

		public Kreis(int radius) {
			super();
			this.radius = radius;
		}

		@Override
		public String toString() {
			return "Kreis R= " + radius;
		}

		@Override
		public int compareTo(Kreis o) {
			return this.radius - o.radius;
		}

		public int getRadius() {
			return radius;
		}

	
	}

	public static void main(String[] args) {
		
//		a1();
		a2();
		
	}
	
	static void a2() {
		
		System.out.println("***** A2 ******");
		
		Integer[] radien = {2, 4, 1, 5};
		
//		Comparator<Kreis> cmp = Comparator.comparing(Kreis::getRadius);
		
		Supplier<TreeSet<Kreis>> supplier = () -> new TreeSet<>(Comparator.comparingInt(Kreis::getRadius));
		
		TreeSet<Kreis> treeSet = Arrays.stream(radien)
				.map(Kreis::new)
				.collect(supplier, TreeSet::add, TreeSet::addAll);
		
		System.out.println(treeSet);
		
		
		
		
		treeSet = Arrays.stream(radien).map(Kreis::new).collect(Collectors.toCollection(TreeSet::new));
		
		System.out.println(treeSet);
		
		
	}
	
	static void a1() {
		
		System.out.println("***** A1.1 ******");
		
		StringBuilder result = Stream.of("a", "bb", "ccc").collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println("result: " + result); // abbccc
		
		System.out.println("***** A1.2 ******");
		Supplier<StringBuilder> supplier = () -> new StringBuilder();
		BiConsumer<StringBuilder, String> accumulator = (a,b) -> a.append(b);
		BiConsumer<StringBuilder, StringBuilder> combiner = (a,b) -> a.append(b);
		result = Stream.of("a", "bb", "ccc").collect(supplier, accumulator, combiner);
		System.out.println("result: " + result); // abbccc
		
		System.out.println("***** A1.3 ******");
		List<String> collect = Stream.of("a", "bb", "ccc").collect(Collectors.toList());
		System.out.println(collect); // [a, bb, ccc]
	}
	
}
