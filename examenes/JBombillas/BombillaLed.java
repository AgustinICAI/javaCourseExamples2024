public class BombillaLed extends Bombilla{

  private double coeficienteEnergetico;
  private EficienciaEnergetica eficienciaEnergetica;  
  
  public BombillaLed(int luminosidad, int vatios, double coeficienteEnergetico){
    super(luminosidad, vatios);
    this.coeficienteEnergetico = coeficienteEnergetico;
  }  
  public BombillaLed(int luminosidad, int vatios, EficienciaEnergetica eficienciaEnergetica){
    super(luminosidad, vatios);
    this.eficienciaEnergetica = eficienciaEnergetica;
  }    
  
  public double getEficienciaEnergetica(){
    if(eficienciaEnergetica == null)
      return getVatios() * coeficienteEnergetico;
    else
      return getVatios() * eficienciaEnergetica.getEficiencia();
    
  }
  
  


}
