package aufgaben;

interface Tontraeger {}

class Schallplatte implements Tontraeger {}
class Tonband implements Tontraeger {}
class CD implements Tontraeger {}

class Abspielgeraet<T extends Tontraeger> {
	void abspielen(T t) {}
}

public class AufgabeGenericsMusicInstrumente {

	public static void main(String[] args) {
		
		Schallplatte s = new Schallplatte();
		Tonband t = new Tonband();
		CD cd = new CD();
		
		
		Abspielgeraet<Schallplatte> a1 = new Abspielgeraet<>();
		a1.abspielen(s);
//		a1.abspielen(cd);
		
	}
	
}
