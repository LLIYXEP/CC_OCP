package aufgaben.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KleineAufgabeCollectors_toXXX {
	
	static class Wochentag {
		String name;
		int nummer;
		
		public Wochentag(String name, int nummer) {
			super();
			this.name = name;
			this.nummer = nummer;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setNummer(int nummer) {
			this.nummer = nummer;
		}

		public String getName() {
			return name;
		}

		public int getNummer() {
			return nummer;
		}

		@Override
		public String toString() {
			return name + " " + nummer;
		}
		
	}

	public static void main(String[] args) {
		
		Integer[] zahlen = {1,2,3,4,5,6,7};
		String[] namen = {"mo", "di", "mi", "do", "fr", "sa", "so"};
		
		Function<Integer, Wochentag> mapper = new Function<Integer, Wochentag>() {
			public Wochentag apply(Integer t) {
				Wochentag wt = new Wochentag("", 1);
				for (int i = 0; i < namen.length; i++) {
					wt.setName(namen[t-1]);
					wt.setNummer(t);
				}
				return wt;
			}
		};
		
		
		
		LinkedList<Wochentag> array = Arrays.stream(zahlen)
			.map(mapper)
			.collect(Collectors.toCollection(LinkedList::new));
		
		System.out.println(array);
		
		
		LinkedList<Wochentag> list = Stream
				.iterate(0, i -> i +1)
				.limit(7)
				.map(i -> new Wochentag(namen[i], zahlen[i]))
				.collect(Collectors.toCollection(LinkedList::new));
		
		list.forEach(System.out::println);
	}
	
}
