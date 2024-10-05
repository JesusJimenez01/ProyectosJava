package Math;

public class EjemploMath {
	
	public static void main(String[] args) {
		int n = 2;
		System.out.println(Math.pow(n,8)); //256.0
		double radio = 5, area;
		area = Math.PI * radio * radio; //78.53981633974483
		area = Math.PI*Math.pow(radio, 2); //78.53981633974483
		System.out.println(Math.ceil(area)); //79.0
		System.out.println(Math.floor(area)); //78.0
		System.out.println(Math.round(area)); //79
		System.out.println(Math.sqrt(area*area)); //78.53981633974483
		System.out.println(Math.sqrt(Math.pow(n,4))); //4.0
		
		System.out.println("Diez números aleatorios:\n");
		for (int i = 1; i < 11; i++) {
		System.out.println(Math.random());
		
		}
		
		System.out.println("Diez números aleatorios entre 0 y 10:\n");
		for (int i = 1; i < 11; i++) {
		System.out.println((Math.random())*10);
				}
		
		System.out.println("Diez números aleatorio entre 0 y 9 sin decimales s:\n");
		for (int i = 1; i < 11; i++) {
		
		System.out.println((int)(Math.random()*10));
		}
		
		System.out.println("Diez números aleatorio entre 50 y 60 sin decimales s:\n");
		for (int i = 1; i < 11; i++) {
		
		System.out.println((int)(Math.random()*11)+50);
		}
		
		
		System.out.println("Generar palabras aleatorias:\n");
		
		int codPalabra= (int)(Math.random()*7);
		
		switch (codPalabra) {
		case 0: {
			System.out.println("Lunes\n");
			break;
		}
		case 1: {
			System.out.println("Martes\n");
			break;
		}
		case 2: {
			System.out.println("Miercoles\n");
			break;
		}
		case 3: {
			System.out.println("Jueves\n");
			break;
		}
		case 4: {
			System.out.println("Viernes\n");
			break;
		}
		case 5: {
			System.out.println("Sábado\n");
			break;
		}
		case 6: {
			System.out.println("Domingo\n");
			break;
		}
		default:
			
		}
		
		
		
	}

}
