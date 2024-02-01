import java.time.LocalDate;

class TarjetaDebito extends Tarjeta{
  
  
  TarjetaDebito(String numeroTarjeta){
    super(numeroTarjeta);
  }
  
  double getLimiteOperacionOffline(){
    //Si último movimiento es de más de 5 días, limite 0
    //Sino solo 5 euros
    if (super.getMovimientos()[ultimoMovimiento].
              getFecha().isAfter(LocalDate.now().minusDays(5) ) )
       return 5;
    else return 0;
    
  }
    
  public String toString(){
    String cad = "\n---> TARJETA DEBITO" + super.toString();
    return cad;
  }
    
    
}
