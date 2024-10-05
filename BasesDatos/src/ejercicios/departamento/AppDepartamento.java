package ejercicios.departamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import ejemplo.ConexionBD;

public class AppDepartamento {
	

	public static void main(String[] args) {

		Connection conex = null;
		EjercicioDepartamento ejercicioDepartamento = new EjercicioDepartamento();
		Departamento d = new Departamento(0, "POTTER-AUT", "UK");
		
		try {
			
			conex = ConexionBD.conectar("test");
			//ejercicioDepartamento.visualizarDepartamentos(conex);
			//ejercicioDepartamento.modificarDepartamento3(conex, 61, " dam1");
			
			//ejercicioDepartamento.insertarDepartamento(conex, "TEST-AUTO", "Jerez");
			//ejercicioDepartamento.insertarDepartamento(conex, d);
			ejercicioDepartamento.actualizarDeptCallable(conex,91, "HUESCA");
			ejercicioDepartamento.visualizarDepartamentos(conex);
			ejercicioDepartamento.verInfo(conex);
			ejercicioDepartamento.tablasAndVistas(conex);
			ejercicioDepartamento.procedimientosAndFunciones(conex);
			ejercicioDepartamento.infoTablas(conex, "test", "dept");
			ejercicioDepartamento.infoTablasPrimarias(conex, "test", "dept");
			ejercicioDepartamento.infoTablasAjenas(conex, "test", "dept");
			ejercicioDepartamento.infoConsulta(conex, "SELECT * FROM dept");
			
			
			
			
			
			
		//	Departamento d = new Departamento(80, "POTTER", "UK");
	      //  ArrayList<Departamento> lDep;
	         
	        
	        //ejercicioDepartamento.insertarDepartamento(conex,"nombre2", "local2");
	          // Métodos
//	        ejercicioDepartamento.visualizarDepartamentos(conex);
//	         ejercicioDepartamento.insertarDepartamento(conex, 61, "TOPSECRET", "ES");
//	         
//	          ejercicioDepartamento.insertarDepartamento(conex,d);
//	          lDep = ejercicioDepartamento.listarDepartamentos(conex);
//	          d = ejercicioDepartamento.cogerDepartamento(conex,60);
//	          ejercicioDepartamento.actualizarDepartamento(conex,d);
//	          ejercicioDepartamento.borraDepto(conex,70);
//	          System.out.println("Filas afectadas: " + ejercicioDepartamento.borraDeptoConFilas(conex,80));
//	          ejercicioDepartamento.actualizarDeptCallable(conex,70, "HUESCA");
//	          d = ejercicioDepartamento.consultarDeptCallable(conex, 40);
//	          System.out.println(d.getNumDep() + d.getNombreDep() + d.getLocalidad());
//	          ejercicioDepartamento.verInfo(conex);
//	          ejercicioDepartamento.tablasAndVistas(conex);
//	          ejercicioDepartamento.procedimientosAndFunciones(conex);
//	          ejercicioDepartamento.infoTablas(conex, "test", "dept");
//	          ejercicioDepartamento.infoTablasPrimarias(conex, "test", "dept");
//	          ejercicioDepartamento.infoTablasAjenas(conex, "test", "dept");
//	          ejercicioDepartamento.infoConsulta(conex, "SELECT * FROM dept");
	         
	         
		} catch (SQLException e) {

			ConexionBD.rollback(conex);
			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (conex != null)
				ConexionBD.cerrarConexion(conex);
		}
	}
}
