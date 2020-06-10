package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Adress;
import entities.Contact;
import entities.Phone;
import entities.User;
import util.JpaUtil;

public class ContactDAOImpl implements ContactDAO{

	public Long insert(Contact contact) {
		String sql = "INSERT INTO TB_CONTACT (ID, NAME, LASTNAME, EMAIL, USER_ID) VALUES (?,?,?,?,?)";
		
		Long id = selectId();
		
		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, id);
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getLastname());
			ps.setString(4, contact.getEmail());
			ps.setLong(5, contact.getUser().getId());
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
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
	
	public List<Contact> searchContact(User user, String keyword) {
		String sql = "SELECT "
					+"C.ID ID_C, C.NAME, C.LASTNAME, C.EMAIL, "
					+"P.ID ID_P, P.TYP, P.OPER, P.NUMBR TEL, "
					+"A.ID ID_A, A.PLACE, A.NUMBR NUM, A.STREET, A.NEIGHB, A.CITY, A.STATEOF "
					+"FROM TB_CONTACT C "
					+"LEFT JOIN TB_PHONE P ON (C.ID = P.CONTACT_ID) "
					+"LEFT JOIN TB_ADRESS A ON (C.ID = A.CONTACT_ID) " + inCondition(user, keyword);
		
		List<Contact> listContacts = new ArrayList<Contact>();
		
		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Adress adress = new Adress();
				Phone phone = new Phone();
				Contact contact = new Contact();
				
				adress.setId(rs.getLong("ID_A"));
				adress.setPlace(rs.getString("PLACE"));
				adress.setNumbr(rs.getString("NUM"));
				adress.setStreet(rs.getString("STREET"));
				adress.setNeighb(rs.getString("NEIGHB"));
				adress.setCity(rs.getString("CITY"));
				adress.setStateOf(rs.getString("STATEOF"));
				
				contact.addAdress(adress);
				
				phone.setId(rs.getLong("ID_P"));
				phone.setTyp(rs.getString("TYP"));
				phone.setOper(rs.getString("OPER"));
				phone.setNumbr(rs.getString("TEL"));
				
				contact.addPhone(phone);
				
				contact.setId(rs.getLong("ID_C"));
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
	
	
	private String inCondition(User user, String keyword) {
		String where = "WHERE USER_ID=?";
		
		if (keyword != null) {
			where = "WHERE USER_ID="+user.getId()+" AND "
					+"(C.NAME LIKE'%"+keyword+"%' OR "
					+"C.LASTNAME LIKE'%"+keyword+"%' OR "
					+"C.EMAIL LIKE'%"+keyword+"%' OR "
					+"P.TYP LIKE'%"+keyword+"%' OR "
					+"P.OPER LIKE'%"+keyword+"%' OR "
					+"A.PLACE LIKE'%"+keyword+"%' OR "
					+"A.STREET LIKE'%"+keyword+"%' OR "
					+"A.NEIGHB LIKE'%"+keyword+"%' OR "
					+"A.CITY LIKE'%"+keyword+"%' OR "
					+"A.STATEOF LIKE'%"+keyword+"%')";
		}
		return where;
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
