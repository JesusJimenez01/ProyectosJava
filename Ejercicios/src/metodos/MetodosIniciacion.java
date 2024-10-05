package metodos;
public class MetodosIniciacion {

    public static void main(String[] args) {

        String nom = "Pepe";
        int num = 7;

        saludar(nom);
        System.out.println("\nEl cubo de "+num+" es "+cubo(num)+"\n");
        System.out.println("\n3 X "+num+" = "+mult(3, num)+"\n");
        tablaMult(num);
        mostarParImpar(num);
        menu(num);        
    }

    static void saludar(String nombre)
    {
        System.out.println("\nHola, "+nombre+" qué tal estás??\n"); 
    }

    static int cubo(int n)
    {
        return n*n*n;
    }

    /**
     * Multiplica dos números
     * @param a primer número a multiplicar
     * @param b segundo número a multiplicar
     * @return Resultado de multiplicar a * b
     * @
     */
    static int mult(int a, int b)
    {
        return a*b;
    }

    static void tablaMult(int num)
    {
        System.out.println("\nTABLA DE MULTIPLICAR DEL "+num);
        for (int i = 1; i <= 10; i++) {
            System.out.println(i+" X "+num+" = "+mult(i, num));            
        }
        System.out.println();
    }

    static boolean mostarParImpar(int n)
    {
        boolean par = true;
    	if(n%2 == 0) {
       
             	System.out.println("\n"+n+" es par\n");
             	par = true;
        }
        else 
        {
        	System.out.println("\n"+n+" es impar\n");
        	par = false;
        }
    	return par;
    }

    static void menu(int opciones)
    {
        System.out.println("\nMENÚ PRINCIPAL, selecciona una opción entre 1 y "+opciones);
        for(int i=1;i<opciones;i++)
        {
            System.out.println(i+" - Esta el la opción "+i);
        }
        System.out.println(opciones+" - SALIR\n");
    }
    
}
