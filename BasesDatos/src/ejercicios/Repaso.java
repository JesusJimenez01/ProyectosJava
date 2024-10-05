package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

public class Repaso {

	public static void main(String[] args) {
		Connection con = null;
		try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
			con = Conexion.conectar("usuarios");
			String query = "INSERT INTO usuarios (nombre, edad, correo) VALUES (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			String linea = "";
			while ((linea = br.readLine()) != null) {
				String[] datos = obtenerDatos(linea);
				ps.setString(1, datos[0]);
				ps.setInt(2, Integer.parseInt(datos[1]));
				ps.setString(3, datos[2]);
				
				ps.executeUpdate();
				
			}
			
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			Conexion.desconectar(con);
		}

	}
	
	public static String[] obtenerDatos(String linea) {
		return linea.trim().split(",");
	}
	

}
