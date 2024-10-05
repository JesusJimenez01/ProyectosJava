package ejercicios.departamento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemplo.ConexionBD;

/**
 * 1. Visualizar número y nombre de todos los departamentos. 2. Modificar el
 * nombre de un departamento cuyo número (y nombre) se pase(n) como argumento.
 * No utilizar sentencias preparadas. Visualizar el número de filas afectadas.
 * 3. Realiza el ejercicio anterior con sentencias preparadas. 4. Realiza el
 * ejercicio anterior utilizando transacciones 5. A Conectar a la base de datos
 * (carga del driver y establecimiento de conexión). B Insertar un departamento.
 * El método recibirá tres argumentos (número, nombre y localidad). C El mismo
 * que b pero recibiendo un solo argumento, un objeto de la clase departamento.
 * Será necesario por tanto crear una clase departamento, con sus atributos y
 * métodos getter y setter. D Método que devuelva un ArrayList de objetos
 * departamento ante la consulta de todas las columnas de todos los
 * departamentos de la tabla dept E Método que reciba un número de departamento
 * y devuelva sus datos mediante un objeto. F Método que reciba un objeto
 * departamento y actualice la tabla dept. G Método que reciba un número de
 * departamento y lo dé de baja. Ídem del anterior pero devolviendo el número de
 * filas afectadas.
 * 
 * Método que reciba un número de departamento y actualice su localidad.
 * Mediante procedimiento almacenado Método que reciba un número de departamento
 * y devuelva un objeto con sus datos usando procedimiento almacenado Método que
 * imprima el gestor de base de datos empleado, el driver utilizado y el usuario
 * conectado.
 * 
 * Método que imprima el gestor de base de datos empleado, el driver utilizado y el usuario conectado.
Método que imprima del esquema actual todas las tablas y vistas que contiene, indicando además del nombre, si se trata de una tabla o una vista.
Ídem del anterior pero para programas almacenados (procedimientos/funciones).
Método que reciba un esquema y una tabla e imprima sus columnas (nombre de la columna, tipo, tamaño y si admite o no valores nulos).
Método que reciba un esquema y una tabla e imprima la lista de columnas que forman la clave primaria.
Método que reciba un esquema y una tabla e imprima la lista de todas las claves ajenas que utilizan la clave primaria de esta tabla.
Método que reciba una consulta (p.ej. SELECT * FROM dept) e imprima el número de columnas recuperadas, y por cada columna el nombre, tipo, tamaño y si admite o no nulos.
 */
public class EjercicioDepartamento {

	static Statement stmt = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	static CallableStatement cs = null;
	static DatabaseMetaData d = null;

	/**
	 * 1. Visualizar número y nombre de todos los departamentos.
	 * 
	 */

	public static void visualizarDepartamentos(Connection conn) throws SQLException

	{

		stmt = conn.createStatement();
		rs = stmt.executeQuery("select deptno, dname, localidad from dept");

		while (rs.next()) {
			int numDept = rs.getInt("deptno");
			String nombre = rs.getString("dname");
			String localidad = rs.getString("localidad");
			System.out.println("Departamento: " + numDept + ". Nombre: " + nombre + " Localidad:" + localidad);
		}

	}

	/**
	 * 2. Modificar el nombre de un departamento cuyo número (y nombre) se pase(n)
	 * como argumento. No utilizar sentencias preparadas. Visualizar el número de
	 * filas afectadas.
	 */
	public static void modificarDepartamento(Connection conn, int numDep, String newName) throws SQLException

	{
		stmt = conn.createStatement();
		int i = stmt.executeUpdate("UPDATE DEPT SET DNAME = '" + newName + "' WHERE DEPTNO = " + numDep + ";");
		System.out.println("Filas afectadas: " + i);

	}

	/**
	 * 3. Realiza el ejercicio anterior con sentencias preparadas.
	 */
	public static void modificarDepartamento2(Connection conn, int numDep, String newName) throws SQLException

	{
		ps = conn.prepareStatement("UPDATE DEPT SET DNAME = (?) WHERE DEPTNO = (?);");
		ps.setString(1, newName);
		ps.setInt(2, numDep);
		int i = ps.executeUpdate();
		System.out.println("Filas afectadas: " + i);

	}

	/**
	 * 4. Realiza el ejercicio anterior utilizando transacciones
	 */
	public static void modificarDepartamento3(Connection conn, int numDep, String newName)

	{
		try {
			conn.setAutoCommit(false); // Desactivo el commit para cada sentencia
			ps = conn.prepareStatement("UPDATE DEPT SET DNAME = (?) WHERE DEPTNO = (?);");
			ps.setString(1, newName);
			ps.setInt(2, numDep);
			int i = ps.executeUpdate();
			conn.commit(); // Al finalizar sentencias hago commit
			conn.setAutoCommit(true); // Y vuelvo a activar autocommit para resto de aplicación
		} catch (SQLException e) {
			ConexionBD.rollback(conn); // Si algo falla hago rollback para dejarlo como antes
			e.printStackTrace();
		}
	}

