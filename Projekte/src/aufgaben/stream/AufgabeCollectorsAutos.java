package aufgaben.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Auto {
	private String hersteller, modell;
	public Auto(String hersteller, String modell) {
		this.hersteller = hersteller;
		this.modell = modell;
	}
	public String getHersteller() { return hersteller; }
	public String getModell() { return modell; }
	
	public String toString() { return hersteller + "/" + modell; }
	
}

public class AufgabeCollectorsAutos {
	
	public static void main(String[] args) {
		
		List<Auto> autos = Arrays.asList(
				new Auto("VW", "Golf"),
				new Auto("VW", "Polo"),
				new Auto("Opel", "Corsa"),
				new Auto("Opel", "Astra")
			);
		
		a1(autos);
		a2(autos);
		a3(autos);
		a4(autos);
		a5(autos);
	
		
	}
	
	static void a5(List<Auto> autos) {
		
		System.out.println("****** A5");
	
		Predicate<Auto> predicate = a -> a.getModell().contains("o");
		Collector<Auto, ?, Map<Boolean, List<Auto>>> collector = Collectors.partitioningBy(predicate);
		Map<Boolean, List<Auto>> map1 = autos.stream().collect(collector);
		System.out.println(map1.get(true));
		System.out.println(map1.get(false));
		
	}
		
	static void a4(List<Auto> autos) {
		
		System.out.println("****** A4");
		
		
		Function<Auto, String> classifier = Auto::getHersteller;
		Collector<Auto, ?, List<Auto>> downstream = Collectors.toList();
		Supplier<Map<String, List<Auto>>> mapFactory = TreeMap::new;
		Collector<Auto, ?, Map<String, List<Auto>>> collector = Collectors.groupingBy(classifier, mapFactory, downstream);
		Map<String, List<Auto>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}

		
	}
	
	static void a3(List<Auto> autos) {
		
		System.out.println("****** A3");
		
		
		Function<Auto, String> mapper = Auto::getModell;
		Collector<String, ?, List<String>> simpleDownstream = Collectors.toList();
		Collector<Auto, ?, List<String>> downstream = Collectors.mapping(mapper, simpleDownstream);
		Function<Auto, String> classifier = Auto::getHersteller;
		Collector<Auto, ?, Map<String, List<String>>> collector = Collectors.groupingBy(classifier, downstream);
		Map<String, List<String>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}
		
	}
	
	static void a2(List<Auto> autos) {
		
		System.out.println("****** A2");
		
		Function<Auto, String> classifier = Auto::getHersteller;
		Collector<Auto, ?, Map<String, List<Auto>>> collector = Collectors.groupingBy(classifier);
		Map<String, List<Auto>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}
		
	}
	
	
	static void a1(List<Auto> autos) {
		
		System.out.println("****** A1");
		
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();
		Function<Auto, String> mapper = Auto::getHersteller;
		Collector<Auto, ?, Set<String>> collector = Collectors.mapping(mapper, downstream);
		Set<String> set1 = autos.stream().collect(collector);
		System.out.println(set1);
	}

}
