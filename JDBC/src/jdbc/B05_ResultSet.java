package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.aufgaben.MySqlUtils;

public class B05_ResultSet {

	public static void main(String[] args) throws SQLException {
		
		MySqlUtils.removeTableTiere();
		
		MySqlUtils.buildTableTiere();
		
		
		
		/*
		 * Achtung!
		 * 
		 * Statement wurde geschlossen -> ResultSet auch geschlossen
		 */
		
		try {
			Connection c = MySqlUtils.getConnection();
			Statement stm = c.createStatement();
			
			ResultSet res = stm.executeQuery("select * from tiere");
			
			stm.close(); // Statement wurde geschlossen -> ResultSet auch geschlossen
			res.next(); // Exc
		} catch (Exception e) {
			System.out.println("Fehler");
		}
		
		/*
		 * Achtung
		 * 
		 * Nur ein result Set. Altes ResultSet wird automatisch geschlossen, wenn ein neues resultSet erzeugt wird;
		 */
		
		try {
			Connection c = MySqlUtils.getConnection();
			Statement stm = c.createStatement();
			
			ResultSet res = stm.executeQuery("select * from tiere"); // ResultSet Nr. 1
			
			stm.executeQuery("select * from tiere"); // neues ResultSet Nr. 2, dabei wird ResultSet Nr 1 geschlossen
			
			res.next();
			
		} catch (Exception e) {
			System.out.println("Fehler 2: ResultSet ist geschlossen");
		}
	}
	
}
