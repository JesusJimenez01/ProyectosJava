package examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PersonaApp {

    public static void main(String[] args) {
        Connection con = null;
        Scanner sc = new Scanner(System.in);

        try {
            con = Conexion.conectar("practica");
            String query = "ALTER TABLE `persona` CHANGE `id` `id` INT(10) NOT NULL AUTO_INCREMENT, CHANGE `telefono` `telefono` INT(10) NULL DEFAULT NULL";
            PreparedStatement actualizarColumnas = con.prepareStatement(query);
            actualizarColumnas.executeUpdate();

            int opcion = 0;
            while (opcion != 6) {
                opcion = mostrarMenu(sc);
                switch (opcion) {
                    case 1:
                        registrarPersona(con, sc);
                        break;
                    case 2:
                        buscarPersona(con, sc);
                        break;
                    case 3:
                        listarPersonas(con);
                        break;
                    case 4:
                        modificarPersona(con, sc);
                        break;
                    case 5:
                        borrarPersona(con, sc);
                        break;
                    case 6:
                        System.out.println("Saliendo de la aplicación...");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("ERROR al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public static int mostrarMenu(Scanner sc) {
        System.out.println("--------- ADMINISTRADOR DE PERSONAS ---------");
        System.out.println("1. Registrar Persona");
        System.out.println("2. Buscar Persona");
        System.out.println("3. Listar personas");
        System.out.println("4. Modificar Persona");
        System.out.println("5. Eliminar Persona");
        System.out.println("6. Salir de la aplicación");
        System.out.print("Escriba el número de la opción: ");
        return Integer.parseInt(sc.nextLine());
    }

    public static void registrarPersona(Connection con, Scanner sc) {
        try {
            System.out.print("Indique el nombre del usuario a registrar: ");
            String nombre = sc.nextLine();
            System.out.print("Indique la edad del usuario: ");
            int edad = Integer.parseInt(sc.nextLine());
            System.out.print("Ahora indique la profesión del usuario: ");
            String profesion = sc.nextLine();
            System.out.print("Por último, introduzca un número de teléfono: ");
            int telefono = Integer.parseInt(sc.nextLine());

            String query = "INSERT INTO persona (nombre, edad, profesion, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, profesion);
            ps.setInt(4, telefono);

            ps.executeUpdate();
            System.out.println("Persona registrada con éxito.");
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void buscarPersona(Connection con, Scanner sc) {
        try {
            System.out.println("Indique el id del usuario: ");
            int id = Integer.parseInt(sc.nextLine());

            String query = "SELECT nombre, edad, profesion, telefono FROM persona WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString("nombre") + " | " + rs.getInt("edad") + " | " + rs.getString("profesion") + " | " + rs.getInt("telefono"));
            } else {
                System.out.println("No se encontró una persona con el id especificado.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void listarPersonas(Connection con) {
        try {
            String query = "SELECT * FROM persona";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            int n = 1;
            while (rs.next()) {
                System.out.println(n + " " + rs.getString("nombre") + " | " + rs.getInt("edad") + " | " + rs.getString("profesion") + " | " + rs.getInt("telefono"));
                n++;
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void modificarPersona(Connection con, Scanner sc) {
        try {
            System.out.println("Escribe el id del usuario que desea cambiar: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("Escribe el nuevo nombre: ");
            String nuevonombre = sc.nextLine();

            String query = "UPDATE persona SET nombre = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nuevonombre);
            ps.setInt(2, id);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Persona modificada con éxito.");
            } else {
                System.out.println("No se encontró una persona con el id especificado.");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static void borrarPersona(Connection con, Scanner sc) {
        try {
            System.out.println("Escribe el id del usuario que desea eliminar: ");
            int id = Integer.parseInt(sc.nextLine());

            con.setAutoCommit(false);
            String query = "DELETE FROM persona WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                con.commit();
                System.out.println("Persona eliminada con éxito.");
            } else {
                con.rollback();
                System.out.println("No se encontró una persona con el id especificado.");
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.out.println("ERROR al hacer rollback: " + ex.getMessage());
            }
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("ERROR al restaurar auto-commit: " + e.getMessage());
            }
        }
    }
}
