package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B03_Select {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/java_test_db?serverTimezone=UTC";
		String user = "root";
		String password = "9550231";
		
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			
			
			try (Statement stm = connection.createStatement()) {
				
				String sql = "SELECT * FROM java_test_db.personen";
				
				try (ResultSet res = stm.executeQuery(sql)) {
					
					while (res.next()) {
						
						int id = res.getInt(1); // mit dem Spalten-Index
						id = res.getInt("id");  // mit dem Spalten Namen
						
						System.out.printf("id: %3d, vorname: %7s, nachname: %12s, geb.: %d %n", 
								id,
								res.getString("vorname"),
								res.getString("nachname"),
								res.getInt("geburtsjahr"));
					}
					
				} //<-res.close()
				
				
			} //<-stm.close()
			
			
			//<-c.close()
		} catch (SQLException e) {
			System.out.println("**** Fehler! Die Verbindung konnte nicht geoffnet werden!");
			
			e.printStackTrace();
		}
		
	}
	
}
