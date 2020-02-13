package threads.aufgaben;

public class TestMath {

	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		int x = 4;
		int y = 5;
		System.out.println(prod(x,y));
		
		/*
		 * A2
		 */
		
	}
	
	static int prod(int x, int y) {
		if( y == 1 ) return x;
	    else return x+prod( x, --y );
	}
	
}
