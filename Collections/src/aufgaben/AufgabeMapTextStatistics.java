package aufgaben;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TextMapStatistics {
	
	private String str;
	
	static TextMapStatistics of(String str) {
		return new TextMapStatistics(str);
	}
	
	Collection<Character> getUniqueChars() {
		Collection<Character> charCol = new ArrayList<Character>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			charCol.add(ch);
		}
		return charCol;
	}

	public TextMapStatistics(String str) {
		super();
		this.str = str;
	}
	
	Map<Character, Integer> getCharCounts() {
		Integer result = 1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (map.put(ch, i) == null) {
				result = 1;
				map.put(ch, result);
			} else {
				result += 1;
				map.put(ch, result);
			}
		}
	
		return map;
	}
}

public class AufgabeMapTextStatistics {

	public static void main(String[] args) {
		
		TextMapStatistics stat = TextMapStatistics.of("Heute ist Montag!");
		
		Collection<Character> chars = stat.getUniqueChars();
		
		System.out.println(chars);
		
		Map<Character, Integer> map = stat.getCharCounts();
		System.out.println(map);
	}
	
}
