package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import jdbc.aufgaben.MySqlUtils;

public class B07_Scrolling {
	
	static String getDisplayType(int type) {
		switch (type) {
		case ResultSet.TYPE_FORWARD_ONLY:
			return "TYPE_FORWARD_ONLY";
		case ResultSet.TYPE_SCROLL_SENSITIVE:
			return "TYPE_SCROLL_SENSITIVE";
		case ResultSet.TYPE_SCROLL_INSENSITIVE:
			return "TYPE_SCROLL_INSENSITIVE";
		default:
			return "Bad type " + type;
		}
	}

	public static void main(String[] args) throws SQLException {
		
		MySqlUtils.removeTableTiere();
		MySqlUtils.buildTableTiere();
		MySqlUtils.printTableTiere();
		
		try (Connection c = MySqlUtils.getConnection()) {
			Statement stm = c.createStatement();
				ResultSet res = stm.executeQuery("select * from tiere");
				
				int type = res.getType();
				System.out.println(getDisplayType(type));
		}
		
		try (Connection c = MySqlUtils.getConnection()) {
			
			int resultSetType = ResultSet.TYPE_SCROLL_SENSITIVE;
			// ResultSet.TYPE_SCROLL_SENSITIVE;
//			 ResultSet.TYPE_SCROLL_INSENSITIVE;
			int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
			Statement stm = c.createStatement(resultSetType, resultSetConcurrency);
				ResultSet res = stm.executeQuery("select * from tiere");
			
				int type = res.getType();
				System.out.println(getDisplayType(type));
				
				// Zeiger vor der 1. Zeile
				
				while (res.next()) {;}
				
				// Zeiger naxh der letzten 1. Zeile
				
				res.previous();
		} 
		
	}
	
}
