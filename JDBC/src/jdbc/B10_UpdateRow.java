package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.aufgaben.MySqlUtils;

public class B10_UpdateRow {

public static void main(String[] args) throws SQLException {
		
		MySqlUtils.removeTableTiere();
		MySqlUtils.buildTableTiere();
		MySqlUtils.printTableTiere();
		
		int resultSetType = ResultSet.TYPE_SCROLL_SENSITIVE;
		int resultSetConcurrency = ResultSet.CONCUR_UPDATABLE;
		
		try (Connection c = MySqlUtils.getConnection()) {
			Statement stm = c.createStatement(resultSetType, resultSetConcurrency); // bei MySql keine Wirkung
				ResultSet res = stm.executeQuery("select * from tiere");
				
				res.last();
				
				res.updateString("name", "Rex");
				
				res.updateRow();
		}
		
		System.out.println();
		MySqlUtils.printTableTiere();
		
	}
	
}
