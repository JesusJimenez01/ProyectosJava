package recursividad;

/**
 * Crea un método que obtenga el resultado de elevar un número a otro. Ambos números se
deben pasar como parámetros. Los números deben ser positivos
 */
public class PotenciaRecursiva {
	
	
	public static void main(String[] args) {
		
		final int BASE = 3;
		final int EXP = 2;
		
		//llamada al metodo recursivo
		System.out.print("El número " + BASE+ " elevado a " + EXP + " es igual a " + potencia(BASE, EXP));
	
		
	}
		
	static int potencia(int base, int exp)
	{
		if(exp == 0) return 1;
		else return base * potencia(base, --exp);	
	}
	

}
