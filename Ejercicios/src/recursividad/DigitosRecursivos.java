package recursividad;

public class DigitosRecursivos {

	public static void main(String[] args) {
	
	final int NUM = 100;
	//llamada a metodo recursivo
	
	int digito = digitos(NUM);
	
	System.out.println("El número " + NUM + " tiene " + digito + " digito" + (digito >1 ? "s." : "."));
	
	}
		
	/**
	 * método que obtiene la cantidad de dígitos de un número N mayor que cero.
	 * @param n número para obtener la cantidad de dígitos de un número
	 * @return cantidad de dígitos que tiene el nuemro n
	 */
	static int digitos(int n) {
	
		if (n == 0)//caso base
		{
			return 0;
		}
		else //caso general 
		{
			return 1 + digitos(n/10);	
		}
		 
	}
	
	

}
