package Math;

import java.util.Scanner;

public class Ejercicio24 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Por favor, indique numero entero positivo: ");
	    long numIntroducido = Long.parseLong(sc.nextLine());
	    
	    long numero = numIntroducido;
	    long longitud = 0; //almacenar la longitud del numero
	    
	    do 
	    {
	    	numero /= 10;
	    	longitud ++;
	    }while(numero > 0);
	    
	    int posicion = (int) (Math.random() * longitud) +1; //elegir la posicion
	    
	 // extrae el dígito de esa posición
	    System.out.println((numIntroducido / (long)(Math.pow(10, longitud - posicion))) % 10);
	    
	    sc.close();
	    
	}

}
