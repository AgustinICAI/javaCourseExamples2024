public enum EficienciaEnergetica{
  A(1), B(0.8), C(0.6), D(0.4), E(0.2), F(0.1), G(0);
  
  double eficiencia;
  
  EficienciaEnergetica(double eficiencia){
    this.eficiencia = eficiencia;
  }
  double getEficiencia(){
    return eficiencia();
  }

}
