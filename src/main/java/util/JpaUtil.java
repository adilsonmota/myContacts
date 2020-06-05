package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JpaUtil {

	public static Connection getConnection() throws SQLException {

		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "sefaz", "sefaz");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
