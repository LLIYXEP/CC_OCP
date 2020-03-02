package serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class B04_manuell_serialisieren_besser {

	static class Motor {
		String typ;

		public Motor(String typ) {
			super();
			this.typ = typ;
		}

		@Override
		public String toString() {
			return "Motor [typ=" + typ + "]";
		}
		
	}
	
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
		
		transient Motor motor; // <- nicht Serializable. transient Attribut wird beim 'Standartserialisieren' ubersprungen
		String hersteller;
		
		public PKW(String hersteller, int baujahr) {
			super(baujahr);
			this.hersteller = hersteller;
			System.out.println("PKW(String,int)");
		}
		@Override
		public String toString() {
			return "hersteller " + hersteller + ", baujahr " + baujahr + ", Motor: " + motor ;
		}
		
		private void writeObject(ObjectOutputStream oos) throws IOException {
			System.out.println("**** writeObject()");
			
			oos.defaultWriteObject(); // Standartserialisieren, hersteller wird serialisiert
			
			oos.writeInt(baujahr);   // manuell
			oos.writeUTF(motor.typ); // manuell
		}
		
		private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
			System.out.println("**** readObject()");
			
			ois.defaultReadObject(); // // Standartdeserialisieren, hersteller wird deserialisiert
			
			baujahr = ois.readInt();  // manuell
			String motorTyp = ois.readUTF();  // manuell
			motor = new Motor(motorTyp);  
		}
	}

	/*
	 * Bequem Serialisiren fur den Benutzer der Klasse PKW
	 */
	public static void main(String[] args) {
		
		String file = "pkw04";
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)) ) {
			
			PKW pkw1 = new PKW("Audi", 2001);
			pkw1.motor = new Motor("T1");
			
			oos.writeObject(pkw1);
			System.out.println("Serialisiert: " + pkw1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			
			PKW pkw2 = (PKW)ois.readObject();
			System.out.println("Deserialisiert: " + pkw2);
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
