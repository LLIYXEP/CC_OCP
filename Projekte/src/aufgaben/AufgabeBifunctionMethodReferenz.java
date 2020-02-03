package aufgaben;

import java.util.function.BiFunction;


class Auto {
	@Override
	public String toString() {
		return "Auto " + this.hashCode();
	}
	
	Besitzer build(Integer id) {
		return new Besitzer(this, id);
	}
}

class Besitzer {
	private Auto a;
	private Integer id;
	static Besitzer build(Auto a, Integer id) {
		return new Besitzer(a, id);
	}
	
	public Besitzer(Auto a, Integer id) {
		this.a = a;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Besitzer " + id + ", " + "Auto " + a;
	}
}
class BesitzerBuilder {
	Besitzer build(Auto a, Integer id) {
		return new Besitzer(a, id);
	}
}

public class AufgabeBifunctionMethodReferenz {

	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		BiFunction<Auto, Integer, Besitzer> f1 = new BiFunction<Auto, Integer, Besitzer>() {
			public Besitzer apply(Auto a, Integer id) {
//				return new Besitzer(a, id);
				return Besitzer.build(a, id);
			}
		};
		Besitzer b1 = f1.apply(new Auto(), 11);
		System.out.println(b1);
		
		/*
		 * A2
		 */
		BiFunction<Auto, Integer, Besitzer> f2 = (a, id) -> new Besitzer(a, id);
		Besitzer b2 = f1.apply(new Auto(), 12);
		System.out.println(b2);
		
		/*
		 * A3
		 */
		BiFunction<Auto, Integer, Besitzer> f3 = Besitzer::build;
		Besitzer b3 = f1.apply(new Auto(), 13);
		System.out.println(b3);
		
		/*
		 * A4
		 */
		BiFunction<Auto, Integer, Besitzer> f4 = Besitzer::new;
		Besitzer b4 = f1.apply(new Auto(), 14);
		System.out.println(b4);
		
		/*
		 * A5
		 */
		BiFunction<Auto, Integer, Besitzer> f5 = new BesitzerBuilder()::build;
		Besitzer b5 = f1.apply(new Auto(), 15);
		System.out.println(b5);
		
		/*
		 * A6
		 */
		BiFunction<Auto, Integer, Besitzer> f6 = Auto::build;
		Besitzer b6 = f1.apply(new Auto(), 16);
		System.out.println(b6);
	}
	
}
