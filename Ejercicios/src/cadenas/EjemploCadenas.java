package cadenas;

public class EjemploCadenas {
	public static void main(String[] args) {
		
		String nombre = "Pepe";
		nombre = new String("Pepe");
		
		String pruebaConstructorVacio = new String();
		pruebaConstructorVacio = "";
		
		nombre.concat(" Garcia");
		
		nombre = nombre + " García";
		
		String frase;
		int cantidad = 20;
		frase = nombre + " tiene " + cantidad +" años"; //Pepe tiene 20 años
		frase = nombre + " tiene " + cantidad + 5 +" años"; //Pepe tiene 205 años
		frase = nombre + " tiene " + (cantidad + 5) +" años"; //Pepe tiene 25 años
		frase = nombre + " tiene " + 15 + 5 +" años"; //Pepe tiene 155 años
		frase = nombre + " tiene " + (15 + 5) +" años"; //Pepe tiene 20 años
		frase = nombre + " tiene " + (15 - 5) +" años"; //Pepe tiene 10 años
		frase = nombre + " tiene " + (15 - 5) +" años"; //ERROR
		frase = 15 + 5 + nombre; //20Pepe
		frase = 5 - 15 + nombre; //-10Pepe
		frase = 5 - 10 + nombre + 5 + 10 + (5 + 5); //-5Pepe51010
		
		int cantidad1 = 10;
		int precio = 50;
		float num = 2.5f;
		float num2 = 10f;
		String s1 = "El total es "+(cantidad1+precio); //El total es 60
		String s2 = "El total es "+cantidad1*precio; //El total es 500
		String s3 = "El total es "+cantidad1+precio; //El total es 1050
		String s4 = ""+ cantidad1+precio; //ERROR
		String s5 = "" + cantidad1*precio; //ERROR
		String s6 = ""+ (cantidad1+precio); //ERROR
		String s7 = ""+cantidad1+precio; //1050
		String s8 = ""+(cantidad1+precio); //60
		String s9 = "El total es "+(cantidad1+num); //El total es 12.5
		String s10 = "El total es "+(cantidad1/3); //El total es 3
		String s11 = "El total es "+(num2/3); //El total es 3.3333333
		String s12 = "El total es "+(cantidad1/3f); //El total es 3.3333333
		String s13 = "El total es "+(cantidad1/3d); //El total es 3.3333333333333335
	
	
	}

}
