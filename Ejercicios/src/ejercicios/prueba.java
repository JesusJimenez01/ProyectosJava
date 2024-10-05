package ejercicios;

public class prueba {

	public static void main(String[] args) {	
		String str = "hola";
		StringBuilder ejemplo = new StringBuilder(str);
		System.out.println(ejemplo.reverse());
		System.out.println(factorial(7));
		System.out.println(potencia(2, 3));
		System.out.println(longitud(234));
			for (int i = 0; i < 10; i++) {
				System.out.print((int)(Math.random()*201+200) + (i<9 ? ", " : ""));
			}
	}
	
	static void timer(int n) {
		if (n==0) {
			System.out.println(0);
		} else {
			System.out.println(n);
			timer(n-1);
		}
	}
	
	static int factorial(int n) {
		if (n==0) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
	static int potencia(int n, int e) {
		if (e==0) {
			return 1;
		}  else {
			return n * potencia(n, e-1);
		}
	}
	
	static int longitud(int n) {
		if (n<10) {
			return n;
		} else {
			return (n%10)+longitud(n/10);
		}
	}

}
