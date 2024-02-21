public class Agenda
{
    public final static int NUMERO_MAX_PERSONAS = 10;
    private Persona personas[];
    private String nombre;
    private int size;

    public Agenda(String nombre)
    {
    	size = 0;
    	this.nombre = nombre;
    	personas = new Persona[NUMERO_MAX_PERSONAS];
    }

    public String getNombre()
    {
    	return nombre;
    }

    public int size()
    {
    	return size;
    }    

    public boolean isFull()
    {
    	return size==NUMERO_MAX_PERSONAS;
    }    

    public boolean add(Persona persona)
    {
    	if(size < NUMERO_MAX_PERSONAS)
    	{
    		personas[size++] = persona;
    		return true;
    	}
    	else
    		return false;
	}

	public Persona get(int posicion)
    {
    	if(posicion<size)
	    	return personas[posicion];
	    else
	    	return null;
	}


	public boolean contains(Persona persona)
    {
    	return this.buscar(persona)!=-1;
	}

	public int indexOf(Persona persona)
    {
    	return this.buscar(persona);
	}

	private int buscar(Persona persona)
    {
        int pos = -1;
	    for(int i=0;i<size;i++)
	    {
	        if(personas[i]!=null && personas[i].equals(persona))
            {
                pos = i;
                i = size;
            }
	    }
	    return pos;
    }    

    public boolean remove(int posicion)
    {
    	if(posicion<size)
    	{
    		personas[posicion] = null;
    		for(int i=posicion;i<size-1;i++)
            	personas[i] = personas[i+1];
            personas[--size] = null;
            return true;
	    }
	    else
	    	return false;
    }

    public boolean remove(Persona persona)
    {
    	int posicion = this.indexOf(persona);	
    	return this.remove(posicion);
    }    

	public String toString()
    {
    	StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++)
            sb.append(String.valueOf(i) + ".- " + personas[i] + "\n");
        return sb.toString();
    }    
    
}
