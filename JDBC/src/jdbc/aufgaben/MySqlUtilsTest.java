package jdbc.aufgaben;

import java.sql.Connection;

public class MySqlUtilsTest {

	public static void main(String[] args) {
		
		/*
		 * A1
		 */
		
		try(Connection connection = MySqlUtils.getConnection()) {
			System.out.println("Connection steht");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Keine connection mehr");
		
		/*
		 * A2
		 */
		
		MySqlUtils.removeTableTiere();
		
		MySqlUtils.buildTableTiere();
		
		MySqlUtils.printTableTiere();
		
	}
	
}
