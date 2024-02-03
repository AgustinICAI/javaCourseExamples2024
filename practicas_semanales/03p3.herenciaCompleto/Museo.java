/**
 @author David Contreras
*/

public class Museo implements Visitable
{
	//Atributos
	String nombre;
	String direccion;
	double precio;

	//Constructor
	public Museo(String nombre, String direccion, double precio)
	{
		this.nombre = nombre;
		this.direccion = direccion;
		this.precio = precio;
	}

	//Getters y setter
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;	
	}

	public String getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(String direccion)
	{
		this.direccion = direccion;	
	}

	public double getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(double precio)
	{
		this.precio = precio;		
	}

	@Override
    public String visitar(String guia)
    {
        return "Visitando museo " + nombre + " con el/la guía " + guia + " a un coste de " + precio;
    }

	public String getInfo()
	{
	    String s="\nInformación del museo\n";
	    s += "=====================";
		s += "\nNombre: " + nombre;
		s += "\nDirección: " + direccion;
		s += "\nPrecio: " + precio;
	    return s;
	}
} 
