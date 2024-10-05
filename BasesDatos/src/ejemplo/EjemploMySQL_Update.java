package ejemplo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploMySQL_Update {

    public static void main(String[] args) {
    	Connection conex = null;
        try {

            // realizamos conexión
            conex = ConexionBD.conectar("agenda");

            // insertamos contacto
            String query = "UPDATE contacto SET edad = ? WHERE edad = ?";
            PreparedStatement queryUpdate = conex.prepareStatement(query);
            queryUpdate.setInt(1, 30);
            queryUpdate.setInt(2, 24);
            int resultado = queryUpdate.executeUpdate();

            // analizamos el resultado del insert
            if (resultado > 0)
                System.out.println("Se han modificado " + resultado + " contactos correctamente");

        } catch (SQLException e) {
            System.out.println(e);
        }finally {
        	if (conex != null)
        		ConexionBD.cerrarConexion(conex);
		}
        
    }
}
