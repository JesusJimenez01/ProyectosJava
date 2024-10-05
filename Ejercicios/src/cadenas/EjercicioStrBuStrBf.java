package cadenas;

public class EjercicioStrBuStrBf {

	public static void main(String[] args) {

		// Ejercicio con StringBuilder
		System.out.println("*** Ejercicio con StringBuilder ***\n");
		StringBuilder sbuilder = new StringBuilder("Hola Caracola");
		int i = 5000;
		String cincok = "";
		System.out.println("El StringBuilder es : " + sbuilder);
		System.out.println("Capacidad inicial = " + sbuilder.capacity());
		System.out.println("Longitud inicial = " + sbuilder.length());
		sbuilder.delete(0, 4);
		sbuilder.insert(0, "Hay");
		sbuilder.append("s");
		System.out.println(sbuilder);
		cincok = " " + Integer.toString(i);
		sbuilder.insert(3, cincok);
		System.out.println(sbuilder);
		sbuilder.append(" en el mar");
		System.out.println(sbuilder);
		System.out.println(sbuilder.substring(sbuilder.length() - 4, sbuilder.length()));
		System.out.println("Capacidad final = " + sbuilder.capacity());
		System.out.println("Longitud final = " + sbuilder.length());

		// Ejercicio con StringBuffer
		System.out.println();
		System.out.println();
		System.out.println("*** Ejercicio con StringBuffer ***\n");

		StringBuffer sbuffer = new StringBuffer("Hola Caracola");
		i = 5000;
		cincok = "";
		System.out.println("El StringBuilder es : " + sbuffer);
		System.out.println("Capacidad inicial = " + sbuffer.capacity());
		System.out.println("Longitud inicial = " + sbuffer.length());
		sbuffer.delete(0, 4);
		sbuffer.insert(0, "Hay");
		sbuffer.append("s");
		System.out.println(sbuffer);
		cincok = " " + Integer.toString(i);
		sbuffer.insert(3, cincok);
		System.out.println(sbuffer);
		sbuffer.append(" en el mar");
		System.out.println(sbuffer);
		System.out.println(sbuffer.substring(sbuffer.length() - 4, sbuffer.length()));
		System.out.println("Capacidad final = " + sbuffer.capacity());
		System.out.println("Longitud final = " + sbuffer.length());

	}

}
