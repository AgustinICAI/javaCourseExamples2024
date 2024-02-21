public class App
{
    private static Agenda agenda = new Agenda("AGENDA");

    public static void main(String[] args)
    {
        int opcion=0;

        do
        {
            opcion = App.menu(agenda.getNombre());
            App.limpiar();
            App.evaluar(opcion);
            App.limpiar();            
        }while(opcion!=9);

    }

    static int menu(String nombre)
    {
        System.out.println("################################");
        System.out.println("#####        " +  nombre + "      #######");
        System.out.println("################################");
        System.out.println("###  1. Crear persona       ####");
        System.out.println("###  2. Buscar persona      ####");
        System.out.println("###  3. Eliminar persona    ####");
        System.out.println("###  4. Modificar persona   ####");
        System.out.println("###  5. Mostrar lista       ####");
        System.out.println("################################");
        System.out.println("###  9. SALIR               ####");
        System.out.println("################################");
        System.out.print("  > ");
        int opc = Integer.parseInt(Leer.porTeclado());
        return opc;
    }
    
    static void evaluar(int x)
    {
    	String nombre = "";
        String nif = "";
    	int edad = 0;
        switch(x)
        {
        	case 1:
        	    System.out.println("*** NUEVA PERSONA ***");
        	    if(!agenda.isFull())
        	    {
	        	    System.out.println("Datos de la persona");
	        	    System.out.print("Nombre: ");
	        	    nombre = Leer.porTeclado();
                    System.out.print("NIF: ");
                    nif = Leer.porTeclado();
	        	    System.out.print("Edad: ");
	                edad = Integer.parseInt(Leer.porTeclado());
	        	    agenda.add(new Persona(nombre, nif, edad));
    		     }
    		     else
    		     {
    			    System.out.println("No se pueden añadir mas personas. Array lleno");
                    System.out.print("Pulse enter para continuar...");
                    Leer.porTeclado();        	        				    
    		     }
	        	   
        	    break;
        	case 2:
        	    System.out.println("*** BUSCAR PERSONA ***");        	    
        	    System.out.println("Datos de la persona");
        	    System.out.print("NIF: ");
        	    nif = Leer.porTeclado();
                int pos = agenda.indexOf(new Persona(nif));
                if (pos != -1)
                    System.out.print("Encontrado en la posición " + pos);
                else
                    System.out.print("No encontrado");

                System.out.print("\nPulse enter para continuar...");
                Leer.porTeclado();        	        
        	    break;
        	case 3:
        	    System.out.println("*** ELIMINAR PERSONA ***");        	    
                pos = App.mostrarPersonasElegirPosicion();
                agenda.remove(pos);

        	    System.out.print("Objeto borrado");
        	    System.out.print("\nPulse enter para continuar...");
                Leer.porTeclado();        	                	    
        	    break;
        	case 4:
        	    System.out.println("*** MODIFICAR PERSONA ***");        	    
                pos = App.mostrarPersonasElegirPosicion();
                Persona p = agenda.get(pos);
                if(p!=null)
                {
            	    System.out.print("\nIntroduzca la nueva edad: ");
                    edad = Integer.parseInt(Leer.porTeclado());
                    p.setEdad(edad);
                }
                else
                    System.out.print("\nPersona no encontrada");
        	    break;
        	case 5:
        	    System.out.print(agenda.toString());
        	    System.out.print("\nPulse enter para continuar...");
                Leer.porTeclado();        	        
        	    break;
        	case 9:
        	    break;
        	default:
        }
    }
    
    private static void limpiar()
    {
	    for(int i=0;i<25;i++)
           	 System.out.println();
    }
    
    private static int mostrarPersonasElegirPosicion()
    {
        System.out.println("Posición de la persona a modificar: ");
        System.out.print(agenda);
        System.out.print("  > ");
        int pos = Integer.parseInt(Leer.porTeclado());
        return pos;
    }    

}
