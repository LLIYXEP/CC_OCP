package exc_typen;

public class Checked {

	static void m1() {
		throw new Exception();
	}
	static void m2() {
		throw new Throwable();
	}
	static void m3() {
		throw new InterruptedException();
	}

	public static void main(String[] args) {
		
		m1();
		
	}
	
}
