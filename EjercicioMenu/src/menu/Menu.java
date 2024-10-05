package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	protected String titulo;
	protected ArrayList<String> opciones;
	Scanner scanner = new Scanner(System.in);

	// CONSTRUCTORES **************************
	public Menu(String titulo) {
		this.opciones = new ArrayList<>();
		this.titulo = titulo.toUpperCase();
	}

	public Menu() {
		this.opciones = new ArrayList<>();
		this.titulo = "TITULO INDEFINIDO";
	}

	// GETTERS Y SETTERS **************************
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<String> getOpciones() {
		return opciones;
	}

	public void setOpciones(ArrayList<String> opciones) {
		this.opciones = opciones;
	}

	// MÉTODOS PERSONALIZADOS **************************

	// Método para mostrar el menú
	public void mostrarMenu() {
		System.out.println(titulo); // Se muestra el título del menú
		int contador = 1;
		for (String opcion : opciones) {
			System.out.println(contador + ". " + opcion); // Se muestra cada opción numerada
			contador++;
		}
	}
	
	// Método para añadir una opción al menú
	public void añadirOpcion(String enunciado) {
		// Si la opción "Salir" existe, la nueva opción se añade justo antes de ella
		if (opciones.contains("Salir")) {
			opciones.add(opciones.indexOf("Salir"), enunciado);
		} else {
			// Si la opción "Salir" no existe, se añade al final de la lista
			opciones.add(enunciado);
		}
	}

	// Método para eliminar una opción del menú
	private void eliminarOpcion(int n) throws OpcionInvalidaException {
		if (n >= 1 && n <= opciones.size()) {
			String eliminar = opciones.get(n - 1);
			if (eliminar.equals("Salir")) {
				throw new OpcionInvalidaException("No se puede eliminar la opción \"Salir\"");
			} else {
				opciones.remove(n - 1);
				return;
			}
		} else {
			throw new OpcionInvalidaException("La opción especificada no se encuentra en el menú.");
		}
	}
	
	//Muestra el menú después de las modificaciones realizadas en la gestión del mismo
	private void mostrarModificaciones() {
		System.out.println("\nA continuación se muestra el menú con las últimas modificaciones:\n--------------------");
		mostrarMenu();
		System.out.println("--------------------");
	}

	// Método para obtener la opción seleccionada por el usuario
	private int obtenerOpcion() throws ValorInvalidoException {
		try {
			int opcionSeleccionada = Integer.parseInt(scanner.nextLine());
			return opcionSeleccionada;
		} catch (NumberFormatException e) {
			throw new ValorInvalidoException("Por favor, ingrese un número entero válido.");
		}
	}

	// Método para modificar una opción del menú
	private void modificarOpcion(int opcionSeleccionada) {

		if (opcionSeleccionada >= 1 && opcionSeleccionada <= opciones.size()) {

			System.out.print("Ingrese la nueva descripción para la opción " + opcionSeleccionada + ": ");
			String nuevaDescripcion = scanner.nextLine();

			opciones.set(opcionSeleccionada - 1, nuevaDescripcion);

			System.out.println("La opción " + opcionSeleccionada + " ha sido modificada correctamente.");

		} else {
			System.out.println("El número de opción ingresado no es válido.");
		}
	}

	// Método para cambiar el título del menú
	private void cambiarTitulo() {
		System.out.println("Introduce el nuevo título del menú: ");
		String nuevoTitulo = scanner.nextLine().toUpperCase();
		this.titulo = nuevoTitulo;
	}

	// MÉTODO PARA GESTIONAR EL MENÚ **************************
	// 1. Añade la opción de salir en caso de que no exista
	// 2. Muestra el menú
	// 3. Muestra las acciones disponibles para gestionar el menu
	// 4. En caso de que la accion deseada sea modificar o eliminar una opción existente te pide la opcion que desea gestionar
	// 5. Realiza la gestión deseada del menú
	// 6. Tras realizar la gestión muestra el menú con las modificaciones realizadas
	public void gestionar() {
		boolean salida = true;
		for (String string : opciones) {
			if (string.equals("Salir")) {
				salida = false;
			}
		}
		if (salida) {
			añadirOpcion("Salir");
		}
		mostrarMenu();
		try {
			int accion;
			int opcion = 0;

			do {
				System.out.print("""
						----------------------------------------
						Acciones disponibles:
						1. Modificar opción
						2. Eliminar opción
						3. Añadir opción
						4. Cambiar título
						5. Cancelar
						Seleccione la acción que desea realizar: """);

				accion = obtenerOpcion();
				if (accion == 1 || accion == 2) {

					System.out.print("Ahora seleccione la opción que desea " + (accion==1 ? "modificar: ":"eliminar: "));

					opcion = obtenerOpcion();

					System.out.println("Has seleccionado la opción " + opcion + ": \"" + opciones.get(opcion - 1) + "\"");

				}

				switch (accion) {
				case 1:
					modificarOpcion(opcion);
					mostrarModificaciones();
					break;

				case 2:
					eliminarOpcion(opcion);
					mostrarModificaciones();
					break;

				case 3:
					System.out.println("Escriba el enunciado de la nueva opcion: ");
					String enunciado = scanner.nextLine();
					añadirOpcion(enunciado);
					mostrarModificaciones();
					break;

				case 4:
					cambiarTitulo();
					mostrarModificaciones();
					break;

				case 5:
					System.out.println("Operación cancelada.");
					break;

				default:
					System.out.println("Opción no válida");
					break;
				}

			} while (accion != 1 && accion != 2 && accion != 3 && accion != 4 && accion != 5);

		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());

		} catch (OpcionInvalidaException e) {

			System.out.println(e.getMessage());
		}

	}

}