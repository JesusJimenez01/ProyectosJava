package Math;

import java.util.Random;

/**
 * Escribe un programa que muestre la tirada de tres dados. Se debe mostrar
también la suma total (los puntos que suman entre los tres dados).
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		
		  int tirada;
		    int suma = 0;
		    
		    System.out.print("Tirada de tres dados calse Math: ");

		    for(int i = 0; i < 3; i++) {
		      tirada = (int)(Math.random() * 6) + 1;
		      System.out.print(tirada + " ");
		      suma += tirada;
		    }

		    System.out.println("\nSuma: " + suma);
		    
		    System.out.print("Tirada de tres dados calse Random: ");
		    suma = 0;
		    Random rdn = new Random();
		    for(int i = 0; i < 3; i++) {
		      tirada = rdn.nextInt(6) + 1;
		      System.out.print(tirada + " "); 
		      suma += tirada;
		    }

		    System.out.println("\nSuma: " + suma);
	}

}
