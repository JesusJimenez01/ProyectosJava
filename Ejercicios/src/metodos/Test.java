package metodos;

public class Test {

	public static void main(String[] args) {
		
		///System.out.print(Varias.voltea(1234));
		
	//System.out.print(Varias.esCapicua(1234));
		
		//System.out.print(Varias.siguientePrimo(5));
		
		int altura = 3;
		
		//triangulo(3);
		//trianguloRecursivo(0,0,altura);
		
		trianguloRecursivoV2(altura);
		
	}
	
	static void trianguloRecursivo (int contB, int contA, int n)
	{
		if(contB < contA) {
			System.out.print("*");
			trianguloRecursivo(contB + 1 , contA, n);
		}
		else {
			System.out.println();
			if (contA < n) 
				trianguloRecursivo(0, contA + 1, n);
		}
	}
	
	
	static void trianguloRecursivoV2 (int altura) {
		
		if (altura>0)
		{
			trianguloRecursivoV2(altura - 1);
			filaTriangulo(altura);
		}
	}
	
	static void filaTriangulo (int n) {
		if (n>0) {
			System.out.print("*");
			filaTriangulo(n - 1);
		}
		else
			System.out.println();
		
	}
	
	
	
	 static void triangulo(int tamano) {
			
		for (int i = 0; i <= tamano; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	static int factorial(int n) {
		int resultado;
		if(n == 0) 
			return 1; //caso base
		else 
			resultado = n*factorial(n-1); //caso general
			
		return resultado;
		}

}
