package aufgaben.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

class Person {
	String name;
	String vornahme;
	public Person(String name, String vornahme) {
		super();
		this.name = name;
		this.vornahme = vornahme;
	}
	@Override
	public String toString() {
		return name + " " + vornahme;
	}
	public String getName() {
		return name;
	}
	public String getVornahme() {
		return vornahme;
	}
	
	static Person combinneMax(Person p1, Person p2) {
		String vorname = getMax(p1.name, p2.name);
		String nachname = getMax(p1.vornahme, p2.vornahme);
		
		return new Person(vorname, nachname);
	}
	
	static String getMax(String s1, String s2) {
		if (s1.compareTo(s2) > 0) {
			return s1;
		}
		return s2;
	}
}

public class AufgabeStreamSimple {

	public static void main(String[] args) {
		
//		a1();
		a2();
//		a3();
		
	}
	
	static void a3() {
		
		Person[] persons = {
			new Person("Tom", "Katze"),
			new Person("Jerry", "Maus"),
			new Person("Alexander", "Poe")
		};
		
		BiFunction<Person, Person, Person> accumulator = (a,b) -> {
			if (a.getName().compareTo(b.getName()) > 0) {
				return a;
			}
			return b;
		};
		
		BinaryOperator<Person> combiner = new BinaryOperator<Person>() {

			public Person apply(Person t, Person u) {
				if (t.getName().compareTo(u.getName()) > 0) {
					return t;
				}
				return u;
			}
		};
		
		Person reduce = Arrays.asList(persons).stream().reduce(new Person("Saniok", "Pako"), accumulator, combiner);
		System.out.println(reduce);
	}
	
	
	static void a2() {
		
		Person[] persons = {
			new Person("Tom", "Katze"),
			new Person("Jerry", "Maus"),
			new Person("Alexander", "Poe")
		};
		
		// V1
		
		BinaryOperator<Person> acc1 = Person::combinneMax;
		Person person = Arrays.stream(persons).reduce(acc1).get();
		System.out.println(person); // Tom Poe
		
		// V2
		
		Person identity = new Person("", "");
		Person person2 = Arrays.stream(persons).reduce(identity, acc1);
		System.out.println(person2); // Tom Poe
		
		//V3
		BiFunction<Person, Person, Person> accumulator2 = acc1;
		Person person3 = Arrays.stream(persons).parallel().reduce(identity, accumulator2, acc1);
		System.out.println(person3); // Tom Poe
		
		/*
		 * Bei 'immutable reduction' sollte sowas nicht programiert werden:
		 * 
		 */
		
		List<Person> list = Arrays.asList(
				new Person("Tom", "Katze"),
				new Person("Jerry", "Maus"),
				new Person("Alexander", "Poe")
				);
		
		BinaryOperator<Person> badAccumulator = (p1,p2) -> {
			p1.name = Person.getMax(p1.name, p2.name);
			p1.vornahme = Person.getMax(p1.vornahme, p2.vornahme);
			return p1;
		};
		identity = new Person("", "");
		Person reduce = list.stream().reduce(identity, badAccumulator);
		
		System.out.println(reduce); // Tom Poe
		System.out.println(reduce == identity); // true
		System.out.println(identity); // Tom Poe
		
		BinaryOperator<Person> accumulator = new BinaryOperator<Person>() {

			public Person apply(Person t, Person u) {
				if (t.getName().compareTo(u.getName()) > 0) {
					return t;
				}
				return u;
			}
		};
		
		Person result = Arrays.stream(persons).reduce(accumulator).get();
		System.out.println(result); // Tom Katze
		
		result = Arrays.stream(persons).reduce(new Person("Snejana", "Pai"), (a,b) -> {
			if (a.getVornahme().compareTo(b.getVornahme()) > 0) {
				return a;
			}
			return b;
		});
		
		System.out.println(result); // Alexander Poe
	}
	
	static void a1() {
		
		String[] items = { "aa", "bbb", "cccc", "ddddd" };
		String str = "";
		
		Integer result = Arrays.stream(items)
				.map(String::length)
				.reduce(0, ((a,b) -> a + b));
		System.out.println(result);
		
		BiFunction<Integer, String, Integer> acc = (count, str2) -> count + str2.length();
		
		result = Arrays.stream(items)
				.reduce(0, acc, (a,b) -> a + b);
		
		System.out.println(result);
		
		result = Arrays.stream(items)
				.reduce(0, (count, str2) -> count + str2.length(), (a,b) -> a + b);
		
		System.out.println(result);
		
	}
	
}
