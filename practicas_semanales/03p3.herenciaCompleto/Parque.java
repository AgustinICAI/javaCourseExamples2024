/**
 @author David Contreras
*/

public abstract class Parque
{
	//Atributos
	String nombre;
	double km;
	int numeroEspecies;

	//Constructor
	
	public Parque(String nombre, double km, int numeroEspecies)
	{
		this.nombre = nombre;
		this.km= km;
		this.numeroEspecies = numeroEspecies;
	}

	//M�todos
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;	
	}

	public double getKm()
	{
		return km;
	}
	
	public void setKm(double km)
	{
		km = km;		
	}

	public int getNumeroEspecies()
	{
		return numeroEspecies;
	}
	
	public void setNumeroEspecies(int numeroEspecies)
	{
	    this.numeroEspecies = numeroEspecies;
	}

	public String getInfo()
	{
	    String s="\nInformaci�n del objeto\n";
	    s += "=====================";
		s += "\nNombre: " + nombre;
		s += "\nExtensi�n: " + km;
		s += "\nEspecies: " + numeroEspecies;
	    return s;
	}
} 
