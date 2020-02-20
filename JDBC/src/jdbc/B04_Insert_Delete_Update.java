package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B04_Insert_Delete_Update {
	
	

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/java_test_db?serverTimezone=UTC";
		
		try (Connection connection = DriverManager.getConnection(url, "root", "9550231")) {
			
			
			try (Statement stm = connection.createStatement()) {
				
				/*
				 * INSERT
				 */
				String sql = "INSERT INTO `java_test_db`.`personen` (`vorname`, `nachname`, `geburtsjahr`) VALUES ('George', 'H.', '1958')";
				stm.executeUpdate(sql);
				System.out.println("George H. hinzufugt");
				
				/*
				 * UPDATE
				 */
				sql = "UPDATE `java_test_db`.`personen` SET geburtsjahr = 1955 WHERE vorname = 'George'";
				stm.executeUpdate(sql);
				System.out.println("Geburtsjahr vom alle George H. auf 1955 geandert");
				
				/*
				 * DELETE
				 */
				sql = "DELETE from `java_test_db`.`personen` WHERE vorname = 'George'";
				stm.executeUpdate(sql);
				System.out.println("Alle mit dem Vorname George H. enfernt");
				
			} //<-stm.close()
			
			
			//<-c.close()
		} catch (SQLException e) {
			System.out.println("**** Fehler! Die Verbindung konnte nicht geoffnet werden!");
			
			e.printStackTrace();
		}
		
	}
	
}
