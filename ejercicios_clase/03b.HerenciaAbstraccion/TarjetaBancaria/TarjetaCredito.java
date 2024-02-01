import java.util.Random;

class TarjetaCredito extends Tarjeta{

  static int NUM_MESES_FINANCIACION = 3;
  boolean revolving;
  double tasaInteres;
  
  TarjetaCredito(String numeroTarjeta, boolean revolving, double tasaInteres){
    super(numeroTarjeta);
    this.revolving = revolving;
    this.tasaInteres = tasaInteres;
  }
  
  double getLimiteOperacionOffline(){
    return 500;
  }
    
  
  boolean isRevolving(){
    return revolving;
  }
  
  double getTasaInteres(){
    return tasaInteres;
  }
  
  public String toString(){
    
    String cad = "\n---> TARJETA CREDITO - revolving: ";
    
    if(revolving)
      cad += "sí";
    else
      cad += "no";
    //PENDIENTE ENSEÑAR COMO HACER LO ANTERIOR EN UNA LINEA CON FORMATO CONDICIONAL
    cad += "\n" + super.toString();
    return cad;
  }
  
}



