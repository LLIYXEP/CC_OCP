package aufgaben;

import java.util.Arrays;

public class Gebauede {

	/*
	 * Stockwerk
	 */
	public class Stockwerk {
		private int nummer;
		private Raum[] raeume;
		
		/*
		 * Raum
		 */
		public class Raum {
			private int nummer;
			
			public Raum(int nummer) {
				super();
				this.nummer = nummer;
			}

			public String toString() {
				return String.format("Raum %d.%d / %s %s", Stockwerk.this.nummer, this.nummer, strasse, Gebauede.this.nummer);
			}
			
		} // end Raum
		
		public Stockwerk(int nummer, int anzahlRaeume) {
			super();
			this.nummer = nummer;
			raeume = new Raum[anzahlRaeume];
			for (int i = 0; i < raeume.length; i++) {
				raeume[i] = new Raum(i);
//				raeume[i] = this.new Raum(i); // implizit wird Raum mit this. erzeugt
			}
		}

		public int getAnzahlRaeume() {
			return raeume.length;
		}

		@Override
		public String toString() {
			return String.format("Stockwerk %d. Anzahl Raeume: %d", nummer, getAnzahlRaeume());
		}
		
	} // end Stockwerk
	//Gebauede.this.nummer
	
	
	private Stockwerk[] stockwerke;
	private String strasse;
	private String nummer;
	

	public Gebauede(String strasse, String nummer, int anzahlStockwerke, int anzahlRaumeProStockwerk) {
		super();
		this.strasse = strasse;
		this.nummer = nummer;
		if (anzahlStockwerke < 1) {
			throw new IllegalArgumentException("Anzahl der Stockwerke muss mindestens 1 sein");
		}
		stockwerke = new Stockwerk[anzahlStockwerke];
		for (int i = 0; i < stockwerke.length; i++) {
			stockwerke[i] = new Stockwerk(i, anzahlRaumeProStockwerk);
		}
	}
	
	public int getAnzahlStockwerke() {
		return stockwerke.length;
	}
	
	public Stockwerk getStockwerk(int stockwerkNummer) {
		return stockwerke[stockwerkNummer];
	}

	public String toString() {
		return String.format("Gebauede an %s %s (Stockwerke: %d, Raeume pro Stockwerk: %d)", strasse, nummer, getAnzahlStockwerke(), stockwerke[0].getAnzahlRaeume());
	}

	public Stockwerk.Raum getRaum(int stockwerkNummer, int raumNummer) {
		Stockwerk sw = getStockwerk(stockwerkNummer);
		return sw.raeume[raumNummer];
	}
	
	
}
