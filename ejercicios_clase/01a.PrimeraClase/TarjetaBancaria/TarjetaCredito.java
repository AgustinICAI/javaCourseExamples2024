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
  
  boolean activarTarjeta(int pinActivacion){
    if(this.pinActivacion == pinActivacion){
      tarjetaActiva = true;
    }
    return tarjetaActiva;
  }
   
  boolean pagar(Movimiento movimiento, int pin){
    if(this.pin == pin){
      saldo = saldo - movimiento.getImporte();
      
      movimientos[ultimoMovimiento] = movimiento;
      ultimoMovimiento = ultimoMovimiento + 1; 
      return true;
    } 
    else {
      return false;
    }
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
  
}



