package wdh;

/*
 * Innere (nested) : irgendwo innergalb einer Klasse
 */
public class AlleInnereKlassen {
	
	class InnerClass {}
	
	static class StatiInnerClass {}

	public static void main(String[] args) {
		class LocalInnerAsStatic {}
	}
	
	void m() {
		class LocalInnerAsNonStatic {}
	}
	
	static Object staticAtt = new Object() { // anonyme lokale Klasse als static inner
		
	};
	
	Object att = new Object() { // anonyme Klasse als nonstatic inner
		
	};
	
	/*
	 * Objekte bilden:
	 */
	static void test1() {
//		new InnerClass(); // CF
		
		new AlleInnereKlassen().new InnerClass();
	}
	
	void test2() {
		new InnerClass();
	}
	
	
}
