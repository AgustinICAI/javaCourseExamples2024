import java.time.LocalDate;

class App2{

  public static void main(String argv[]){
    
    Persona p1 = new Persona("Juan");
    Persona p2 = new Persona("Paco");
    Persona p3 = new Persona("Juan");    
    
    System.out.println(p1==p2);
    
    System.out.println(p1==p3);
    
    System.out.println(p1.equals(p3));
    
    
  }



}
