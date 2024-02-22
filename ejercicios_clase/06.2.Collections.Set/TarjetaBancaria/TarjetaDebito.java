import java.time.LocalDate;
import java.util.LinkedList;
class TarjetaDebito extends Tarjeta{
  
  
  TarjetaDebito(TipoTarjeta tipoTarjeta, String numeroTarjeta){
    super(tipoTarjeta, numeroTarjeta);
  }
  
  double getLimiteOperacionOffline(){
    //Si último movimiento es de más de 5 días, limite 0
    //Sino solo 5 euros
    /*if (getMovimientos() instanceof LinkedList<Movimiento> &&   
       ((LinkedList<Movimiento>)getMovimientos()).getLast().
                getFecha().isAfter(LocalDate.now().minusDays(5) ) )
         return 5;*/
    if ((getMovimientos()).getLast().
        getFecha().isAfter(LocalDate.now().minusDays(5) ) )
      return 5;     
         
    else return 0;

  }
    
  public String toString(){
    String cad = "\n---> TARJETA DEBITO" + super.toString();
    return cad;
  }
    
    
}
