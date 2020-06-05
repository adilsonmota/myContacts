package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		Connection conexao = null;

        try {

                 Class.forName("oracle.jdbc.OracleDriver");

                 conexao = DriverManager.getConnection(

                           "jdbc:oracle:thin:@localhost:1521:xe", "sefaz", "sefaz");
                 
                 System.out.println("Conexão: " + conexao.getSchema().toString());

        } catch (ClassNotFoundException e) {

                 e.printStackTrace();

        } catch (SQLException e) {

                 e.printStackTrace();

        }



	}

}
