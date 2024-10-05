package ejercicios.departamento;

public class Departamento {

    // Propiedades
    private int numDep;
    private String nombreDep;
    private String localidad;
   
    // Constructor
    public Departamento(int numDep, String nombreDep, String localidad){
         this.numDep = numDep;
         this.nombreDep = nombreDep;
         this.localidad = localidad;
    }
   
    public Departamento(){}
   
    // Métodos
    public void setNumDep(int n){
         numDep = n;
    }
   
    public int getNumDep(){
         return numDep;
    }
   
    public void setNombreDep(String n){
         nombreDep = n;
    }
   
    public String getNombreDep(){
         return nombreDep;
    }
   
    public void setLocalidad(String n){
         localidad = n;
    }
   
    public String getLocalidad(){
         return localidad;
    }

	@Override
	public String toString() {
		return "Departamento [numDep=" + numDep + ", nombreDep=" + nombreDep + ", localidad=" + localidad + "]";
	}
    
    
}