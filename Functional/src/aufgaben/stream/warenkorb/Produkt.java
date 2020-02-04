package aufgaben.stream.warenkorb;

public class Produkt {

	private String name;
	private int preis;
	
	public Produkt(String name, int preis) {
		super();
		this.name = name;
		this.preis = preis;
	}

	public String getName() {
		return name;
	}

	public int getPreis() {
		return preis;
	}

	@Override
	public String toString() {
		return name + " " + preis;
	}
	
}
