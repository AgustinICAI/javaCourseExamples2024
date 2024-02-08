import java.time.LocalDate;

class TarjetaDebito extends Tarjeta{
  
  
  TarjetaDebito(TipoTarjeta tipoTarjeta, String numeroTarjeta){
    super(tipoTarjeta, numeroTarjeta);
  }
  
  double getLimiteOperacionOffline(){
    //Si último movimiento es de más de 5 días, limite 0
    //Sino solo 5 euros
    if (super.getMovimientos()[ultimoMovimiento].
              getFecha().isAfter(LocalDate.now().minusDays(5) ) )
       return 5;
    else return 0;
    /*
    Movimiento movimientoUltimo = super.getMovimientos()[ultimoMovimiento];
    LocalDate fechaMenos5 = LocalDate.now().minusDays(5);
    if(movimientoUltimo.getFecha().isAfter(fechaMenos5))
      return 5;
    else return 0;
    */
  }
    
  public String toString(){
    String cad = "\n---> TARJETA DEBITO" + super.toString();
    return cad;
  }
    
    
}
