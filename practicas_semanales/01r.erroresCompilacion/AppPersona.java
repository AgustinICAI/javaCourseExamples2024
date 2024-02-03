public class AppPersona
{
    public static void main(String args[]) 
    {
        Persona.CIUDAD = "Madrid";
        Persona persona1 = new Persona("Luis", 22);
        System.out.println(persona1.getInfo());
    }
}
