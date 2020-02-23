package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B02_Connection {

	public static void main(String[] args){
		
		//url ohne eine Datenbank auswahlen
		String url = "jdbc:mysql://localhost:3306/java_test_db?serverTimezone=UTC";
		String user = "root";
		String password = "9550231";
		
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			System.out.println("** Die Verbindung steht");
			
			//mit der Verbindung arbbeiten
			
			System.out.println("** Die Verbindung wird geschlossen");
			// <- connection.close
		} catch (SQLException e) {
			System.out.println("**** Fehler! Die Verbindung konnte nicht geoffnet werden!");
			
			e.printStackTrace();
		}
		
		// geschlossene Resourcen konnen nicht verwendet werden (SQL exception)
		
		exam(); // Fehler
		
	}
	
	static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/java_test_db?serverTimezone=UTC";
		String user = "root";
		String password = "9550231";
		
		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			return connection;
		} // Achtung! Connectin wird hier geschlossen
	}
	
	static void exam() {
		try {
			Connection c = getConnection(); // Achtung! Connectin wird hier geschlossen
			Statement stm = c.createStatement();
			System.out.println(stm != null);
		} catch (Exception e) {
			System.out.println("Fehler");
		}
	}
	
}
