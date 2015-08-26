package dataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

	private static ConnectionSingleton instance = null;
	Connection con = null;

	String user = new String("root");
	String password = new String("pampita");
	String jdbcUrlConnection = new String("jdbc:mysql://localhost:3306/sheldoncatalogsystem");

	protected ConnectionSingleton() {
		try {
			con = DriverManager.getConnection(jdbcUrlConnection, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ConnectionSingleton getInstance() {
		if (instance == null) {
			instance = new ConnectionSingleton();
		}
		return instance;
	}

}
