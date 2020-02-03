package aufgaben.autos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class AufgabeCollectionsAutos {

	public static void main(String[] args) {
		
		System.out.println("*****A3******");
		
		VW vw1 = new VW("Golf", 1990);
		System.out.println(vw1); // VW. Modell: Golf, Baujaht 1990
		
		VW vw2 = new VW("Polo", 2012);
		VW vw3 = new VW("Golf", 2007);
		
		System.out.println("*****A4 , A5******");
		
		LinkedList<VW> listVW = new LinkedList<>();
		listVW.add(vw1);
		listVW.add(vw2);
		listVW.add(vw3);
		
		listVW.add(vw1);
		listVW.add(new VW("Golf", 1990));
		
		print(listVW); // 4
		
		HashSet<VW> hashSetVW = new HashSet<>(listVW); // HashSet(Collection<? extends E> c)
		
		print(hashSetVW); // 3
		
		TreeSet<VW> treesetVW = new TreeSet<>(listVW);
		
		print(treesetVW); // 3
		
		PriorityQueue<VW> queueVW = new PriorityQueue<>(listVW);
		
		print(queueVW);
		
		System.out.println("*********** PriorityQueue Leeren: ********");
		while (!queueVW.isEmpty()) {
			System.out.println(queueVW.remove());
		}
		
		/*
		 * A6
		 */
		System.out.println("*****A6******");
		BMW bmw1 = new BMW("Z4", 2000);
		BMW bmw2 = new BMW("Z6", 2015);
		
		ArrayList<BMW> listBMW	= new ArrayList<BMW>();
		listBMW.add(bmw1);
		listBMW.add(bmw2);
		listBMW.add(new BMW("Z4", 2000));
		print(listBMW);
		
		HashSet<BMW> hashSetBMW = new HashSet<BMW>(listBMW);
		print(hashSetBMW);
		
		TreeSet<BMW> treeSetBMW = new TreeSet<>(listBMW);
		print(treeSetBMW);
		
//		testComparable();
		
		ArrayDeque<BMW> dequeBMW = new ArrayDeque<>(listBMW);
		print(dequeBMW);
		
		/*
		 * A7
		 */
		System.out.println("*****A7******");
		
		System.out.println("hashSetBMW.contains(bmw1) " + hashSetBMW.contains(bmw1)); // true
	
		/*
		 * A8
		 */
		System.out.println("*****A8******");
		
		System.out.println("Vorher " + bmw1);
		bmw1.setBaujahr(2222);
		System.out.println("NACHER " + bmw1);
		print(hashSetBMW);
		System.out.println("hashSetBMW.contains(bmw1) " + hashSetBMW.contains(bmw1)); // false
	
		/*
		 * A9
		 */
		System.out.println("*****A9******");
		
		listVW.add(new VW("Polo", 2200));
		print(listVW);
		
		/*
		 * A10
		 */
		System.out.println("*****A10******");
//		Collections.sort(listVW);
		System.out.println(Collections.binarySearch(listVW, new VW("Polo", 2200))); // 5   die liaste soll sortierte werden
		System.out.println(Collections.binarySearch(listVW, new VW("Polo", 2012))); // -6  die liaste soll sortierte werden
	
		/*
		 * A11
		 */
		System.out.println("*****A11******");
		Collections.sort(listVW);
		print(listVW);
		System.out.println(Collections.binarySearch(listVW, new VW("Polo", 2200))); // 5  
		System.out.println(Collections.binarySearch(listVW, new VW("Polo", 2012))); // 4
	
		/*
		 * A12
		 */
		System.out.println("*****A12******");
		Collections.sort(listVW, Comparator.reverseOrder());
		Collections.sort(listVW, Collections.reverseOrder());
		print(listVW);
		
		/*
		 * A13
		 */
		System.out.println("*****A13******");
		System.out.println(Collections.binarySearch(listVW, new VW("Polo", 2200))); // -7 // falsch
		
		System.out.println(Collections.binarySearch(listVW, new VW("Polo", 2200), Comparator.reverseOrder())); // 0
	
		/*
		 * A14
		 */
		System.out.println("*****A14******");
		System.out.println(Collections.binarySearch(listVW, new VW("Polo", 3300), Comparator.reverseOrder())); // -1
	}
	
	static void contains() {
		
	}
	
	static void print(Collection<? extends Auto<?>> autos) {
		System.out.println("------------------ " + autos.getClass());
		
		int i = 0;
		for (Auto<?> a : autos) {
			System.out.printf("%d. %s %n", i++, a);
		}
		
		
		/*
		 * Auch ok
		 */
//		Iterator<VW> iterator = autos.iterator();
//		for (int i = 0; i < autos.size(); i++) {
//			System.out.printf("%d. %s %n", i, iterator.next());
//		}
	}
	
	static void testComparable() {
		VW vw = new VW("Golf", 2003);
		BMW bmw = new BMW("Z4", 2000);
		
//		vw.compareTo(bmw);
//		bmw.compareTo(vw);
		
		List<Auto<?>> listAutos = new ArrayList<>();
		listAutos.add(new BMW("Z4", 2000));
		listAutos.add(new VW("Golf", 2003));
		
//		Collections.sort(listAutos);
		
		ArrayList<BMW> listBMW	= new ArrayList<BMW>();
		listBMW.add(new BMW("Z4", 2000));
		listBMW.add(new BMW("Z5", 2000));
		Collections.sort(listBMW);
		
		LinkedList<VW> listVW = new LinkedList<>();
		listVW.add(new VW("Golf", 1990));
		listVW.add(new VW("Golf2", 1990));
		Collections.sort(listVW);
		
	}
	
}
