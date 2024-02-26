public class BombillaBajoConsumo extends Bombilla{
  
  
  /*SUPER SIEMPRE TIENE QUE IR EN LA PRIMERA LINEA
  public BombillaBajoConsumo(int luminosidad, int vatios){
    WattiosAdapter wa = new WattiosAdapter();
    vatiosCorregidos = wa.adaptedValue(vatios);

    super(luminosidad, vatiosCorregidos);
  }*/
  
  WattiosAdapter wa = new WattiosAdapter(); 
  public BombillaBajoConsumo(int luminosidad, int vatios){
    super(luminosidad, wa.adaptedValue(vatios));
  }  
  
  public BombillaBajoConsumo(int luminosidad, int vatios){
    WattiosAdapter wa = new WattiosAdapter();
    this.vatios = wa.adaptedValue(vatios);
    this.luminosidad = luminosidad;
  } 
  
  
  
  public double getEficienciaEnergetica(){
    return super.getEficienciaEnergetica() + WattiosAdapter.DELTA;
  }
  
  


}
