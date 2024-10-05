package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static final String user = "root";
	public static final String pwd = "";
	public static final String url = "jdbc:MySQL://localhost/";
	
	public static Connection conectar(String nombreBD) throws SQLException{
		return DriverManager.getConnection(url+nombreBD, user, pwd);
	}
	
	public static void desconectar(Connection c) {
		if (c!=null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
