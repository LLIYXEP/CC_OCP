package exc_typen;

public class Error {

	static void m1() {
		throw new Error();
	}

	public static void main(String[] args) {
		
		m1();
		
	}
	
}
