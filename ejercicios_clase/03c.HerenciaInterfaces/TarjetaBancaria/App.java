import java.time.LocalDate;

class App{

  public static void main(String argv[]){
    
    System.out.println("LIMITE DE SALTO DE TODAS LAS TARJETAS ES: "+ TarjetaCredito.LIMITE_SALDO);    
    
    TarjetaDebito t1 = new TarjetaDebito("5555 5555 5555 5555");    
    
    SubscribleFinDeMes[] productosFinDeMes = new SubscribleFinDeMes[5];
    
    productosFinDeMes[0] = t1;
    productosFinDeMes[1] = new Seguro("seguro muy chulo",2313);

    
    
  }



}
