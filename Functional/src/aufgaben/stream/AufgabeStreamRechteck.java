package aufgaben.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class Rechteck implements Comparable<Rechteck>{
	private Integer breite;
	private Integer hoehe;
	public Rechteck(Integer breite, Integer hoehe) {
		super();
		this.breite = breite;
		this.hoehe = hoehe;
	}
	@Override
	public String toString() {
		return "Rechteck " + breite + " X " + hoehe;
	}
	@Override
	public int compareTo(Rechteck o) {
		int result = this.breite - o.breite;
		if (result == 0) {
			result = this.hoehe - o.hoehe;
		}
		
		return result;
	}
	public Integer getBreite() {
		return breite;
	}
	public Integer getHoehe() {
		return hoehe;
	}
	

	
}

public class AufgabeStreamRechteck {
	
	public static void main(String[] args) {
		
		List<Rechteck> list = new ArrayList<Rechteck>();
		list.add(new Rechteck(120, 20));
		list.add(new Rechteck(20, 30));
		list.add(new Rechteck(50, 60));
		list.add(new Rechteck(30, 40));
		list.add(new Rechteck(40, 50));
		
		
		
		list.stream()
			.sorted((r1,r2) -> r1.getBreite() - r2.getBreite())
			.forEach(System.out::println);
		
		
	}

}
