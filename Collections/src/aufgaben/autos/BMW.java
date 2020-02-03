package aufgaben.autos;

public class BMW extends Auto<BMW> {

	public BMW(String modell, int baujahr) {
		super(modell, baujahr);
	}
	
	public void setBaujahr(int baujahr) {
		super.baujahr = baujahr;
	}
}
