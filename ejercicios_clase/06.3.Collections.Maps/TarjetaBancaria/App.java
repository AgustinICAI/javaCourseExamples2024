import java.util.*;
import java.time.LocalDate;

public class App{

  public static void main(String argv[]){
    
    
    HashMap<Persona,Movimiento> hmPersonaMovimiento = new HashMap<>();
    
    
    hmPersonaMovimiento.put(new Persona("Juan","Perez","3122"),new Movimiento("Cafeteria ICAI", 2, LocalDate.of(2024,1,22)));
    hmPersonaMovimiento.put(new Persona("Paco","Perez","3123"),new Movimiento("Cafeteria ICAI", 4.5, LocalDate.parse("2024-01-22")));    
    hmPersonaMovimiento.put(new Persona("Álvaro","Morata","3124"),new Movimiento("Cafeteria ICAI", 4.5, LocalDate.parse("2024-01-22")));    
    
    System.out.println( hmPersonaMovimiento );
    
    for(Map.Entry<Persona,Movimiento> e :  hmPersonaMovimiento.entrySet())
      System.out.println(e.getKey() + " ->MOVIMIENTO: " + e.getValue());

    for(Persona p : hmPersonaMovimiento.keySet())
      System.out.println(p);
    
    for(Movimiento m : hmPersonaMovimiento.values())
      System.out.println(m);
      
    hmPersonaMovimiento.remove(new Persona("3123"));
    System.out.println( hmPersonaMovimiento );
    

    hmPersonaMovimiento.forEach( (k,v) -> {
      System.out.println(k + " ->MOVIMIENTO: " + v ); 
    }); 
    
    hmPersonaMovimiento.values().forEach( m -> System.out.println(m));
      
    
    
    HashMap<Persona,Collection<Movimiento>> hmPersonaMovimientos = new HashMap<>();
    
    Persona p = new Persona("Juan","Perez","3122");
    Movimiento m1 = new Movimiento("Cafeteria ICAI", 2, LocalDate.of(2024,1,22));
    Movimiento m2 = new Movimiento("Cafeteria ICAI", 2, LocalDate.of(2024,1,22));
        
    if(! hmPersonaMovimientos.containsKey(p))
      hmPersonaMovimientos.put(p, new ArrayList<>());
      
    hmPersonaMovimientos.get(p).add(m1);
    hmPersonaMovimientos.get(p).add(m2);
    
    System.out.println(hmPersonaMovimientos);
    
  }



}
