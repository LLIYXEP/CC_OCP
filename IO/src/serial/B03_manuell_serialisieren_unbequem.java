package serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import serial.B02_Vererbung.Auto;
import serial.B02_Vererbung.PKW;

public class B03_manuell_serialisieren_unbequem {

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
		
	}

	public static void main(String[] args) {
		
		String file = "pkw01";
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)) ) {
			
			PKW pkw1 = new PKW("Audi", 2001);
			pkw1.motor = new Motor("T1");
			
			oos.writeObject(pkw1); // nur 'hersteller' serialisiert
			oos.writeInt(pkw1.baujahr);	  // manuell
			oos.writeUTF(pkw1.motor.typ); // manuell
			System.out.println("Serialisiert: " + pkw1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			
			PKW pkw2 = (PKW)ois.readObject(); // // nur 'hersteller' deserialisiert
			pkw2.baujahr = ois.readInt();
			String motor = ois.readUTF();
			pkw2.motor = new Motor(motor);
			System.out.println("Deserialisiert: " + pkw2);
			
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
