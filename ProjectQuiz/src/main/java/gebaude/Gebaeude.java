package gebaude;

import java.util.ArrayList;
import java.util.List;

public class Gebaeude {
	
	private static String strassenNamen;
	private static Integer hausNummer;
	private static List<Stockwerk> stockwerke = new ArrayList<Gebaeude.Stockwerk>();
	private static Integer räumenProStock;
	
	public String getStrassenNamen() {
		return strassenNamen;
	}

	public Gebaeude(String strassenNamen, Integer hausNummer, int stockWerkNr, Integer räumenProStock) {
		super();
		this.strassenNamen = strassenNamen;
		this.hausNummer = hausNummer;
		for (int i = 0; i < stockWerkNr; i++) {
			Stockwerk s = new Stockwerk(i);
			this.stockwerke.add(s);
		}	
		this.räumenProStock = räumenProStock;
		for (Stockwerk stockwerk : stockwerke) {
			for (int i = 1; i < räumenProStock; i++) {
				stockwerk.getRaume().add(new Raum(i+1));
			}
		}
	}

	public Stockwerk getStockWerke(int stockwerkNr) {
		for (Stockwerk stockwerk : stockwerke) {
			if (stockwerk.getStock_id() == stockwerkNr) {
				return stockwerk;
			}
		}
		return null;
	}

	public Raum getRaum(int stockwerkNr, int raumNr) {

		for (Stockwerk stockwerk : stockwerke) {
			if (stockwerk.getStock_id() == stockwerkNr) {
				List<Raum> raume = stockwerk.getRaume();
				for (Raum raum : raume) {
					if (raum.getRaume() == raumNr) {
						return raum;
					}
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Gebaeude [strassenNamen=" + strassenNamen + ", hausNummer=" + hausNummer + ", stockwerke=" + stockwerke
				+ ", räumenProStock=" + räumenProStock + "]";
	}


	static class Stockwerk {
		private int stock_id;
		private List<Gebaeude.Raum> raume = new ArrayList<Gebaeude.Raum>();
		
		public int getStock_id() {
			return stock_id;
		}
		public List<Raum> getRaume() {
			return raume;
		}
		public void setStock_id(int stock_id) {
			this.stock_id = stock_id;
		}
		public void setRaume(List<Raum> raume) {
			this.raume = raume;
		}
		public Stockwerk(int stock_id) {
			super();
			this.stock_id = stock_id;
			this.raume.add(new Raum(1));
		}
		@Override
		public String toString() {
			return "Stockwerk [stock_id=" + stock_id + ", raume=" + raume + "]";
		}
		
		
	} // End of Stockwerk
	
	static class Raum {
		private int raume;

		public Raum(int i) {
			raume = i;
		}

		public int getRaume() {
			return raume;
		}

		public void setRaume(int raume) {
			this.raume = raume;
		}

		@Override
		public String toString() {
			return "Raum = " + raume + " / " + strassenNamen + " " + hausNummer;
			
		}
		
		
	} // end of Raum
	
	

	public static void main(String[] args) {
		
		Gebaeude g1 = new Gebaeude("HauptStrasse", 45, 3, 10);
		Raum raum = g1.getRaum(0, 2);
		System.out.println(g1);
		System.out.println(raum);
		
	}
	
}
