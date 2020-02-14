package concurrency;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class B04_Coll_mit_Klasse_Collections {

	public static void main(String[] args) {
		
		/*
		 * synchronizedList
		 * synchronizedSet
		 * synchronizedMap
		 * 
		 * synchronizedCollection
		 * 
		 * die Methode liefern backed Collections zuruck
		 */
		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
		
		Set<Integer> set = Collections.synchronizedSet(new HashSet<>());
		
		Map<Integer, String> map = Collections.synchronizedMap(new TreeMap<>());
		
		Collection<Integer> synchronizedCollection = Collections.synchronizedCollection(new ArrayDeque<>());
		
	}
	
}
