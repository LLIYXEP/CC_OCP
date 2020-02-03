package streams;

import java.util.stream.Stream;

public class B07_interdemdiate_distinct {
	
	static class Blume implements Comparable<Blume>  {
		int preis;

		 public Blume(int preis) {
			super();
			this.preis = preis;
		}
		@Override
		public String toString() {
			return "Blume " + preis;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (getClass() != obj.getClass())
				return false;
			Blume other = (Blume) obj;
			if (preis != other.preis)
				return false;
			return true;
		}
		@Override
		public int compareTo(Blume o) {
			return preis - o.preis;
		}
		
		@Override
		public int hashCode() { // Achtung! Auch hashCode muss uberschrieben, damit distinct korrekt geht
			return preis;
		}
		
	}

	public static void main(String[] args) {
		
		System.out.println("********* distinct() mit Integer *********");
		
		Stream.of(1, 12, 3, 12, -7, 1)
			.distinct()
			.forEach(System.out::println);
		
		
		System.out.println("********* distinct() mit Blumen *********");
	
		Stream.of(1, 12, 3, 12, -7, 1)
			.map( Blume::new )
			.sorted()
			.distinct()
			.forEach(System.out::println);
		
		
	}
	
}
