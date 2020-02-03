package aufgaben;

interface Tontraeger {}

class Schallplatte implements Tontraeger {}
class Tonband implements Tontraeger {}
class CD implements Tontraeger {}

class Abspielgeraet <T extends Tontraeger> {
	void abspielen(T t) {}

}


public class KleineAufgabeGen {

	public static void main(String[] args) {
		Schallplatte sp = new Schallplatte();
		Tonband tonband = new Tonband();
		CD cd = new CD();
		
		Abspielgeraet<Schallplatte> spspieler = new Abspielgeraet();
		spspieler.abspielen(sp);
//		spspieler.abspielen(tonband);
//		spspieler.abspielen(cd);
		
		Abspielgeraet<CD> cdSpeler = new Abspielgeraet();
//		cdSpeler.abspielen(sp);
//		cdSpeler.abspielen(tonband);
		cdSpeler.abspielen(cd);
		
//		Abspielgeraet<String> sinloss = new Abspielgeraet();
//		sinloss.abspielen("hallo welt");
		
		Abspielgeraet<Tontraeger> kombiSpieler = new Abspielgeraet();
		kombiSpieler.abspielen(sp);
		kombiSpieler.abspielen(tonband);
		kombiSpieler.abspielen(cd);
		
		
		Abspielgeraet<Schallplatte> ab1 = new Abspielgeraet<>();
		Abspielgeraet<CD> ab2 = new Abspielgeraet<>();
//		Abspielgeraet<String> ab3 = new Abspielgeraet<>();

		
	}
	
}
