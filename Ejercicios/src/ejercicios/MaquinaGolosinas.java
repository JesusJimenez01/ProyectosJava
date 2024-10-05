package ejercicios;

import java.util.Scanner;

public class MaquinaGolosinas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean encendido = true;
		int ventas = 0;
		int posicion;
		
		String[][] nombresGolosinas = {
				{ "KitKat", "Chicles de fresa", "Lacasitos", "Palotes" },
				{ "Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix" },
				{ "Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta" },
				{ "Lacasitos", "Crunch", "Milkybar", "KitKat" } };
		
		double[][] precio = {
				{ 1.1, 0.8, 1.5, 0.9 },
				{ 1.8, 1, 1.2, 1 },
				{ 1.8, 1.3, 1.2, 0.8 },
				{ 1.5, 1.1, 1.1, 1.1 } };
		
		int[][] cantidad = {
				{ 5, 5, 5, 5 },
				{ 5, 5, 5, 5 },
				{ 5, 5, 5, 5 },
				{ 5, 5, 5, 5 } };
		
		
		
		do {
			System.out.println("\nPedir golosina - 1");
			System.out.println("Mostrar golosinas - 2");
			System.out.println("Rellenar golosinas - 3");
			System.out.println("Apagar máquina - 4");
			System.out.print("\nElige una opción: ");
			
			try {
			int opcion = Integer.parseInt(sc.nextLine());
			switch (opcion) {
			case 1:
				System.out.print("Introduzca la posición de la golosina que desea comprar: ");
				posicion = Integer.parseInt(sc.nextLine());
				ventas = pedirGolosina(cantidad, nombresGolosinas, posicion, ventas);
				break;
				
			case 2:
				mostrarGolosinas(nombresGolosinas, cantidad, precio);
				break;
				
			case 3:
				verificarContraseña(sc, cantidad);
				break;
				
			case 4:
				System.out.println("\nApagando máquina...");
				System.out.println("Ventas totales: "+ventas);
				encendido=false;
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
			} catch (Exception e) {
				System.out.println("Formato incorrecto, inténtelo de nuevo.");
			}
		} while (encendido);
		sc.close();
	}
	
	
	/**
	 * 
	 * @param cantidad
	 * @param maquina
	 * @param p
	 * @param ventas
	 * @return
	 */
	static int pedirGolosina(int[][] cantidad, String[][] maquina, int p, int ventas) {
		int fila = (p/10)%10;
		int columna = p%10;
		for (int i = 0; i < cantidad.length; i++) {
			for (int j = 0; j < cantidad.length; j++) {
				if (i==fila && j==columna) {
					if (cantidad[i][j]>0) {
					cantidad[i][j]--;
					ventas=ventas+1;
					} else {
						System.out.println("Unidades insuficientes de " + maquina[i][j]);
					}
				}
			}
		}
		return ventas;
	}
	
	/**
	 * 
	 * @param maquina
	 * @param cantidad
	 * @param precio
	 */
	static void mostrarGolosinas(String[][] maquina, int[][] cantidad, double[][] precio) {
		System.out.println();
		for (int fila = 0; fila < maquina.length; fila++) {
			for (int columna = 0; columna < maquina.length; columna++) {
				System.out.print("["+maquina[fila][columna] + " " + precio[fila][columna] + "€ ("+cantidad[fila][columna]+" unidades) "+fila+columna+"]  ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param cantidad
	 * @param n
	 * @param p
	 */
	static void rellenarGolosinas(int[][]cantidad, int n, int p) {
		int fila = (p/10)%10;
		int columna = p%10;
		for (int i = 0; i < cantidad.length; i++) {
			for (int j = 0; j < cantidad.length; j++) {
				if (i==fila && j==columna) {
				cantidad[i][j]=cantidad[i][j]+n;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param sc
	 * @param cantidad
	 */
	static void verificarContraseña(Scanner sc, int[][] cantidad) {
		System.out.print("Introduce la contraseña: ");
		String pass = sc.nextLine();
		if (pass.equals("MaquinaExpendedora2017")) {
			System.out.print("Contraseña correcta. Introduzca la posición que desea rellenar: ");
			int posicion = Integer.parseInt(sc.nextLine());
			System.out.print("Introduzca la cantidad añadida: ");
			int añadir = Integer.parseInt(sc.nextLine());
			rellenarGolosinas(cantidad, añadir, posicion);
		} else {
			System.out.println("Contraseña incorrecta.");
		}
	}
	
}
