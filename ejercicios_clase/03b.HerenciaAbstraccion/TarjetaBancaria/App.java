import java.time.LocalDate;

class App{

  public static void main(String argv[]){
    
    System.out.println("LIMITE DE SALTO DE TODAS LAS TARJETAS ES: "+ TarjetaCredito.LIMITE_SALDO);    
    
    TarjetaDebito t1 = new TarjetaDebito("5555 5555 5555 5555");    

    Tarjeta t4 = new TarjetaDebito("5555 5555 5555 5555");    
    
    TarjetaCredito t2 = new TarjetaCredito("5555 5555 5555 5555",true,0.25);
    
    int i1 = t1.getPin();    
    System.out.println(i1);
    System.out.println(t2.getPin());  
    
    //UPCASTING
    Tarjeta t3 = new TarjetaCredito("5555 5555 5555 5555",false,0.25);
        

    
    
    Tarjeta[] tarjetas = new Tarjeta[20];
    tarjetas[0] = t1;
    tarjetas[1] = t2;
    tarjetas[2] = t3;
    
    
    
    
    boolean permitido = TarjetaCredito.validarImporteMovimientoSinPIN(45);
    System.out.println("operacion permitida sin pin: " + permitido); 
    
    
    Movimiento m1 = new Movimiento("Cafeteria ICAI", 2, LocalDate.of(2024,1,22) );
    Movimiento m2 = new Movimiento("Cafeteria ICAI", 4.5, LocalDate.parse("2024-01-22"));    
    Movimiento m3 = new Movimiento("Cafeteria ICAI", 7, LocalDate.of(2024,1,22)); 
    
    t1.pagar(m1);
    t1.pagar(m2);
    t1.pagar(m3);
    
    System.out.println(t2.pagar(m1, 1234));
    System.out.println(t2.pagar(m2, 1234));
    System.out.println(t2.pagar(m3, t2.getPin()));
    
    
    
    for(Tarjeta t : tarjetas)
      if(t !=null){
        System.out.println(t);

        if (t instanceof TarjetaCredito){
          //DownCASTING  
          TarjetaCredito tc = (TarjetaCredito) t;
          if(tc.isRevolving())      
            System.out.println("CUIDADO QUE ES REVOLVING!!!!");
        
        }
        
      }
    

  }



}
