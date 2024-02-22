import java.util.Collection ;
import java.util.HashSet;
import java.util.TreeSet;

public class App{

  public static void main(String argv[]){
    Persona p1 = new Persona("Koke","Resurrección","1412-B");
    Persona p2 = new Persona("Jan","Oblak","1413-C");    
    Persona p3 = new Persona("Marcos","Llorente","1414-D");        
    Persona p4 = new Persona("Joao","Felix","1415-E");        
    Persona p6 = new Persona("Álvaro","Negredo","1416-F");  
    Persona p5 = new Persona("Álvaro","Morata","1416-F");  
    Persona p7 = new Persona("Álvaro","Morata","1430-F");  
        
    Collection<Persona> hs = new HashSet<>();
    
    hs.add(p1);
    hs.add(p2);  
    hs.add(p3);
    hs.add(p4);
    hs.add(p5);
    hs.add(p6);
    hs.add(p7);
    //System.out.println(hs);
    for(Persona p : hs)
      System.out.println(p);
    
    System.out.println(hs.contains(new Persona("1416-F")));
    System.out.println(hs.remove(new Persona("1416-F")));    
    System.out.println(hs.remove(new Persona("14188-F")));        
    for(Persona p : hs)
      System.out.println(p);
      
      
    TreeSet<Persona> ts = new TreeSet<>();
    ts.add(p1);
    ts.add(p2);  
    ts.add(p3);
    ts.add(p4);
    ts.add(p5);
    ts.add(p6);    
    ts.add(p7);    
    System.out.println(ts);
          
    
  }



}
