package ejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  ConexionBD{

    // Datos conexión con la BD
    private static final String USER = "root";
    private static final String PWD = "";
    private static final String URL = "jdbc:MySQL://localhost/";

    public static Connection conectar(String nombreBD) throws SQLException {
        return DriverManager.getConnection(URL+nombreBD, USER, PWD);        
    }
    
    public static void cerrarConexion (Connection con)
    {
    	try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión a BD");
			e.printStackTrace();
		}
    }
    
    public static void rollback (Connection con)
    {
    	try {
			con.rollback();
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión a BD");
			e.printStackTrace();
		}
    }
}
