package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int contador=0;
		System.out.print("Escribe una cadena de texto: ");
		String txt = sc.nextLine();
		txt=txt.trim();
		for (int i = 0; i < txt.length(); i++) {
			if (txt.charAt(i)!=' ') {
				contador++;
				while (i<txt.length() && txt.charAt(i)!=' ') {
					i++;
				}
			}
		}
		System.out.println("La cadena tiene "+contador+" palabras");
		sc.close();
	}

}
