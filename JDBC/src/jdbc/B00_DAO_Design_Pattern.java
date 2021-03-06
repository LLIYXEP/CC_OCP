package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.aufgaben.MySqlUtils;

class Tier {
	private int id;
	private String name;
	private int alter;
	public Tier(int id, String name, int alter) {
		super();
		this.id = id;
		this.name = name;
		this.alter = alter;
	}
	@Override
	public String toString() {
		return name + " id: " + id + " alter: " + alter;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAlter() {
		return alter;
	}
	
}

class Tiers {
	public static TierDAO getDefaultDAO() {
		return new MySqlTierDAO();
	}
	
	public static class TierAcessException extends RuntimeException{
		public TierAcessException(Throwable e) {
			System.out.println(e);
		}
	}
}

/*
 * DAO - (Data Access Object)
 * 
 * Verstecken der Eizelheiten der Verwaltung der Daten vom Rest der Anwendung
 */

interface TierDAO {
	void create(Tier r);
	void delete(int id);
	void update(Tier t);
	Tier findByID(int id);
	List<Tier> getAllTiere();
}

class MySqlTierDAO implements TierDAO {
	
	private static void addRowToTiere(PreparedStatement stm, Tier t) throws SQLException {
		stm.setInt(1, t.getId()); 
		stm.setString(2, t.getName());
		stm.setInt(3, t.getAlter()); 
		
		stm.executeUpdate();
	}

	@Override
	public void create(Tier t) {
		
		MySqlUtils.removeTableTiere();
		MySqlUtils.buildTableTiere();
		MySqlUtils.printTableTiere();
		
		try (Connection c = MySqlUtils.getConnection()) {
				try(PreparedStatement stm = c.prepareStatement("INSERT INTO `tiere` (`id`, `name`, `alter`) VALUES (?, ?, ?)")) {
					addRowToTiere(stm, t);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Insert");
		MySqlUtils.printTableTiere();
	}

	@Override
	public void delete(int id) {
		
		try (Connection c = MySqlUtils.getConnection()) {
				try(PreparedStatement stm = c.prepareStatement("DELETE from `tiere` WHERE id = ?")) {
					stm.setInt(1, id); 
					stm.execute();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Delete");
		MySqlUtils.printTableTiere();
	}

	@Override
	public void update(Tier t) {
		try (Connection c = MySqlUtils.getConnection()) {
			try(PreparedStatement stm = c.prepareStatement("UPDATE `tiere` SET id=?, name=?, alter=? WHERE")) {
				addRowToTiere(stm, t);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
	System.out.println("Insert");
	MySqlUtils.printTableTiere();
	}

	@Override
	public Tier findByID(int id) {
		try (Connection c = MySqlUtils.getConnection();
			Statement stm = c.createStatement();
			ResultSet res = stm.executeQuery("select * from tiere where id=" + id)) {
			
			if (!res.next()) {
				return null;
			}
			
			System.out.println("Find by ID");
			return new Tier(res.getInt(1), res.getString(2), res.getInt(3));
			
		} catch (Exception e) {
			throw new Tiers.TierAcessException(e);
		}
	}

	@Override
	public List<Tier> getAllTiere() {
		List<Tier> list = new ArrayList<Tier>();
		
		try(Connection c = MySqlUtils.getConnection();
			Statement stm = c.createStatement();
			ResultSet res = stm.executeQuery("select * from tiere")) {
			
			while (res.next()) {
				Tier t = new Tier(res.getInt(1), res.getString(2), res.getInt(3));
				list.add(t);
			}
		} catch (Exception e) {
			throw new Tiers.TierAcessException(e);
		}
		return list;
	}
	
}

public class B00_DAO_Design_Pattern {

	public static void main(String[] args) {
		
		TierDAO dao = Tiers.getDefaultDAO();
		
		Tier t = new Tier(4, "Rex", 2);
		
		dao.create( t );
		
		dao.delete( 4 );
		
//		dao.update(new Tier(1, "Tomas", 9));
		
		System.out.println(dao.findByID(1));
		
		List<Tier> alleTiere = dao.getAllTiere();
//		
		System.out.println("*** alle Tiere");
		alleTiere.forEach(System.out::println);
	}
	
}
