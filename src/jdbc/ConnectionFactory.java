package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static final String BANCO = "jdbc:mysql://localhost/Banco";
	public static final String USER = "root";
	public static final String PWD = "root" ;
	
	public Connection getConnection(String banco, String user, String acess){
		try {
			return DriverManager.getConnection(banco,user,acess);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
