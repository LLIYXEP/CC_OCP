package aufgaben;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class KleineAufgabeMapMerge {
	
	public static void main(String[] args) {
		
//		v1();
		v2();
		
	}
	
	public static void v2() {
		
		String text = "Heute is Freitag";
		
		Map<Character, Integer> countMap = new HashMap<>();
		
//		for (int i = 0; i < text.length(); i++) {
//			Character ch = text.charAt(i);
//			
//			Integer count = countMap.get(ch);
//			if (count == null) {
//				count = 0;
//			}
//			
//			countMap.put(ch, ++count);
//		}
//		System.out.println(countMap);
		
		
		
		
		
		for (Character ch : text.toCharArray()) {
			countMap.merge(ch, 1, (chParam, oldCount) -> oldCount+1);
		}
		
//		Map<Character, Integer> countMap = text.chars().mapToObj( x -> (char)x);
		
		System.out.println(countMap);
	}

	public static void v1() {
		
		String text = "Heute is Freitag";
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		char[] charArray = text.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			Character ch = 'a';
			Integer count = 0;
			if (text.charAt(i) == charArray[i]) {
				count++;
				ch = text.charAt(i);
			}
			BiFunction<Integer, Integer, Integer> remappingFunction = ( oldValueParam, valueparam ) -> oldValueParam + valueparam;
			countMap.merge(ch, count, remappingFunction);
		}
		
		System.out.println(countMap);
		
		
		/*
		 * Erzeugen Sie die Map, in der zu jedem Zeichen aus dem String text die Zahl zugeordnet wird,
		 * wie oft es das Zeichen in dem String gibt.
		 *  
		 */
		
	}
	
}
