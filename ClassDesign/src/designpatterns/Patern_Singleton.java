package designpatterns;
/*
 * Pattern Singleton: Klasse so gestalten, dass nur ein einziges Objekt geben kann
 */

/*
 * Version 1
 */
class MySongletonV1{
	
	private static MySongletonV1 instance = new MySongletonV1();
	
	public static MySongletonV1 getInstance() {
		return instance;
	}
	
	private MySongletonV1() {};
}

/*
 * Version 2
 */
enum MySingletonV2{
	INSTANCE;
}

/*
 * Version 3 (lasy, nicht threadsicher)
 */
class MySingletonV3{
	
	public static final int IRGENEINE_KONSTANTE = 3; // auch beaim zugriff auf die Konstante wird die Klasse geladen
	
	private static MySingletonV3 instance = new MySingletonV3();
	
	public static MySingletonV3 getInstance() {
		if (instance == null) {
			instance = new MySingletonV3();
		}
		return instance;
	}
	
	private MySingletonV3() {}
}

/*
 * weitere threadsichere lasy losungen kommt. Beim Thema 'Threads'
 */

public class Patern_Singleton {

	public static void main(String[] args) {
		
//		new MySongletonV1();
		
		MySongletonV1 s1 = MySongletonV1.getInstance();
		
		MySingletonV2 s2 = MySingletonV2.INSTANCE;
		
		MySingletonV3 s3 = MySingletonV3.getInstance();
		
	}
	
}
