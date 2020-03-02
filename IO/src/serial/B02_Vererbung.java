package serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class B02_Vererbung {
	
	/*
	 * Angenommen, man darf nicht (kann nicht) die Klasse Auto andern
	 */
	static class Auto {
		int baujahr;
		
		public Auto() {
			System.out.println("Auto()");
		}

		public Auto(int baujahr) {
			System.out.println("Auto(int)");
			this.baujahr = baujahr;
		}
		
	}
	
	/*
	 * Angenommen, dass nur die Klasse PKW 'Serializable' markiert werden darf/kann
	 */
	static class PKW extends Auto implements Serializable {
		String hersteller;
		public PKW(String hersteller, int baujahr) {
			super(baujahr);
			this.hersteller = hersteller;
			System.out.println("PKW(String,int)");
		}
		@Override
		public String toString() {
			return "hersteller " + hersteller + ", baujahr " + baujahr;
		}
		
	}

	public static void main(String[] args) {
		
		String file = "pkw01";
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)) ) {
			
			PKW pkw1 = new PKW("Audi", 2001);
			oos.writeObject(pkw1); // nur das Serializable - Teil vom PKW (also nur das Attribut 'hersteller') wird serialisiert
									// Attribute aus dem Nizchtserializable - Teil werden ubersprungen (hier: baujahr)
			
			System.out.println("Serialisiert: " + pkw1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			
			PKW pkw2 = (PKW)ois.readObject(); // Im Input gibt es nur hersteller!
												// Aber das PKW hat auch bahjahr, dass auch initialisiert werden muss:
												// Dafur wird der noargs-Konstruktor, der tiefsten Nicht - Serializable
												// Klasse augerufen (hier: 'Auto')
			System.out.println("Deserialisiert: " + pkw2);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
