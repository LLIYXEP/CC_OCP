package kap01;

public class Q6 {
	
	class X {
		
	}
	
	static class Y {
		
	}

	public static void main(String[] args) {
		
//		new X();
		Q6.X x = new Q6().new X();
		
		new Y();
		new Q6.Y();
		
	}
	
}
