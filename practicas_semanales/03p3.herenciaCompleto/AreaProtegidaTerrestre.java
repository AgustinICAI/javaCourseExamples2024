/**
 @author David Contreras
*/

public class AreaProtegidaTerrestre extends AreaProtegida
{
	//Atributos
	String terreno;

	//Constructores
	public AreaProtegidaTerrestre(String nombre, double km, int numeroEspecies, double subvencion, String ong, String terreno)
	{
		super(nombre, km, numeroEspecies, subvencion, ong);
		this.terreno = terreno;
	}

	//Metodos
	public String getTerreno()
	{
		return terreno;
	}
	
	public void setTerreno(String terreno)
	{
		this.terreno = terreno;		
	}

	@Override
	public String getInfo()
	{
	    String s= super.getInfo();
		s += "\nTipo de Terreno: " + terreno;
	    return s;
	}
	
} 
