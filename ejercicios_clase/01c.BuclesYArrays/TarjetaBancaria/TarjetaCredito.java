import java.util.Random;

class TarjetaCredito{
  
  String numeroTarjeta;
  int pin;
  int cvv;
  double saldo;
  Movimiento[] movimientos;
  int pinActivacion;
  boolean tarjetaActiva;
  int ultimoMovimiento;
  //ESTE NO HARÍA FALTA DEFINIRLO SINO HUBIERA MÁS CONSTRUCTORES
  TarjetaCredito(){
    movimientos = new Movimiento[1000];
  }
  
  TarjetaCredito(String numeroTarjeta){
    this.numeroTarjeta = numeroTarjeta;
    // setNumeroTarjeta(numeroTarjeta);
    Random random = new Random();
    pin = random.nextInt(10000);
    cvv = random.nextInt(1000);
    saldo = 2000;
    movimientos = new Movimiento[1000];
    pinActivacion = random.nextInt(10000);
    tarjetaActiva = false;
    ultimoMovimiento = 0;
  }
  
  void setSaldo(int saldo){
    this.saldo = saldo;
  }
  
  double getSaldo(){
    return saldo;
  }
  
  boolean activarTarjeta(int pinActivacion){
    if(this.pinActivacion == pinActivacion)
      tarjetaActiva = true;
    
    return tarjetaActiva;
  }
   
  boolean pagar(Movimiento movimiento, int pin){
    if(this.pin == pin){
      saldo = saldo - movimiento.getImporte();
      
      movimientos[ultimoMovimiento] = movimiento;
      ultimoMovimiento = ultimoMovimiento + 1; 
      return true;
    } 
    else return false;
    
  }
  
  
  
  
  Movimiento[] getMovimientos(){
    return movimientos;
  }
  
  void setMovimientos(Movimiento[] movimientos){
    this.movimientos = movimientos;
  }
  
  String getNumeroTarjeta(){
    return numeroTarjeta;
  }
  int getPin(){
    return pin;
  }  
  int getCvv(){
    return cvv;
  }  
  
  void setNumeroTarjeta(String numeroTarjeta_){
    numeroTarjeta = numeroTarjeta_;
  }
  
  void setPin(int pin){
    this.pin = pin;
  }
  void setPinActivacion(int pinActivacion){
    this.pinActivacion = pinActivacion;
  }    
  void setCvv(int cvv){
    this.cvv = cvv;
  } 
  
  public String toString(){
  
    String cad = "\n"+numeroTarjeta + " - SALDO: " + saldo + " €";
    cad = cad + "\n===MOVIMIENTOS================";
    cad +=      "\n==============================";
    
    /*BUCLE CON WHILE
    int i = 0; 
    while (movimientos[i] != null){
      cad += "\n" + movimientos[i].toString();
      i+=1;
    }*/
    /*
    for(int i=0; i < movimientos.length; i++)
      if(movimientos[i] != null)
        cad += "\n" + movimientos[i];
    
    //ESTE BUCLE ES MÁS EFICIENTE PORQUE NO ITERAMOS TODAS LAS POSICIONES DEL ARRAY
    for(int i=0; movimientos[i] != null; i++)
      cad += "\n" + movimientos[i].toString();
    */
    //Bucle for each
    for(Movimiento m : movimientos){
      if(m!=null)
        cad += "\n" + m.toString();
    }
    
    
    return cad;
  }
  
}



