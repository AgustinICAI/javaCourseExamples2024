public class App{

  public static void main(String argv[]){
    Persona p = new Persona("Juan");
    
    Tarjeta t1 = new TarjetaCredito(Tarjeta.TipoTarjeta.VISA,"5555 5555 5555 5555",true,0.02);    
    Tarjeta t2 = new TarjetaDebito(Tarjeta.TipoTarjeta.MASTERCARD,"5555 5555 5555 5555");    
      
    p.addTarjeta(t1);
    p.addTarjeta(t2);
    
    System.out.println(p);    
    
    
    
  }



}
