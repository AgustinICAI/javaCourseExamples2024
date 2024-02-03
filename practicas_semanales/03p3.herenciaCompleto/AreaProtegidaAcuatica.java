/**
 @author David Contreras
*/

public class AreaProtegidaAcuatica extends AreaProtegida
{
	//Atributos
	int numeroLagos;

	//Constructores
	public AreaProtegidaAcuatica(String nombre, double km, int numeroEspecies, double subvencion, String ong, int numeroLagos)
	{
		super(nombre, km, numeroEspecies, subvencion, ong);
		this.numeroLagos = numeroLagos;
	}

	//Metodos
	public int getNumeroLagos()
	{
		return numeroLagos;
	}
	
	public void setNumeroLagos(int numeroLagos)
	{
	    this.numeroLagos = numeroLagos;		
	}

	@Override
	public String getInfo()
	{
	    String s= super.getInfo();
		s += "\nNumero de Lagos: " + numeroLagos;
	    return s;	
	}
} 
