package aufgaben;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

interface KannBehandeltWerden {
	void setGesund(boolean b);
	boolean isGesund();
}

class Lebewesen implements KannBehandeltWerden {
	private boolean gesund;
	public void setGesund(boolean b) {
		gesund = b;
	}

	public boolean isGesund() {
		return gesund;
	}
	public String toString() {
		return this.getClass().getSimpleName();
	}
}

class Mensch extends Lebewesen {}

abstract class Tier extends Lebewesen {}

class Zebra extends Tier {}

class Affe extends Tier {}


class Arzt <T extends KannBehandeltWerden> extends Mensch {
	void behandeln(T t) {
		t.setGesund(true);
		System.out.println(t + " is " + (t.isGesund() ? "gesund" : "krank"));
	}
}

public class AufgabeGenericsZoo {
	List<Tier> tiere;
	
	static Collection<Tier> tiereToCollection(List<Tier> list) {
		Collection<Tier> collTiere = new ArrayList<Tier>();
		for (Tier tier : list) {
			collTiere.add(tier);
		}
		return collTiere;
	}

	public static void main(String[] args) {
		
		Affe a = new Affe();
		Zebra z = new Zebra();
		Mensch m = new Mensch();
		
		List<Tier> tiere = new ArrayList<>();
		tiere.add(new Zebra());
		tiere.add(new Affe());
		Collection<Tier> tiereColl = tiereToCollection(tiere);
		
		
		Arzt<Affe> a1 = new Arzt<>();
		a1.behandeln(a);
//		a1.behandeln(z);
		
		Arzt<? super Tier> a2 = new Arzt<>();
		a2.behandeln(a);
		a2.behandeln(z);
//		a2.behandeln(m);
		
		Arzt<Lebewesen> a3 = new Arzt<>();
		a3.behandeln(a);
		a3.behandeln(z);
		a3.behandeln(m);
	}
	
}
