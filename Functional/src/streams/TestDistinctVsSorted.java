package streams;

import java.util.stream.Stream;

public class TestDistinctVsSorted {
	
	static class Foo implements Comparable<Foo> {
		int att;

		public Foo(int att) {
			super();
			this.att = att;
		}

		@Override
		public int compareTo(Foo o) {
			return att - o.att;
		}
		
		@Override
		public String toString() {
			return "Foo " + att;
		}

		

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Foo other = (Foo) obj;
			if (att != other.att)
				return false;
			return true;
		}
		
	}

	public static void main(String[] args) {
		
		Stream.of(new Foo(7), new Foo(3), new Foo(12), new Foo(7))
		.sorted()
		.distinct()
		.forEach(System.out::println);
		
	}
	
}
