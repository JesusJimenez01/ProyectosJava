package Math;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Por favor, indique la capacidad de la cuba en litros: ");
	    int capacidad = Integer.parseInt(sc.nextLine());

	    System.out.println();
		
	    // Rellena la cuba con unos litros aleatorios
	    // teniendo en cuenta no pasarse de la capacidad.
	    int litros = (int)(Math.random() * (capacidad));
	    
	    for (int i = 0; i < capacidad; i++) {
	    	
	    	if (i < capacidad - litros)
	    		System.out.println("*    *"); 	
	    	else
	    		System.out.println("*====*");
	    }
	    System.out.println("******"); //base
	    System.out.print("la cuba tiene una capacidad de " + capacidad); 
	    System.out.print(" litros y tiene  " + litros + " litros de agua"); 
	    sc.close();
	}
	
}
