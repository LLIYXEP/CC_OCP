package steckdosen.problem;

/*
 * Aufgabe:
 * 
 * Typensamlung soll entstehen, die folgende Bedinungen erfullt
 * 
 * - Es soll Steckdosen geben konnen
 * - Ess osll auch TV-Gerate geben konnen
 * - Tv-Gerate sollen an Steckdosen angeschlossen werden konnen
 * 
 * - Wichtig! Es gibt unteschiedlichen Standards fur die Steckdosen (und Tv-Gerate): englische und deutsche Steckdosen
 * 
 * 	englische TV-Gerate konnen nur an englische Steckdosen angeschlossen werden (und deutsche TV-Gerate nur an die deutsche Steckdosen)
 * 
 * Problem is Design: 
 * 
 * Steckdosen-Klassen sind (fast) identisch. weitere unterstutzte Steckdosen-Standarts bedeuten weitere (fast) identische Steckdosen-Klassen
 */

class TVUK {}

class TVDE {}

class SteckdoseDE {
	private TVDE tv;
	
	void anschliessen(TVDE tv) {
		this.tv = tv;
	}
	
	public TVDE getTv() {
		return tv;
	}
}

class SteckdoseUK {
	private TVUK tv;
	
	void anschliessen(TVUK tv) {
		this.tv = tv;
	}
	
	public TVUK getTv() {
		return tv;
	}
}

public class Problemstellung {

	public static void main(String[] args) {
		
		
		TVDE tvDE = new TVDE();
		TVUK tvUK = new TVUK();
		
		SteckdoseDE sdDE = new SteckdoseDE();
		
		
		sdDE.anschliessen(tvDE); // muss functionieren
		sdDE.anschliessen(tvUK); // darf nicht kompilieren!
		
		TVDE copy1 = sdDE.getTv();
		TVUK copy2 = sdDE.getTv(); // darf nicht kompilieren
		
		SteckdoseUK sdUK = new SteckdoseUK();
		
		sdUK.anschliessen(tvDE); // darf nicht kompilieren!
		sdUK.anschliessen(tvUK); // muss functionieren
		
	}
	
}
