package menu;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();

        // Agregar algunas opciones al menú
        menu.añadirOpcion("Opción 1");
        menu.añadirOpcion("Opción 2");
        menu.añadirOpcion("Opción 3");

        // Probar el método gestionar
        menu.gestionar();
        
	}

}
