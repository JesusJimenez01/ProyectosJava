package cadenas;

public class EjemploStringBuilder {
	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder ("abcdef");
		str.insert (3, "xyz"); // str = "abcxyzdef"
		str.insert (6, 1.23); // str = "abcxyz1.23def"
		
		System.out.print(str.toString());
		
		String strHola = "Hola, ";
		String strMundo = "mundo";
		String str1 = strHola + strMundo;
		
		StringBuilder strBd = new StringBuilder();
		strBd.append("Hola, ");
		strBd.append("mundo");
		String strCompleta = strBd.toString();
		
		StringBuffer strBff = new StringBuffer();
		strBff.append("Hola, ");
		strBff.append("mundo");
		String strCompleta1 = strBff.toString();
		
		
		String pruebaComillas = 
				"""
				adasdsad
				sadasdsad
				sadsadsad
				sadasdsad
				sadsadsad
				sadasdas
				
				""";
		System.out.print(""" 
				sdasd
				sadsadsa
				sadasdas
				sadas
				""");
	}

}
