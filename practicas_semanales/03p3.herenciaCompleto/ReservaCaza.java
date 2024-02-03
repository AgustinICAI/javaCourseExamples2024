/**
 @author David Contreras
*/

public class ReservaCaza extends Parque
{
	//Atributos

	double coste;
	String arma;

	//Constructores

	public ReservaCaza(String nombre, double km, int numeroEspecies, double coste, String arma)
	{
		super(nombre, km, numeroEspecies);
		this.coste = coste;	
		this.arma = arma;
	}

	//Metodos
	public double getCoste()
	{
		return coste;
	}
	
	public void setCoste(double coste)
	{
		this.coste = coste;		
	}

	public String getArma()
	{
		return arma;
	}
	
	public void setArma(String arma)
	{
		this.arma = arma;	
	}

	@Override
	public String getInfo()
	{
	    String s= super.getInfo();
		s += "\nCoste: " + coste;
		s += "\nArma: " + arma;
	    return s;	    
	}
	
} 
