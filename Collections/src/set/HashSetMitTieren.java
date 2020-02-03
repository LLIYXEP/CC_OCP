package set;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class HashSetMitTieren {
	
	static class Tier {
		String name;
		int alter;
		
		public Tier(String name, int alter) {
			super();
			this.name = name;
			this.alter = alter;
		}
		@Override
		public String toString() {
			return name + " " + alter;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + alter;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tier other = (Tier) obj;
			if (alter != other.alter)
				return false;
			
			return Objects.equals(name, other.name);
		}

		
		
		
	}

	public static void main(String[] args) {
		
		List<Tier> list = Arrays.asList(
				new Tier("Tom", 3),
				new Tier("Jerry", 5),
				new Tier("Tom", 3),
				new Tier("Tom", 12)
				);
		
		System.out.println(list.size()); // 4

		Set<Tier> hashSet = new HashSet<>();
		hashSet.addAll(list);
		System.out.println(hashSet.size()); // 4
		
		
		
		Function<Tier, String> key = a -> a.name ;
//		Function<Tier, Integer> key2 = a -> a.alter ;
		Comparator<Tier> cmp = Comparator.comparing(key);
		
		
//		ToIntFunction<Tier> keyExtractor = t -> t.name.hashCode() + t.alter;
//		Comparator<Tier> cmp = Comparator.comparingInt(keyExtractor);
		
		ToIntFunction<Tier> keyExtractor2 = t -> t.alter; // Variant 2
		cmp = cmp.thenComparingInt(keyExtractor2);
		
//		cmp = Comparator.comparing((Tier t) -> t.name).thenComparing(t -> t.alter);
		
		Set<Tier> treeSet = new TreeSet<>(cmp);
		treeSet.addAll(list); 
//		treeSet.add(null);
		System.out.println(treeSet.size());
		System.out.println(treeSet);
		
	}

}
