enum TipoCliente{
  PLATINO(100), ORO(80), PLATA(60), BRONCE(40), AZUL(20); 
  
  int puntuacion;
  
  TipoCliente(int puntuacion){
    this.puntuacion = puntuacion;
  }
  
  int getPuntuacion(){
    return puntuacion;
  }
  
  public String toString(){
    return this.name() + "-" + getPuntuacion();
  } 

}
