package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabra = sc.nextLine();
		boolean palindromo = true;
		palabra = palabra.trim();
		int longitud = palabra.length() - 1;
		for (int i = 0; i <= longitud / 2; i++) {
			if (palabra.charAt(i) != palabra.charAt(longitud - i)) {
				palindromo = false;
				break;
			}
		}
		System.out.println(palindromo ? "Es un palíndromo":"No es un palíndromo");
		sc.close();
	}

}
