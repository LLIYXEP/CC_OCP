package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.aufgaben.MySqlUtils;

public class B11_Methadata {

	public static void main(String[] args) throws SQLException {
		
		MySqlUtils.removeTableTiere();
		MySqlUtils.buildTableTiere();
		MySqlUtils.printTableTiere();
		
		int resultSetType = ResultSet.TYPE_SCROLL_SENSITIVE;
		int resultSetConcurrency = ResultSet.CONCUR_UPDATABLE;
		
		try (Connection c = MySqlUtils.getConnection()) {
			Statement stm = c.createStatement(resultSetType, resultSetConcurrency); // bei MySql keine Wirkung
				ResultSet res = stm.executeQuery("select * from tiere");
				
				ResultSetMetaData resultSetMetaData = res.getMetaData();
				
				int columns = resultSetMetaData.getColumnCount();
				System.out.println("Columns " + columns);
				
				for (int i = 1; i <= columns; i++) {
					System.out.print(resultSetMetaData.getColumnLabel(i));
					System.out.println(" - " + resultSetMetaData.getColumnTypeName(i));
				}
				
				
		}
		
	}
	
}
