package aufgaben;

import java.util.Collection;

public class AufgabeTextStatistics {

	public static void main(String[] args) {
		
		TextStatistics stat = TextStatistics.of("Heute ist Montag!");
		
		Collection<Character> chars = stat.getUniqueChars();
		
		System.out.println(chars);
		
	}
	
}
