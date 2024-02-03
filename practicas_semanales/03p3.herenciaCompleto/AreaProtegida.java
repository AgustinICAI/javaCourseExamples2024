/**
 @author David Contreras
*/

public class AreaProtegida extends Parque implements Visitable
{
	//Atributos

	double subvencion;
	String ong;

	//Constructores

	public AreaProtegida(String nombre, double km, int numeroEspecies, double subvencion, String ong)
	{
		super(nombre, km, numeroEspecies);
		this.subvencion = subvencion;	
		this.ong = ong;
	}

	//Metodos
	public double getSubvencion()
	{
		return subvencion;
	}
	
	public void setSubvencion(double subvencion)
	{
		this.subvencion = subvencion;		
	}

	public String getOng()
	{
		return ong;
	}
	
	public void setOng(String ong)
	{
		this.ong = ong;	
	}

	@Override
	public String getInfo()
	{
	    String s= super.getInfo();
		s += "\nSubvención: " + subvencion;
		s += "\nONG: " + ong;
	    return s;	
	}
	
	@Override
    public String visitar(String guia)
    {
        return "Visitando área " + nombre + " con el/la guía " + guia;
    }
		
} 
