package aufgaben;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Achtung! Es ist nur eine Lernaufgabe. damit wird nicht empfohlen in der Praxis die Zeitangaben als Strings in einem Treeset zu speichern.
 */

public class AufgabeSetAbfahrtzeiten {

	public static void main(String[] args) {
		
		/*
		 * 1.
		 */
		List<String> abfahrtZeiten = getAbfahrtzeiten(6, 24, 20);
		System.out.println(abfahrtZeiten); // [06, 07, 08, 09, 10, 11 ... 23]
		
		TreeSet<String> treeSet = new TreeSet<String>(abfahrtZeiten);
		System.out.println(treeSet.higher("12:03"));
		System.out.println(treeSet.floor("12:03"));
		System.out.println(treeSet.lower("12:03"));
		System.out.println(treeSet.ceiling("17:12"));
		System.out.println(treeSet.higher("17:12"));
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		System.out.println(treeSet.subSet("12:00", "13:00"));
		System.out.println(treeSet.subSet("11:52", false, "13:12", true));
		SortedSet<String> headSet = treeSet.headSet("12:12", true);
		System.out.println(headSet);
		
//		SortedSet<String> tailSet = treeSet.tailSet("17:12", false);
//		System.out.println(tailSet);
//		SortedSet<String> tailSet2 = treeSet.tailSet("17:12", true);
//		System.out.println(tailSet2);
		
		
	}
	
	static List<String> getAbfahrtzeiten(int from, int to, int min) {
		
		List<String> result = new ArrayList<String>();
		
		for (int i = from; i < to; i++) {
			for (int j = 12; j < 60; j+=min) {
				String zeit = String.format("%02d:%02d", i, j);
				result.add(zeit);
			}
		}
		
		
		return result;
	}
	
//	static List<String> getAbfahrtzeiten(LocalTime start, LocalTime ende, int min) {
//		
//	}
	

	
}
