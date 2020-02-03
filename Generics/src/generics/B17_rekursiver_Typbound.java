package generics;

class Person implements Comparable<Person> {
	String name;

	@Override
	public String toString() {
		return "Person " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Person o) {
		return name.compareTo(o.name);
	}
	
}

class Dozent extends Person {
	public Dozent(String name) {
		super(name);
	}
	@Override
	public String toString() {
		return "Dozent " + name;
	}
}

public class B17_rekursiver_Typbound {

	static Integer getMax1(Integer a, Integer b) {
		return a > b ? a : b;
	}
	
	static <T extends Number> T getMax2(T a, T b) {
		return a.doubleValue() > b.doubleValue() ? a : b;
	}
	
	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		Integer x1 = getMax1(12, 55);
		System.out.println("x1 = " + x1); // 55
		
		/*
		 * A2
		 */
		Integer max1 = getMax2(2, 3);
		System.out.println(max1); // 3
		
		Double max2 = getMax2(22.0, 3.5);
		System.out.println(max2); // 22.0
		
//		String x4 = getMax1("a", "bs"); // darf nicht kompilieren
		
		System.out.println("*****************");
		/*
		 * A3
		 */
		Integer x5 = getMax3(12, 55); // 55
		System.out.println(x5);
		Double x6 = getMax3(22.0, 3.5); // 22.0
		System.out.println(x6);
		String x7 = getMax3("a", "b"); // b
		System.out.println(x7);
		Person p1 = new Person("Tom");
		Person p2 = new Person("Jerry");
		Dozent d1 = new Dozent("Doz1");
		Dozent d2 = new Dozent("Piotr");
		Person p3 = getMax3(p1, p2);
		System.out.println(p3);
		Dozent p4 = getMax3(d1, d2);
		System.out.println(p4);
//		getMax3(12, "a");
	}
	
	static <T extends Comparable<? super T>> T getMax3(T a, T b) {
		return a.compareTo(b) < 0 ? a : b;
	}
	
}
