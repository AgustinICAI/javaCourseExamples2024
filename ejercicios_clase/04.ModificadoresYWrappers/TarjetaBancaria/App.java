import java.time.LocalDate;

class App{

  public static void main(String argv[]){
    
    System.out.println("LIMITE DE SALTO DE TODAS LAS TARJETAS ES: "+ TarjetaCredito.LIMITE_SALDO);    
    
    Tarjeta t1 = new TarjetaCredito(TipoTarjeta.VISA,"5555 5555 5555 5555",true,0.02);    
    Tarjeta t2 = new TarjetaDebito(TipoTarjeta.MASTERCARD,"5555 5555 5555 5555");    
    
    SubscribleFinDeMes[] productosFinDeMes = new SubscribleFinDeMes[5];
    
    productosFinDeMes[0] = (TarjetaCredito)t1;
    productosFinDeMes[1] = new Seguro("seguro muy chulo",2313);
  
    for(SubscribleFinDeMes s : productosFinDeMes)
      System.out.println(s);
    
    
  }



}
