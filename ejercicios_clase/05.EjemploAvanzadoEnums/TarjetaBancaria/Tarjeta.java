import java.util.Random;

abstract class Tarjeta{
  
    enum TipoTarjeta{
    //VISA, MASTERCARD, AMERICAN_EXPRESS, VISA_MAESTRO;
    VISA("Visa"), MASTERCARD("Mastercard"), AMERICAN_EXPRESS("American Express"), VISA_MAESTRO("Visa Maestro");
    String nombre;
    
    TipoTarjeta(String nombre){
      this.nombre = nombre;
    }
    
    String getNombre(){
      return nombre;
    }
    
    public String toString(){
      return nombre;
    }

  }

  
  
  //ATRIBUTOS DE CLASE o ATRIBUTOS ESTATICOS
  public static int LIMITE_SALDO = 2000;
  //NO ES NORMAL DEFINIR UN ATRIBUTO DE INSTANCIA DE TIPO PRIVATE, PERO SE PUEDE HACER
  private static int SIZE_LIMIT_CVV = 1000;
  private static int LIMITE_DESCUBIERTO = -100;
  private static int MAX_OPERACION_SIN_PIN = 30;  
  
  TipoTarjeta tipoTarjeta;
  
  //Atributos o Atributos de instancia
  private String numeroTarjeta;
  private int pin;
  private int cvv;
  private double saldo;
  private Movimiento[] movimientos;
  private int pinActivacion;
  private boolean tarjetaActiva;
  protected int ultimoMovimiento;
  abstract double getLimiteOperacionOffline();
  
  
  static void setLIMITESALDO(int limite){
     LIMITE_SALDO = limite;
  }  
  
  //ESTE NO HARÍA FALTA DEFINIRLO SINO HUBIERA MÁS CONSTRUCTORES
  //NO ES NORMAL DEFINIR UN CONSTRUCTOR DE TIPO PRIVATE, PERO SE PUEDE HACER
  private Tarjeta(TipoTarjeta tipoTarjeta){
    movimientos = new Movimiento[1000];
    saldo = LIMITE_SALDO;
    this.tipoTarjeta = tipoTarjeta;
  }
  
  public Tarjeta(TipoTarjeta tipoTarjeta, String numeroTarjeta){
    this(tipoTarjeta);
    
    this.numeroTarjeta = numeroTarjeta;
    Random random = new Random();
    pin = random.nextInt(10000);
    cvv = random.nextInt(SIZE_LIMIT_CVV);
    pinActivacion = random.nextInt(10000);
    tarjetaActiva = false;
    ultimoMovimiento = 0;
  }
  
  public void setSaldo(int saldo){
    this.saldo = saldo;
  }
  
  public double getSaldo(){
    return saldo;
  }
  
  boolean activarTarjeta(int pinActivacion){
    if(this.pinActivacion == pinActivacion)
      return activarTarjeta();
    else
      return false;  
  }
  
  boolean activarTarjeta(){
    tarjetaActiva = true;
    return tarjetaActiva;
  }
  
  boolean pagar(Movimiento movimiento){
    if (saldo - movimiento.getImporte() < LIMITE_DESCUBIERTO)
      return false;
      
    saldo = saldo - movimiento.getImporte();
    movimientos[ultimoMovimiento] = movimiento;
    ultimoMovimiento = ultimoMovimiento + 1; 
    return true;
  } 
   
  boolean pagar(Movimiento movimiento, int pin){
    if(this.pin == pin){
      return pagar(movimiento);
    } 
    else return false;
  }
  
  
  static boolean validarImporteMovimientoSinPIN(int importe){
    /*if (importe < 30)
      return true;
    else return false;  */
    
    return importe < MAX_OPERACION_SIN_PIN;
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
  
    String cad = "\n"+tipoTarjeta + ":" +numeroTarjeta + " - SALDO: " + saldo + " €";
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
        cad += "\n" + m/*.toString()*/;
    }
    
    
    return cad;
  }
  
}



