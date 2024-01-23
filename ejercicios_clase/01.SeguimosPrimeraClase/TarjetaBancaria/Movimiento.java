class Movimiento{
  String establecimiento;
  double importe;
  String fecha;
  
  Movimiento(String establecimiento, double importe, String fecha){
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
  String getFecha(){
    return fecha;
  }
  

}
