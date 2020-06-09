package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Phone;
import util.JpaUtil;

public class PhoneDAOImpl implements PhoneDAO {

	public void insert(Phone phone) {
		String sql = "INSERT INTO TB_PHONE (ID, TYP, OPER, NUMBR, CONTACT_ID) VALUES (?,?,?,?,?)";

		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, selectId());
			ps.setString(2, phone.getTyp());
			ps.setString(3, phone.getOper());
			ps.setString(4, phone.getNumbr());
			ps.setLong(5, phone.getContact().getId());
			ps.execute();
			ps.close();
		
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Phone phone) {
		String sql = "UPDATE TB_PHONE SET TYP=?, OPER=? WHERE ID=?";

		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, phone.getTyp());
			ps.setString(2, phone.getOper());
			ps.setLong(3, phone.getId());
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(Phone phone) {
		String sql = "DELETE FROM TB_PHONE WHERE ID=?";

		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setLong(1, phone.getId());
			ps.execute();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Phone> findAll() {
		String sql = "SELECT ID, TYP, OPER, NUMBR FROM TB_PHONE";

		List<Phone> listPhones = new ArrayList<Phone>();

		Connection conn;
		try {
			conn = JpaUtil.getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Phone phone = new Phone();

				phone.setId(rs.getLong("ID"));
				phone.setTyp(rs.getString("TYP"));
				phone.setOper(rs.getString("OPER"));
				phone.setOper(rs.getString("NUMBR"));

				listPhones.add(phone);
			}
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPhones;
	}

	private Long selectId() {
		String sql = "SELECT SEQ_PHONE.NEXTVAL FROM DUAL";
		
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return backId;
	}
}
