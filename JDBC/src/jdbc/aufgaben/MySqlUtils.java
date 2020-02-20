package jdbc.aufgaben;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class MySqlUtils {
	
	public static void printTableTiere() {
		
		try (Connection connection = getConnection();) {
			
			try (Statement stm = connection.createStatement()) {
				
				String sql = "SELECT * FROM java_test_db.tiere";
				
				try (ResultSet res = stm.executeQuery(sql)) {
					
					while (res.next()) {
						
						int id = res.getInt(1); // mit dem Spalten-Index
						id = res.getInt("id");  // mit dem Spalten Namen
						
						System.out.printf("id: %3d, name: %7s, alter: %3d %n", 
								id,
								res.getString("name"),
								res.getInt(3));
					}
					
				} //<-res.close()
				
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void removeTableTiere() {
		
		try (Connection connection = getConnection();) {
			
			try (Statement stm = connection.createStatement()) {
				
				String sql = "DROP TABLE `java_test_db`.`tiere`";
				stm.executeUpdate(sql);
				System.out.println("Table 'tiere' entfernt");
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String loadScript(String scriptName) {
		try {
			return Files.lines(Paths.get("src/jdbc/aufgaben/").resolve(scriptName)).map(String::trim).collect(Collectors.joining(" "));
		} catch (IOException e) {
			e.printStackTrace();
			throw new UncheckedIOException(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/java_test_db?serverTimezone=UTC";
		String user = "root";
		String password = "9550231";
		
		return DriverManager.getConnection(url, user, password);
		
	}
	
	static void buildTableTiere()  {
		try (Connection connection = getConnection();) {
			
			try (Statement stm = connection.createStatement()) {
				
				String sql = loadScript("create_table_tiere.sql");
				stm.executeUpdate(sql);
				System.out.println("Table 'tiere' wurde erzeugt");
				
			}
			
			//INSERT INTO `java_test_db`.`tiere` (`id`, `name`, `alter`) VALUES (?, ?, ?);
			String sql = loadScript("insert_into_tiere.sql");
			try(PreparedStatement stm = connection.prepareStatement(sql)) {
				addRowToTiere(stm, 1, "Tom", 3);
				addRowToTiere(stm, 2, "Jerry", 5);
				addRowToTiere(stm, 3, "Lassie", 4);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void addRowToTiere(PreparedStatement stm, int id, String name, int alter) throws SQLException {
		stm.setInt(1, id); // Platzhalter 1, id = 1
		stm.setString(2, name);
		stm.setInt(3, alter); // Platzhalter 3, alter = 3
		
		stm.executeUpdate();
	}
	
}
