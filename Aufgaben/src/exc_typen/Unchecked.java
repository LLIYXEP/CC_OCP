package exc_typen;

public class Unchecked {

	static void m1() {
		throw new RuntimeException();
	}
	static void m2() {
		NullPointerException nullPointerException = new NullPointerException();
		ArithmeticException arithmeticException = new ArithmeticException();
	}
	static void m3() {
		throw new AssertionError();
	}
	static void m4() {
		throw new ClassCastException();
	}
	static void m5() {
		throw new ExceptionInInitializerError();
	}
	static void m6() {
		throw new StackOverflowError();
	}
	static void m7() {
		throw new NumberFormatException();
	}
	static void m8() {
		throw new IllegalArgumentException();
	}
	static void m9() {
		throw new ArrayIndexOutOfBoundsException();
	}
	static void m10() {
		throw new IllegalStateException();
	}

	public static void main(String[] args) {
		
		m1();
		
	}
}
