import java.time.LocalDate;

class App{

  public static void main(String argv[]){
    
    System.out.println("LIMITE DE SALTO DE TODAS LAS TARJETAS ES: "+ TarjetaCredito.LIMITE_SALDO);    
    
    
    TarjetaCredito t1 = new TarjetaCredito();
    t1.setSaldo(2000);
    t1.setNumeroTarjeta("1111 2222 3333 4444");
    t1.setPin(1234);
    t1.setCvv(333);
    t1.setPinActivacion(1111);
    
    TarjetaCredito t2 = new TarjetaCredito("5555 5555 5555 5555");
    
    int i1 = t1.getPin();    
    System.out.println(i1);
    System.out.println(t2.getPin());  
    
    TarjetaCredito[] tarjetasCredito = new TarjetaCredito[10];
    tarjetasCredito[0] = t1;
    tarjetasCredito[1] = t2;
    
    boolean permitido = TarjetaCredito.validarImporteMovimientoSinPIN(45);
    System.out.println("operacion permitida sin pin: " + permitido); 
    
    Movimiento m1 = new Movimiento("Cafeteria ICAI", 2, LocalDate.of(2024,1,22) );
    Movimiento m2 = new Movimiento("Cafeteria ICAI", 4.5, LocalDate.parse("2024-01-22"));    
    Movimiento m3 = new Movimiento("Cafeteria ICAI", 7, LocalDate.of(2024,1,22)); 
    
    t1.pagar(m1, 1234);
    t1.pagar(m2, 1234);
    t1.pagar(m3, 1234);
    
    System.out.println(t2.pagar(m1, 1234));
    System.out.println(t2.pagar(m2, 1234));
    System.out.println(t2.pagar(m3, t2.getPin()));
    
    System.out.println("Saldo t1: " + t1.getSaldo());
    System.out.println("Saldo t2: " + t2.getSaldo()); 
    
    System.out.println(t1.toString());          
    System.out.println(t2.toString());
    
    
    

  }



}
