package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B22_Collectros_joining {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a", "b", "c", "d", "e");
		
		/*
		 * Collector<CharSequence, ?, String> joining()
		 */
		
		Collector<CharSequence, ?, String> c1 = Collectors.joining();
		
		String s1 = list.stream().collect(c1);
		
		System.out.println("s1: " + s1);
		
		/*
		 *  Collector<CharSequence, ?, String> joining(CharSequence delimiter)
		 */
		
		CharSequence delimiter = ", ";
		Collector<CharSequence, ?, String> c2 = Collectors.joining(delimiter);
		String s2 = list.stream().collect(c2);
		
		System.out.println("s2: " + s2);
		
		/*
		 * die 3. Variante (nicht in der Prufung)
		 * 
		 * Collectors.joining(delimiter, prefix, suffix)
		 */
		
		delimiter = ", ";
		CharSequence prefix = "+ ";
		CharSequence suffix = "- ";
		Collector<CharSequence, ?, String> c3 = Collectors.joining(delimiter, prefix, suffix);
		String s3 = list.stream().collect(c3);
		
		System.out.println("s3: " + s3);
	}
	
}
