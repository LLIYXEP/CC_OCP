package aufgaben.autos;

import java.util.Objects;

public abstract class Auto<T extends Auto<?>> implements Comparable<T> {

	protected int baujahr;
	protected String modell;

	public Auto(String modell, int baujahr) {
		this.baujahr = baujahr;
		this.modell = modell;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ". Modell: " + modell + ", Baujaht " + baujahr;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Auto<T> a2 = (Auto<T>)obj;
		
		return Objects.equals(modell, a2.modell) && baujahr ==a2.baujahr;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(modell) + baujahr;
	}
	
	@Override
	public int compareTo(T a2) {
		int erg = modell.compareTo(a2.modell);
		if (erg == 0) {
			erg = baujahr - a2.baujahr;
		}
		return erg;
	}
}
