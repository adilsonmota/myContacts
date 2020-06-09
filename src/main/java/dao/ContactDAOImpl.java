package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Contact;
import util.JpaUtil;

public class ContactDAOImpl implements ContactDAO{

	public void insert(Contact contact) {
		String sql = "INSERT INTO TB_CONTACT (ID, NAME, LASTNAME, EMAIL, USER_ID) VALUES (?,?,?,?,?)";
		
		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, selectId());
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getLastname());
			ps.setString(4, contact.getEmail());
			ps.setLong(5, contact.getUser().getId());
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Contact contact) {
		String sql = "UPDATE TB_CONTACT SET NAME=?, LASTNAME=?, EMAIL=?, WHERE ID=?";

		Connection conn;
		try{
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, contact.getName());
			ps.setString(2, contact.getLastname());
			ps.setString(3, contact.getEmail());
			ps.setLong(4, contact.getId());
			ps.execute();
			ps.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(Contact contact) {
		String sql = "DELETE FROM TB_CONTACT WHERE ID=?";

		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, contact.getId());
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Contact> findAll() {
		String sql = "SELECT ID, NAME, LASTNAME, EMAIL FROM TB_CONTACT";
		
		List<Contact> listContacts = new ArrayList<Contact>();

		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Contact contact = new Contact();

				contact.setId(rs.getLong("ID"));
				contact.setName(rs.getString("NAME"));
				contact.setLastname(rs.getString("LASTNAME"));
				contact.setEmail(rs.getString("EMAIL"));

				listContacts.add(contact);
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return listContacts;
	}

	
	public Long lastId() {
		String sql = "SELECT SEQ_CONTACT.CURRVAL FROM DUAL";
		
		Long backId = null;
		
		Connection conn;
		
		try {
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet  rs = ps.executeQuery();
			
			while (rs.next()) {
				backId = rs.getLong(1);	
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return backId;
	}
	
	
	private Long selectId() {
		
		String sql = "SELECT SEQ_CONTACT.NEXTVAL FROM DUAL";
		
		Long backId = null;
		
		Connection conn;
		
		try {
			conn = JpaUtil.getConnection();
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet  rs = ps.executeQuery();
			
			while (rs.next()) {
				backId = rs.getLong(1);	
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return backId;
	}
}
