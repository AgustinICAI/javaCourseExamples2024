public class RGBConversionException extends Exception{

    int value;
    String color;
    
    public RGBConversionException(int value, String color){
      super();
      this.value = value;
      this.color = color; 
    }
    
    @Override
    public String getMessage(){
      return "El color " + color + " no puede tener el valor " + value +". Valor válido: [0-255]";
    }   



}
