import java.util.ArrayList;

public class Agenda
{
    //private ArrayList personas;
    private ArrayList<Persona> personas;
    private String nombre;

    public Agenda(String nombre)
    {
    	this.nombre = nombre;
    	personas = new ArrayList<Persona>();
    }

    public String getNombre()
    {
    	return nombre;
    }

    public int size()
    {
    	return personas.size();
    }    

    public boolean isFull()
    {
    	return false;
    }    

    public boolean add(Persona persona)
    {
        personas.add(persona);
		return true;
	}

	public Persona get(int posicion)
    {
        //Persona p = (Persona) personas.get(posicion);
    	return personas.get(posicion);
	}


	public boolean contains(Persona persona)
    {
    	return personas.contains(persona);
	}

	public int indexOf(Persona persona)
    {
    	return personas.indexOf(persona);
	}

    public boolean remove(Persona persona)
    {
        return personas.remove(persona);
    }  

    public Persona remove(int posicion)
    {
        if (posicion >= 0 && posicion < personas.size())
            return personas.remove(posicion);
        else
            return null;
    }   

	public String toString()
    {
    	StringBuilder sb = new StringBuilder();
        for(Persona p:personas)
            sb.append(p + "\n");
        return sb.toString();
        //return personas.toString();
    }    
    
}
