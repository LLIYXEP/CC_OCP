package nested;

class OuterA {
	
	private static int staticAtt = 1;
	private  int att = 1;
	private static int getMax() {
		return 3;
	}
	
	static class InnerA {
		private  int getMax() {
			return 4;
		}
		public void test() {
			System.out.println("staticAtt " + OuterA.staticAtt);
			System.out.println("staticAtt " + staticAtt);
//			System.out.println("staticAtt " + att); // CF
			System.out.println("staticAtt " + getMax()); // 4
			System.out.println("staticAtt " + OuterA.getMax()); // 3
		}
	}
}

public class B02_StaticInner {

	public static void main(String[] args) {
		
//		InnerA i1; 	// CF
		nested.OuterA.InnerA i1;
		OuterA.InnerA i2;
		
//		new InnerA();	// CF
		
		new nested.OuterA.InnerA();
		new OuterA.InnerA();
		
		OuterA.InnerA i3 = new OuterA.InnerA();
		i3.test();
	}
	
}
