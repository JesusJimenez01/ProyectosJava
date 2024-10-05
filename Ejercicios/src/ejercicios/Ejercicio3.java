package ejercicios;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String palabra = sc.nextLine();
		String str="";
		for (int i = 0; i < palabra.length(); i++) {
			str=str+palabra.charAt(i)+" ";
		}
		str=str.trim();
		System.out.println(str);
		sc.close();
	}

}
