package aufgaben.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AugabeCollectorsPersonen {
	
	static class Person implements Comparable<Person> {
		private String name;
		private String beruf;
		
		public Person(String name, String beruf) {
			this.name = name;
			this.beruf = beruf;
		}
		// more methods here...
		public String toString() {
			return name;
		}
		
		public int compareTo(Person p) {
			return this.name.compareTo(p.name);
		}
		
	}

	public static void main(String[] args) {
		
		Person[] personen = {
				new Person("Tom", "Bauarbeiter(in)"),	
				new Person("Jerry", "Lehrer(in)"),	
				new Person("Peter", "Metzger(in)"),	
				new Person("Paul", "Bauarbeiter(in)"),	
				new Person("Mary", "Lehrer(in)"),	
			};
		
		TreeSet<Person> set1 = Arrays.stream(personen).collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		
		System.out.println(set1);
		
		Supplier<TreeSet<Person>> supplier = () -> new TreeSet();
		BiConsumer<TreeSet<Person>, Person> accumulator = (a,b) -> a.add(b);
		BiConsumer<TreeSet<Person>, TreeSet<Person>> combiner = (a,b) -> a.addAll(b);
		set1 = Arrays.stream(personen).collect(supplier, accumulator, combiner);
		System.out.println(set1);
		
		
		Supplier<TreeSet<Person>> collectionFactory = () -> new TreeSet();
		set1 = Arrays.stream(personen).collect(Collectors.toCollection(collectionFactory));
		System.out.println(set1);
		
		Collector<Person, ?, TreeSet<Person>> collector = Collectors.toCollection(TreeSet::new);
		set1 = Arrays.stream(personen).collect(collector);
		System.out.println(set1);
		
		
		Function<Person, String> keyMapper = x -> x.name;
		Function<Person, String> valueMapper = x -> x.beruf;
		
		Map<String, String> map1 = Arrays.stream(personen).collect(Collectors.toMap(keyMapper, valueMapper));
		System.out.println(map1);
		
		
		Map<Integer, String> map2 = Arrays.stream(personen)
				.distinct()
				.collect(Collectors.toMap(person -> person.name.length() + person.beruf.length(), valueMapper));
		System.out.println(map2);
		
		TreeSet<String> trSet = Arrays.stream(personen).collect(Collectors.mapping(x -> x.beruf, Collectors.toCollection(TreeSet::new)));
		System.out.println(trSet);
	
	}
	
}
