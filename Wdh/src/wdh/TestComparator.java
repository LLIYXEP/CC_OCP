package wdh;

import java.util.Comparator;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestComparator {
	
	static class MyCmpUtils {

		static <T, R extends Comparable<R>> Comparator<T> comparing(Function<T, R> keyExtractor) {
			
			Comparator<T> cmp = new Comparator<T>() {
				public int compare(T o1, T o2) {
					
					R key1 = keyExtractor.apply(o1);
					R key2 = keyExtractor.apply(o2);
					
					return key1.compareTo(key2);
				}
			};
			
			return cmp;
		}
		
	}


	public static void main(String[] args) {
		
		/*
		 
		 public String apply(Locale param) {
		 	return param.getDisplayLanguage();
		 }
		 
		 */
		
		Comparator<Locale> cmp1 = MyCmpUtils.comparing(Locale::getDisplayLanguage);
		
		Comparator<Locale> cmp2 = Comparator.comparing(Locale::getDisplayLanguage);
		
		Comparator<String> cmp3 = Comparator.naturalOrder();
		
		Comparator<String> cmp4 = Comparator.reverseOrder();
		
		Comparator<String> cmp5 = cmp4.reversed();
		
		Locale locA = new Locale("de", "DE");
		Locale locB = new Locale("de", "AT");
		
		Comparator<Locale> c1 = Comparator.comparing(Locale::getLanguage);
		System.out.println(c1.compare(locA, locB)); // 0
		
		Comparator<Locale> other = Comparator.comparing(Locale::getCountry);
		Comparator<Locale> c2 = c1.thenComparing(other);
		System.out.println(c2.compare(locA, locB)); // > 0
		
		Comparator<Locale> c3 = c1.thenComparing(Locale::getCountry);
		System.out.println(c3.compare(locA, locB)); // > 0
	}
	
}
