package functional;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

final class OS implements Comparable<OS> {
	public static final OS LAST_WINDOWS = new OS("Windows", 2010, 12);
	public static final OS LAST_LINUX = new OS("Linux", 3, 9);
	
	private String name;
	private int major, minor;
	@Override
	public String toString() {
		return name + major + ". " + minor;
	}
	public OS(String name, int major, int minor) {
		super();
		this.name = name;
		this.major = major;
		this.minor = minor;
	}
	public OS(String name, int major) {
		this(name, major, 0);
	}
	@Override
	public int compareTo(OS os2) {
		int result = name.compareTo(os2.name);
		if (result == 0) {
			result = major - os2.major;
		}
		
		if (result == 0) {
			result = minor - os2.minor;
		}
		return result;
	}
	public String getName() {
		return name;
	}
}

public class B10_Comparator {

	public static void main(String[] args) {
		
		/*
		 * int compare(T o1, To2)
		 */
		Comparator<Integer> c1 = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;}
		};
		
		System.out.println(c1.compare(5, 7)); // -2
		
		// Aus der Klasse Collections:
		Comparator<Integer> c2 = Collections.reverseOrder(); 
		Comparator<Integer> c3 = Collections.reverseOrder(c1); 
		
		System.out.println(c3.compare(5, 7)); // 2
		
		/*
		 * statische Methode
		 */
		
		/*
		 * <T extends Comparable<? super T>> Comparator<T> naturalOrder
		 */
		Comparator<OS> c4 = Comparator.naturalOrder();
		System.out.println(c4.compare(OS.LAST_LINUX, OS.LAST_WINDOWS));
		
		
		/*
		 * Comparator reverseOrder
		 */
		Comparator<Integer> c5 = Comparator.reverseOrder();
		
		
		/*
		 *  <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
		 */
		Function<OS, String> keyExtractor = os -> os.getName();
		Comparator<OS> c6 = Comparator.comparing(keyExtractor); // Vergleich nur bei name
		
		OS tmp = new OS("Linux", 2);
		System.out.println("*** test comparing(Function) ***");
		System.out.println("Linux vs Windows " + c6.compare(tmp, OS.LAST_WINDOWS)); // -11
		System.out.println("Linux vs Linux " + c6.compare(tmp, OS.LAST_LINUX)); // 9 (die OS sind gleich)
		
		/*
		 * <T, U> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator)
		 */
		System.out.println("*** test comparing(Function, Comparator) ***");
		Comparator<String> keyComparator = Comparator.reverseOrder();
		Comparator<OS> c7 = Comparator.comparing(keyExtractor, keyComparator);
		
		System.out.println("Linux vs Windows " + c7.compare(tmp, OS.LAST_WINDOWS)); // 11 positiv (erste OS ist grosser)
		System.out.println("Linux vs Linux " + c7.compare(tmp, OS.LAST_LINUX)); // 9 (die OS sind gleich)
		
		/*
		 * comparingXxx
		 */
		
		ToDoubleFunction<String> toDoubleFunction = s -> Double.parseDouble(s);
		Comparator<String> comparingDouble = Comparator.comparingDouble(toDoubleFunction);
		
		System.out.println("String mit compareTo: ");
		System.out.println("22.3".compareTo("5.7")); // negativ (1 String ist lexikographisch kleiner als 2. String)
		
		System.out.println("String mit dem Comparator: ");
		System.out.println(comparingDouble.compare("22.3", "5.7")); // positiv (1 String ist grosser als 2. String)
		
		
		
//		Comparator.comparingInt(toIntFunction);
//		Comparator.comparingLong(toLongFunction);
	}
	

	
}
