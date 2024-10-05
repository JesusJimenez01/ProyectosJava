package ejemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploMySQL_Select {

    public static void main(String[] args) {

        try {

            // realizamos conexión
            Connection conex = ConexionBD.conectar("test");              

            // preparamos consulta y la ejecutamos
            String query = "SELECT nombre, email FROM agenda";
            PreparedStatement instruccion = conex.prepareStatement(query);
            ResultSet resultado = instruccion.executeQuery();

            //analizamos el resultado de la consulta
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String correo = resultado.getString("email");
                System.out.println(nombre+" ("+correo+")");
            }           

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
