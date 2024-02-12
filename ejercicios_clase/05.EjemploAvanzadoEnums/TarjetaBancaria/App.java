import java.time.LocalDate;

class App{

  public static void main(String argv[]){
    for(Tarjeta.TipoTarjeta tt : Tarjeta.TipoTarjeta.values()){
      System.out.println(tt);  
    }
        
    for(TipoCliente tc : TipoCliente.values()){
      System.out.println(tc);  
    }
    
    TipoCliente tc = TipoCliente.PLATINO;
    
    int puntuacion = tc.getPuntuacion();
    
    TipoCliente tc1 = TipoCliente.valueOf("PLATINO");
    
    System.out.println("-<<<"+tc1);
    
    
  }



}
