package aufgaben;

import java.util.function.*;

public class KleineAufgabeMethodenreferenzen {
	
	static class Values {
//		static String get(Values u, Integer t) {
//			return "" + t;
//		}
		
		String get(Integer t) {
			return "" + t;
		}
		
		Values(){};
		Values(Values v) {}
	}

	public static void main(String[] args) {
		//1
		Supplier<Values> s1 = Values::new;
		
		//2
		Consumer<Values> c1 = Values::new;
		
		//3
		Consumer<Values> c2 = new Consumer<Values>() {
			public void accept(Values t) {
				new Values(t);
			}
		};
		
		BiFunction<Values, Integer, String> f1 = Values::get;
		
		BiFunction<Values, Integer, String> f2 = new BiFunction<KleineAufgabeMethodenreferenzen.Values, Integer, String>() {
			public String apply(Values t, Integer u) {
//				return Values.get(t,u);
				return t.get(u);
			}
		};
		
	}
	
}