	/**
	 * Insertar un departamento. El método recibirá tres argumentos (número, nombre
	 * y localidad).
	 */

	public static void insertarDepartamento(Connection conn, int numDep, String nombreDept, String localidad)
			

	{
		try {
			conn.setAutoCommit(false); // Desactivo el commit para cada sentencia
			ps = conn.prepareStatement("INSERT INTO DEPT VALUES((?),(?),(?));");
			ps.setInt(1, numDep);
			ps.setString(2, nombreDept);
			ps.setString(3, localidad);
			ps.executeUpdate();
			conn.commit(); // Al finalizar sentencias hago commit
			conn.setAutoCommit(true); // Y vuelvo a activar autocommit para resto de aplicación
		} catch (SQLException e) {

			ConexionBD.rollback(conn);// Si algo falla hago rollback para dejarlo como antes
			e.printStackTrace();
		}

	}

	/**
	 * Insertar un departamento con clave autogenerada. El método recibirá dos
	 * argumentos (nombre y localidad).
	 */

	public static void insertarDepartamento(Connection conn, String nombreDept, String localidad)

	{
		try {
			conn.setAutoCommit(false); // Desactivo el commit para cada sentencia

			ps = conn.prepareStatement("INSERT  INTO DEPT (dname, localidad) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, nombreDept);
			ps.setString(2, localidad);

			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					System.out.printf("departamento creado con ID=%d\n", id);
				}
			}

			conn.commit(); // Al finalizar sentencias hago commit
			conn.setAutoCommit(true); // Y vuelvo a activar autocommit para resto de aplicación
		} catch (SQLException e) {

			ConexionBD.rollback(conn); // Si algo falla hago rollback para dejarlo como antes
			System.out.println("El departamento no ha podido ser creado.");
			e.printStackTrace();
		}

	}

	/**
	 * Isnertar deparamento pero con una clase Departamento
	 * 
	 * @param depto
	 */
	public static void insertarDepartamento(Connection conn, Departamento depto) {

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("INSERT  INTO DEPT (dname, localidad) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
			//ps.setInt(1, depto.getNumDep());
			ps.setString(1, depto.getNombreDep());
			ps.setString(2, depto.getLocalidad());
						
			int registrosAfectados = ps.executeUpdate();
			if (registrosAfectados > 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					System.out.printf("departamento creado con ID=%d\n", id);
				}
			} 
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {

			ConexionBD.rollback(conn); // Si algo falla hago rollback para dejarlo como antes
			System.out.println("El departamento no ha podido ser creado.");
			e.printStackTrace();
		}

	}

	/**
	 * Listar departamentos devolviendo un arrayList
	 * 
	 * @param depto
	 */
	public static ArrayList<Departamento> listarDepartamentos(Connection conn) throws SQLException {

		Departamento d = new Departamento();
		ArrayList<Departamento> listaDepartamentos = new ArrayList<Departamento>();

		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM DEPT");

		while (rs.next()) {
			d.setNumDep(rs.getInt("DEPTNO"));
			d.setNombreDep(rs.getString("DNAME"));
			d.setNombreDep(rs.getString("LOCALIDAD"));
			System.out.println(d.toString());
			listaDepartamentos.add(d);
		}

		return listaDepartamentos;

	}

	/**
	 * Método que reciba un número de departamento y devuelva sus datos mediante un
	 * objeto.
	 */

	public static Departamento cogerDepartamento(Connection conn, int numDep) throws SQLException{
		Departamento d = new Departamento();
		
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM DEPT WHERE DEPTNO = " + numDep + ";");

			while (rs.next()) {
				d.setNumDep(rs.getInt("DEPTNO"));
				d.setNombreDep(rs.getString("DNAME"));
				d.setLocalidad(rs.getString("LOCALIDAD"));
				System.out.println(d.toString());
			}
		
		return d;
	} // Fin función cogerDepartamento()

	/**
	 * Método que reciba un objeto departamento y actualice la tabla dept
	 */
	public static void actualizarDepartamento(Connection conn, Departamento depto) {
		Departamento d = depto;

		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("UPDATE DEPT SET DNAME = ?, LOCALIDAD = ? WHERE DEPTNO = ?");
			ps.setString(1, d.getNombreDep());
			ps.setString(2, d.getLocalidad());
			ps.setInt(3, d.getNumDep());
			ps.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			ConexionBD.rollback(conn); // Si algo falla hago rollback para dejarlo como antes
			e.printStackTrace();
		}

	} // Fin función actualizarDepartamento()

	/**
	 * borrar departamento
	 */
	public static void borraDepto(Connection conn, int n) {
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement("DELETE FROM DEPT WHERE DEPTNO = (?)");
			ps.setInt(1, n);
			ps.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			ConexionBD.rollback(conn); // Si algo falla hago rollback para dejarlo como antes
			e.printStackTrace();
		}

	} // Fin función borrarDepto()

	/**
	 * borrar departamento indicando las filas borradas
	 */
	public static int borraDeptoConFilas(Connection conn, int numDepartamento) {
		int cantFilasBorradas = 0;
		try {

			conn.setAutoCommit(false);
			ps = conn.prepareStatement("DELETE FROM DEPT WHERE DEPTNO = (?)");
			ps.setInt(1, numDepartamento);
			cantFilasBorradas = ps.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);

			System.out.println("filas borradas: " + cantFilasBorradas);
		} catch (SQLException e) {
			ConexionBD.rollback(conn); // Si algo falla hago rollback para dejarlo como antes
			e.printStackTrace();
		}
		return cantFilasBorradas;

	} // Fin función borrarDeptoConFilas()

	/**
	 * Actulizar departamento a través del procedimiento almacenado
	 * 
	 * @param n
	 * @param localidad
	 */

	public static void actualizarDeptCallable(Connection conn, int n, String localidad) {
		try {
			conn.setAutoCommit(false);
			cs = conn.prepareCall("{call actualizaDept(?,?)}");
			cs.setInt(1, n);
			cs.setString(2, localidad);
			cs.execute();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			ConexionBD.rollback(conn); // Si algo falla hago rollback para dejarlo como antes
			e.printStackTrace();

		}
	} // Fin función actualizarDeptCallable

	/**
	 * Consultar departamento a través del procedimiento almacenado
	 * 
	 */

	public static Departamento consultarDeptCallable(Connection conn, int numDepto) throws SQLException {
		Departamento depto = new Departamento();

		conn.setAutoCommit(false);
		cs = conn.prepareCall("{call consultaDepar(?, ?, ?)}");
		cs.setInt(1, numDepto);
		cs.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs.registerOutParameter(3, java.sql.Types.VARCHAR);
		cs.execute();
		depto.setNumDep(numDepto);
		depto.setNombreDep(cs.getString(2));
		depto.setLocalidad(cs.getString(3));
		conn.setAutoCommit(true);

		System.out.println(depto.toString());

		return depto;

	} // Fin función actualizarDeptCallable

	/**
	 * Método que imprima el gestor de base de datos empleado, el driver utilizado y
	 * el usuario conectado.
	 */

	public static void verInfo(Connection conn) {
		if (conn != null) {
			try {
				d = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Gestor: " + d.getDatabaseProductName());
				System.out.println("Usuario conectado: " + d.getUserName());

				System.out.println("Driver utilizado: " + d.getDriverVersion());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} // Fin función verInfo()

	public void tablasAndVistas(Connection conn) throws SQLException {

		stmt = conn.createStatement();
		rs = stmt.executeQuery("SHOW FULL TABLES;");
		while (rs.next()) {
			if (rs.getString(2).equals("BASE TABLE"))
				System.out.println(rs.getString(1) + ": TABLA");
			if (rs.getString(2).equals("VIEW"))
				System.out.println(rs.getString(1) + ": VISTA");
		}

	} // Fin funcion tablasAndVistas()

	// EJERCICIO O
	public void procedimientosAndFunciones(Connection conn) throws SQLException {

		stmt = conn.createStatement();
		rs = stmt.executeQuery("SHOW PROCEDURE STATUS");
		while (rs.next()) {
			System.out.println(rs.getString(2) + ": PROCEDIMIENTO");
		}

		rs = stmt.executeQuery("SHOW FUNCTION STATUS");
		while (rs.next()) {
			System.out.println(rs.getString(2) + ": FUNCIÓN");
		}
	} // Fin función procedimientosAndFunciones()

	// EJERCICIO P
	public void infoTablas(Connection conn, String esquema, String tabla) throws SQLException {

		d = (DatabaseMetaData) conn.getMetaData();
		rs = d.getColumns(conn.getCatalog(), esquema, "%", null);

		System.out.println("INFO TABLAS");

		while (rs.next()) {
			System.out.println("Nombre: " + rs.getString(3) + " "+  rs.getString(4)+ "\tTamaño: " + rs.getString(7) + "\tTipo: "
					+ rs.getString(6) + "\tValores nulos: " + rs.getString(18));
		}

	} // Fin función infoTablas()

	
	public void infoTablasPrimarias(Connection conn, String esquema, String tabla) throws SQLException {

		d = (DatabaseMetaData) conn.getMetaData();
		rs = d.getPrimaryKeys(conn.getCatalog(), esquema, tabla);

		System.out.println("Schema\tTabla\tClave Primaria");
		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
		}

	} // Fin función infoTablasPrimarias()


	public void infoTablasAjenas(Connection conn, String esquema, String tabla) throws SQLException {

		d = (DatabaseMetaData) conn.getMetaData();
		rs = d.getExportedKeys(conn.getCatalog(), esquema, tabla);

		while (rs.next()) {
			System.out.println(
					rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
		}

	} // Fin función infoTablasAjenas()

	
	public void infoConsulta(Connection conn, String select) throws SQLException {

		stmt = conn.createStatement();
		rs = stmt.executeQuery(select);

		while (rs.next()) {
			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}

	} // Fin función infoConsulta()

}