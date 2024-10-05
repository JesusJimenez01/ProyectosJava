package metodos;

import java.util.Arrays;

import matematicas.Varias;

public class InvertirRecursivo {

	public static void main(String[] args) {
		
		 System.out.println(Math.random());
		 System.out.println(Math.random());
		 System.out.println(Math.random());
		 
		 int[] numeros = {1, 2, 3, 4, 5};
		  String resultado = Arrays.toString(numeros);
		  System.out.println(resultado);
		 
		 int numeroInvertido = invertirNumero(1234);;

	        System.out.println("El número invertido es: " + numeroInvertido);
	    }

	    // Método recursivo para invertir un número
	    static int invertirNumero(int num) {
	        if (num < 10) {
	            return num;
	        }

	        int digito = num % 10;
	        int longitud = Varias.digitos(num);

	        //return digito * (int) Math.pow(10, longitud-1) + invertirNumero(num / 10);
	        return digito * (int) Varias.potencia(10, longitud-1) + invertirNumero(num / 10);
	    }
	
	   
	    
	    public void ejemploVarargs(int... argumentos) {
	        // Cuerpo del método
	      }
}
