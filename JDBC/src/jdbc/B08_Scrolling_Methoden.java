package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.aufgaben.MySqlUtils;

public class B08_Scrolling_Methoden {
	
	public static void main(String[] args) throws SQLException {
		
		MySqlUtils.removeTableTiere();
		MySqlUtils.buildTableTiere();
		MySqlUtils.printTableTiere();
		
		int resultSetType = ResultSet.TYPE_SCROLL_SENSITIVE;
		int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY; // ResultSet.TYPE_SCROLL_SENSITIVE; // ResultSet.TYPE_SCROLL_INSENSITIVE;
		
		try (Connection c = MySqlUtils.getConnection()) {
			Statement stm = c.createStatement(resultSetType, resultSetConcurrency); // bei MySql keine Wirkung
				ResultSet res = stm.executeQuery("select * from tiere");
				
//				res.getInt(1); // SQLException: Before start of result set
				
				res.next();
				
				System.out.println("1. " + res.getString(2)); // Tom
				
				res.last();
				
				System.out.println("2. " + res.getString(2)); // Lassie
				
				res.first();
				
				System.out.println("3. " + res.getString(2)); // Tom
				
				res.beforeFirst();
//				System.out.println("4. " + res.getString(2)); // SQLException: Before start of result set
				
				res.afterLast();
//				System.out.println("5. " + res.getString(2)); // SQLException: After end of result set
				
				System.out.println("Alle Zeilen quckwarts");
				while (res.previous()) {
					System.out.println(res.getString(2)); 
				}
				
				/*
				 * 
				 */
				res.absolute(3);
				System.out.println("4. " + res.getString(2)); // Lassie
				
				res.absolute(-3);
				System.out.println("5. " + res.getString(2)); // Tom
				
				res.relative(1);
				System.out.println("6. " + res.getString(2)); // Jerry
				
				res.relative(-2);
//				System.out.println("6. " + res.getString(2));  //SQLException: Before start of result set
		}
		
	}
}
