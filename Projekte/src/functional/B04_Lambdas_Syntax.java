package functional;

interface IA {
	void m();
}
interface IB {
	void m(int x);
}

interface IC {
	int m();
}

public class B04_Lambdas_Syntax {

	public static void main(String[] args) {
		
		IA x1 = () -> {};
		IA x2 = () -> {
			System.out.println("a");
			System.out.println("b");
		};
		IA x3 = () -> 
			System.out.println("a"); // <- hier ist die Lambda zu Ende
			System.out.println("b"); // b
			
		;
			System.out.println("----------------------");
			x3.m(); // a
			
		
		IB x4 = (int y) -> {
			System.out.print(y + " + 3 = ");
			System.out.println(y + 3);
		};
		x4.m(2);
		
		// Kogda toliko 1 Parametr - skobki mojno ubrati
		
//		IB x5 = int y -> {}; // CF: 'int' muss auch weg
		IB x5 = y -> {};
		IB x6 = (y) -> {};
		IB x7 = (int y) -> {};
		
		// Kogda toliko odna operatiia v metode, mojno kovi4ki ne staviti
		IB x8 = y -> System.out.println(y);
		
		IC x9 = () -> { return 12;};
		
//		IC x9 = () -> return 12; // CF return muss auch weg
		
		IC x10 = () -> 12;
		
		kleineAufgabe();
	}
	
	interface GetBuilder{
		StringBuilder get(String s);
	}
	
	static void kleineAufgabe() {
		
		GetBuilder b1 = new GetBuilder() {
			@Override
			public StringBuilder get(String s) {
				return new StringBuilder(s);
			}
		};
		System.out.println(b1.get("Privet"));
		
		
		GetBuilder b2 = (String s) -> { return new StringBuilder(s); };
		System.out.println(b2.get("Privet2"));
		
		GetBuilder b3 = s -> new StringBuilder(s);
		System.out.println(b2.get("Privet3"));
	}
	
}
