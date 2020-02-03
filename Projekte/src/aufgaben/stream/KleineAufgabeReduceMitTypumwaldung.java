package aufgaben.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Stream;

class Rechteckk {
	private int	breite;
	private int hoehe;
	public Rechteckk(int breite, int hoehe) {
		super();
		this.breite = breite;
		this.hoehe = hoehe;
	}
	@Override
	public String toString() {
		return "Rechteck " + breite + " X " + hoehe;
	}
	
	public int flaeche() {
		return this.breite * this.hoehe;
	}
	
}

public class KleineAufgabeReduceMitTypumwaldung {

	public static void main(String[] args) {
		
		Rechteckk[] list = {
				new Rechteckk(20, 30),
				new Rechteckk(30, 40),
				new Rechteckk(40, 50),
				new Rechteckk(2, 3)
		};
		
		int sum = Arrays.stream(list)
				.map((a) -> a.flaeche())
				.mapToInt(Integer::intValue)
				.sum();
		
		System.out.println(sum);
			
		
		
		
		int reduce = Arrays.stream(list)
			.map((a) -> a.flaeche())
			.reduce((a,b) -> a + b)
			.get();
		
		System.out.println(reduce);
	}
	
}
