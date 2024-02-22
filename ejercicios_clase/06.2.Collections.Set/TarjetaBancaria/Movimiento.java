import java.time.LocalDate;

class Movimiento{
  String establecimiento;
  double importe;
  LocalDate fecha;
  
  Movimiento(String establecimiento, double importe, LocalDate fecha){
    this.establecimiento = establecimiento;
    this.importe = importe;
    this.fecha = fecha;
  }
  
  String getEstablecimiento(){
    return establecimiento;
  }
  double getImporte(){
    return importe;
  }
  LocalDate getFecha(){
    return fecha;
  }
  
  public String toString(){
    return fecha/*.toString()*/ + " - " + establecimiento + ", importe: " + importe + " €";
  }
  

}
