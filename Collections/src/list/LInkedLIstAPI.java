package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class LInkedLIstAPI {
	
	public static void main(String[] args) {
		first();
//		sort();
//		subList();
	}
	
	public static void subList() {
		System.out.println("**** subList (liefert backed list)****");
		
		List<Character> list = new ArrayList<Character>();
		
		for (char i = 'a'; i <= 'z'; i++) {
			list.add(i);
		}
		
		System.out.println(list);  // [a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
//		                          
		List<Character> listB = list.subList(2, 6); 
		
		System.out.println(listB); // [c, d, e, f]
		
		//Andrerung in der Basis- Classe
		list.add(4, 'E');
		
		//Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. (If fromIndex and toIndex are equal, the returned list isempty.) The returned list is backed by this list, so non-structuralchanges in the returned list are reflected in this list, and vice-versa.The returned list supports all of the optional list operations supportedby this list.
		
		System.out.println(list);
//		System.out.println(listB); // Exc
		
		listB = list.subList(2, 6); 
		System.out.println(listB); // [c, d, E, e]
		
		//Anderung in der Sublist
		listB.add(1, 'D');
		System.out.println(list); // [a, b, c, D, d, E, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]
		System.out.println(listB); // [c, D, d, E, e]
	}
	
	public static void sort() {
		System.out.println("sort");
		
		List<Integer> list = new Vector<>();
		
		list.add(12);
		list.add(-2);
		list.add(77);
		list.add(-100);
		
		Comparator<Integer> cmp = null;
		
		list.sort(cmp); // If the specified comparator is null then all elements in this list must implement the Comparable interface and the elements' natural ordering should be used. 
		
		System.out.println("1: " + list); // [12, -2, 77, -100]
		
		Comparator<Integer> cmp2 = Comparator.reverseOrder();
		
		list.sort(cmp2);
		
		System.out.println("2: " + list);
	}

	public static void first() {
		
		
		/*
		 * boolean add(E)
		 * void add(int, E)
		 */
		ArrayList<Integer> arrayList = new ArrayList<>();
//		arrayList.add(2, 3); // IOB exc
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		linkedList.add(12); // 12
		linkedList.add(0,13); // 13, 12
		linkedList.add(1, 14); // 13, 14, 12
		
//		linkedList.add(-1, 12); // IOB exc
		System.out.println("1: " + linkedList); // [13, 14, 12]

		
		/*
		 * E set(int, E)
		 */
		Integer set = linkedList.set(1, -7);
		System.out.println("2: " + linkedList); // [13, -7, 12]
		
		System.out.println("old value " + set); // 14
		
		/*
		 * remove(Object)
		 */
//		Integer remove = linkedList.remove(-7); // exc IOB
		linkedList.remove((Object)(-7));
		System.out.println("3: " + linkedList); // [13, 12]
		
		/*
		 * E remove(int)
		 */
		Integer removedElement = linkedList.remove(1);
		System.out.println("removed: " + removedElement); //12
		
//		linkedList.remove(2222); // IOB exc
		
		System.out.println("4: " + linkedList); // [13]
		
		/*
		 * E get(int)
		 */
		
//		linkedList.get(-2); /// IOB exc
		Integer value = linkedList.get(0);
		System.out.println("value: " + value); // 13
		
		
		ArrayList<String> listA = new ArrayList<String>();
		listA.add("di");
		listA.add(0,"mo");
		System.out.println("listA: " + listA); // mo, di
		
		LinkedList<String> listB = new LinkedList<>(listA);
		
		listB.add(0, "WE");
		
		/*
		 * boolean addAll(int, Collection)
		 */
		
		listB.addAll(3, listA);
		
		System.out.println("1: " + listB);
		
		/*
		 * boolean addAll(Collection)
		 */
		List<String> listC = Arrays.asList("mi","do");
		
		listB.addAll(listC);
		
		System.out.println("2: " + listB);

		
		
	}
	
	
}
