package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class EJ1 {
	public static void main(String[] args) {
		Connection con = null;
		try(BufferedReader br = new BufferedReader(new FileReader("empleados.csv"))) {
			con = Conexion.conectar("world");
			HashMap<String, Double> promedioDepartamento = new HashMap<String, Double>();
			String linea = "";
			br.readLine();
			
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				String departamento = datos[3];
				Double edad = Double.parseDouble(datos[2]);
				
				if (!promedioDepartamento.containsKey(departamento)) {
					promedioDepartamento.put(departamento, edad);
				} else {
					promedioDepartamento.put(departamento, promedioDepartamento.get(departamento)+edad);
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { Conexion.desconectar(con); }
	}

}
