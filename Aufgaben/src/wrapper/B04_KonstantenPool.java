package wrapper;

public class B04_KonstantenPool {

	public static void main(String[] args) {
		
		Integer i1 = 12;					//Aus dem Integer Pool
		Integer i2 = Integer.valueOf(12);	//Aus dem Integer Pool
		Integer i3 = 12;					//Aus dem Integer Pool
		System.out.println(i1 == i2);
	
		Integer i4 = new Integer("12");
		System.out.println(i1 == i4);
	}
	
}
