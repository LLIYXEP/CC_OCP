package kap01;

interface AnimalsQ3 {
	int MOIN = 3; // public static final
	
	static void m() {} // public
}

public class Q03 {

	public static void main(String[] args) {
		
		System.out.println(AnimalsQ3.MOIN);
		AnimalsQ3.m();
		
		AnimalsQ3 a = null;
		
		System.out.println(a.MOIN);
//		System.out.println(a.m());
		
	}
	
}
