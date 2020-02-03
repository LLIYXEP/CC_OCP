package wgh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Wdh01 {
	
	static class OS implements Comparable<OS> {
		private String name;
		private int version;
		@Override
		public String toString() {
			return name + " " + version;
		}
		public OS(String name, int version) {
			super();
			this.name = name;
			this.version = version;
		}
		@Override
		public int compareTo(OS o) {
			return 0; // Alles OS sind danach fur ein TreeSet gleich
		}
		@Override
		public int hashCode() {
//			return 7; // korrekt, sinloss
			return name.hashCode() + version * 31; // sinvoll
		}
		@Override
		public boolean equals(Object obj) {
			if (name == ((OS)obj).name && version == ((OS)obj).version) {
				return true;
			}
			return false;
		}
		
	}

	public static void main(String[] args) {
		
		List<OS> list = Arrays.asList(
				new OS("Mac", 2),
				new OS("Windows", 95),
				new OS("Mac", 2),
				new OS("Linux", 5)
				);
		
		System.out.println("1. list.size(): " + list.size()); // 4
		
		Deque<OS> deque = new ArrayDeque<Wdh01.OS>(list);
		
		System.out.println(deque);
		System.out.println("2. deque.size(): " + deque.size()); // 4
		
		Set<OS> hashSet = new HashSet<>(list);
		System.out.println("3. set.size(): " + hashSet.size()); // 3
		
		Set<OS> treeSet = new TreeSet<>(list);
		System.out.println("4. trset2.size(): " + treeSet.size()); // 1
		
//		Set<OS> lset = new LinkedHashSet<>(list);
//		System.out.println("5. trset2.size(): " + lset.size()); 

		Queue<OS> queue2 = new PriorityQueue<>(list);
		System.out.println(queue2);
		System.out.println(queue2.peek().name);
	}

	
}
