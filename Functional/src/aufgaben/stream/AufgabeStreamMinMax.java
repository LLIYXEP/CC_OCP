package aufgaben.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class AufgabeStreamMinMax {

	public static void main(String[] args) {
		
//		a1();
//		a2();
		a3();
		
	}
	
	static void a3() {
		
		Locale[] locales = Locale.getAvailableLocales();
		
		 // A    
//	    List<Locale> filtered = new ArrayList<>();
//	    for (Locale locale : locales) {
//	        if(locale.getDisplayCountry().contains("t")) {
//	            filtered.add(locale);
//	        }
//	    }
//	    
//	    Comparator<Locale> cmp = (loc1, loc2) -> 
//	            loc1.getDisplayLanguage().compareTo(loc2.getDisplayLanguage());
//	    
//	    filtered.sort( cmp );
//	    
//	    if(filtered.size() > 0) {
//	        Locale min = filtered.get( 0 );
//	        System.out.println( min.getDisplayCountry() );
//	        System.out.println( min.getDisplayLanguage() );
//	    }
	    // B
	    
		Comparator<Locale> cmp	= (a,b) -> a.getDisplayLanguage().compareTo(b.getDisplayLanguage());
		
	   Stream.of(locales)
	    	.filter( x -> x.getDisplayCountry().contains("t"))
	    	.min(cmp)
//	    	.sorted(cmp)
//	    	.findFirst()
	    	.ifPresent(min -> {
	    		System.out.println( min.getDisplayCountry() );
		        System.out.println( min.getDisplayLanguage() );
	    	});
	    
//	    System.out.println(locale.getDisplayCountry() + " " + locale.getDisplayLanguage());
		
	}
	
	
	
	
	static void a2() {
		
		Locale[] locales = Locale.getAvailableLocales();
			
		long count = Stream.of(locales)
			.map( x -> x.getLanguage())
			.filter(x -> x.equals("de"))
			.count();
			
		System.out.println("Locales mit de: " + count);
		
	}
	
	
	
	static void a1() {
		Locale[] locales = Locale.getAvailableLocales();
		
//		for (Locale locale : locales) {
//			System.out.println(locale);
//		}
		
		Comparator<Locale> cmp = new Comparator<Locale>() {
			
			@Override
			public int compare(Locale l1, Locale l2) {
				return l1.getDisplayCountry().toString().length() - l2.getDisplayCountry().toString().length();
			}
		};

		
//		Optional<String> findFirst = Stream.of(locales)
//				.map(Locale::getDisplayCountry)
//				.sorted(Comparator.reverseOrder())
//				.findFirst();
//		
//		System.out.println(findFirst);

		/*
		 * A1
		 */
//		Comparator<Locale> cmp2 = (l1, l2) -> l1.getDisplayCountry().compareTo(l2.getDisplayCountry());
		Comparator<Locale> cmp2 = Comparator.comparing(Locale::getDisplayCountry);
		
		Optional<Locale> max = Arrays.stream(locales)
//			.max(Comparator.comparing(Locale::getDisplayCountry));
			.max(cmp2);
		
		System.out.println(max.get());
		System.out.println(max.get().getDisplayCountry());
	}
	
}
