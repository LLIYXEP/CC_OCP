package nested;

import nested.Auto.Motor;

// Auto sollte auch public sein
class Auto {
	
	private String hersteller = "VW";
	
	public Auto(String hersteller) {
		super();
		this.hersteller = hersteller;
	}

	public Auto() {
		hersteller = "VW";
		this.hersteller = "VW";
		Auto.this.hersteller = "VW";
	}
	
	class Motor {
		public void test() {
			System.out.println("******test******");
//			System.out.println("hersteller: " + this.hersteller);
//			System.out.println("hersteller: " + Motor.this.hersteller);
			System.out.println("hersteller: " + hersteller);
			System.out.println("hersteller: " + Auto.this.hersteller);
		}
	}
}

public class B03_Inner_not_static {

	public static void main(String[] args) {
		
		Auto.Motor m1;
//		m1 = new Auto.Motor();
		
		m1 = new Auto().new Motor();
		m1.test();
		
		new Auto("BMW");
		m1.test(); // VW
		
		Auto.Motor m2 = new Auto("BMW").new Motor();
		m2.test(); // BMW
		
		Auto a3 = new Auto("OPEL");
		Auto.Motor m3 = a3.new Motor();
		m3.test();
	}
	
}
