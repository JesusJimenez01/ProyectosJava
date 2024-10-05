package recursividad;

import matematicas.Varias;

public class InvertirRecusivo {
	
	

	public static void main(String[] args) {
		
		//invertir(1234);
		System.out.print(invertir2(1234));
		
	}

	/**
	 * método que dado un número positivo, lo imprima invertido por pantalla
	 * @param n número positivo a invertir
	 */
	static void invertir(int n) {
		
		if(n < 10) System.out.print(n);
		else {
			System.out.print(n%10);
			invertir(n/10);
		}
	}
	
	/**
	 * método que dado un número positivo, lo devuelva invertido
	 * @param n número positivo a invertir
	 * @return número invertido
	 */
	static int invertir2(int n) {
		
		if(n < 10) return n;
		else {
			
			int digito = n % 10;
			int longitud = Varias.digitos(n); 
			
			return digito * (int) Varias.potencia(10, longitud-1) + invertir2(n/10);
		}
	}
}
