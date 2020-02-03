package aufgaben;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class OS implements Comparable<OS>{
	private String name;
	private int version;
	
	public OS(String name, int version) {
		super();
		this.name = name;
		this.version = version;
	}
	@Override
	public String toString() {
		return name + " " + version;
	}
	public String getName() {
		return name;
	}
	public int getVersion() {
		return version;
	}
	
	@Override
	public int compareTo(OS o) {
		int erg = name.compareTo(o.name);
		if (erg == 0) {
			erg = version - o.version;
		}
		return erg;
	}
	
	
}

public class KleineAufgabeOS {

	public static void main(String[] args) {
		
		/*
		 * 1. Os- Objekt bilden. Der Konstruktor bekommt den Namen (String) und die Version (int)
		 */
		
		OS os1 = new OS("Mac", 9);
		System.out.println(os1); // Mac 9
		
		/*
		 *2. Bitte in einem Array folgende OS-speichern 
		 */
		
		OS[] osArray = {
				new OS("Linux", 3),
				new OS("Windows", 95),
				os1,
				new OS("Linux", 1),
		};
		
		//3
		
		print(osArray);
		
		//4
		
		Arrays.sort(osArray);
		print(osArray);
		
		Random random = new Random();
		
		//5
		Comparator<OS> cmp = (osX, osY) -> random.nextInt(3)-1;
		
		
		Arrays.sort(osArray , cmp);
		print(osArray);
		
		//6 Aufgsteigend soriteren und nach
		
		Arrays.sort(osArray);
		print(osArray);
		
		int pos = Arrays.binarySearch(osArray, new OS("Mac", 9));
//		int pos = Arrays.binarySearch(osArray, os1);
		System.out.println(pos);
		
		//7
		
		System.out.println("***Absteigend nach version****");
		Comparator<OS> cmp2 = (osX, osY) -> osY.getVersion() - osX.getVersion();
		Arrays.sort(osArray, cmp2);
		print(osArray);
		
		//8 Suchen nach 
		System.out.println("Falsch gesucht nach Linux");
		pos = Arrays.binarySearch(osArray, new OS("Linux", 3));
		System.out.println(pos);
		
		System.out.println("Richtig gesucht nach Linux");
		pos = Arrays.binarySearch(osArray, new OS("Linux", 3), cmp2);
		System.out.println(pos);
		
		
	} // end of main
	
	private static void print(OS[] arr) {
		System.out.println("**** OS Array *****");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("|%2d.|%-8s|%2d|%n" , i+1 , arr[i].getName() , arr[i].getVersion());
		}
	}
	
}
