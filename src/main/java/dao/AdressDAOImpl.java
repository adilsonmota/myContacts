package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Adress;
import util.JpaUtil;

public class AdressDAOImpl implements AdressDAO {

	public void insert(Adress adress) {
		String sql = "INSERT INTO TB_ADRESS (ID, PLACE, NUMBR, STREET, NEIGHB, CITY, STATEOF, CONTACT_ID) VALUES (?,?,?,?,?,?,?,?)";
		
		Connection conn;
		try {
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, selectId());
			ps.setString(2, adress.getPlace());
			ps.setString(3, adress.getNumbr());
			ps.setString(4, adress.getStreet());
			ps.setString(5, adress.getNeighb());
			ps.setString(6, adress.getCity());
			ps.setString(7, adress.getStateOf());
			ps.setLong(8, adress.getContact().getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Adress adress) {
		String sql = "UPDATE TB_ADRESS SET PLACE=?, NUMBR=?, STREET=?, NEIGHB=?, CITY=?, STATEOF=? WHERE ID=?";
		
		Connection conn;
		try {
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, adress.getPlace());
			ps.setString(2, adress.getNumbr());
			ps.setString(3, adress.getStreet());
			ps.setString(4, adress.getNeighb());
			ps.setString(5, adress.getCity());
			ps.setString(6, adress.getStateOf());
			ps.setLong(7, adress.getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(Adress adress) {
		String sql = "DELETE FROM TB_ADRESS WHERE ID=?";
		
		Connection conn;
		try {
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setLong(1, adress.getId());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Adress> findAll() {
		String sql = "SELECT ID, PLACE, NUMBR, STREET, NEIGHB, CITY, STATEOF FROM TB_ADRESS";
		
		List<Adress> listAdresses = new ArrayList<Adress>();
		
		Connection conn;
		try {
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Adress adress = new Adress();
				
				adress.setId(rs.getLong("ID"));
				adress.setPlace(rs.getString("PLACE"));
				adress.setNumbr(rs.getString("NUMBR"));
				adress.setStreet(rs.getString("STREET"));
				adress.setNeighb(rs.getString("NEIGHB"));
				adress.setCity(rs.getString("CITY"));
				adress.setStateOf(rs.getString("STATEOF"));

				listAdresses.add(adress);
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAdresses;
	}

	private Long selectId() {
		String sql = "SELECT SEQ_ADRESS.NEXTVAL FROM DUAL";
		
		Long backId = null;
		
		Connection conn;
		
		try {
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				backId = rs.getLong(1);
			}
			
			ps.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return backId;
	}
}
