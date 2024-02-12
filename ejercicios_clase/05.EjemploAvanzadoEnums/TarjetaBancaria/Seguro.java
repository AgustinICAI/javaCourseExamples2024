class Seguro implements SubscribleFinDeMes{

  String nombre;
  double cuotaMensual;
  
  Seguro(String nombre, double cuotaMensual){
    this.nombre = nombre;
    this.cuotaMensual = cuotaMensual;
  }
  
  
  public String toString(){
    return nombre + " - cuota mensual: " + cuotaMensual; 
  }
  
  public double liquidacionFinMes(){
    return this.cuotaMensual;
  }
  
  
  public int calculoDiaPago(){
    return 3;
  }
  
}
