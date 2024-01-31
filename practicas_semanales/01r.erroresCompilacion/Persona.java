//Definición de la clase que construirán futuros objetos del tipo Persona
public class Persona
{
    String CIUDAD; //Todas las personas viven en la misma ciudad
    String nombre;
    int edad;

    public Persona(String a,int b, String c)
    {
        this(a,b);
        CIUDAD = c;
    }

    public Persona(String a, int b)
    {
        nombre = a;
        edad = b;
    }    

    //Métodos
    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String s)
    {
        this.nombre = s;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        if(edad>0 && edad<120)
            this.edad = edad;
    }

    String estadistica()
    {
        return "La mitad de la edad en " + CIUDAD + " es: " + edad/2;
    }

    String getInfo()
    {
    	return "Nombre: " + nombre + "\n Edad: "  + edad + "CIUDAD: " + CIUDAD;
    }

}
