package unidimensional;

import java.util.Scanner;

/**
 * 7.1 Arrays
 * 
 * 3. Escribe un programa que lea 10 números por teclado y que luego
 *    los muestre en orden inverso, es decir, el primero que se
 *    introduce es el último en mostrarse y viceversa.
 *

 */
public class S71Ejercicio03 {

  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
    int[] n = new int[10];
    int i;
    
    System.out.println("Por favor, introduzca 10 números enteros.");
    System.out.println("Pulse la tecla INTRO después de introducir cada número.");

    for (i = 0; i < 10; i++) {
      n[i] = Integer.parseInt(sc.nextLine());
    }
    
    System.out.println("\nLos números introducidos, al revés, son los siguientes:");
    for (i = 9; i >= 0; i--) {
      System.out.println(n[i]);
    }
  }
}
