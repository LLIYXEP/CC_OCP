package aufgaben;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TextStatistics {

	public static TextStatistics of(String text) {
		return new TextStatistics(text);
	}
	
	private final String text;

	protected TextStatistics(String text) {
		super();
		this.text = text;
	}

	public Collection<Character> getUniqueChars() {
		
//		Collection<Character> coll = new HashSet<>();
//		Collection<Character> coll = new TreeSet<>();
		Collection<Character> coll = new LinkedHashSet<>();
		
//		char[] charArray = text.toCharArray();
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			coll.add(ch);
		}
		
		return coll;
	}

}
