public abstract class Bombilla{
  protected int luminosidad;//lúmenes
  protected int vatios;//vatios
  
  public Bombilla(int luminosidad, int vatios){
    this.luminosidad = luminosidad;
    this.vatios = vatios;
  }
  
  public double getEficienciaEnergetica(){
    return (double)luminosidad/vatios;
  }
  
  public int getVatios(){
    return vatios;
  }
  
  


}
