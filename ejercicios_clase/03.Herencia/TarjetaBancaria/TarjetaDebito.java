class TarjetaDebito extends Tarjeta{
  
  
  TarjetaDebito(String numeroTarjeta){
    super(numeroTarjeta);
  }
    
  public String toString(){
    String cad = "\n---> TARJETA DEBITO" + super.toString();
    return cad;
  }
    
    
}
