import java.util.Collection;
import java.util.ArrayList;

public class Hogar{
  Collection<Bombilla> bombillas;
  double factorCorreccion;
  
  public Hogar(double factorCorreccion){
    bombillas = new ArrayList<>();
    this.factorCorrecion = factorCorrecion;
  
  }

  public double calculaEficienciaEnergetica(){
    double sumaEficiencia = 0;
    for(Bombilla b : bombillas)    
      sumaEficiencia += b.getEficienciaEnergetica()*factorCorrecion ;
    
    return sumaEficiencia/bombillas.size();
    
  }
  
  
  
  

}
