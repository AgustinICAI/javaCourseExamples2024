
public class App{
  public static void main(String argv[]){
    
    try{
      java.awt.Color c = App.rgbToColor(Integer.parseInt("200a"),200,200);
    }
    catch(RGBConversionException e){
      e.printStackTrace();
    }
    catch(NumberFormatException e){
      e.printStackTrace();
    }
  
  }
  
  
  public static java.awt.Color rgbToColor(int r, int g, int b) throws RGBConversionException{
    if(r<0 || r > 255)
      throw new RGBConversionException(r, "rojo"); 
    if(g<0 || g > 255)
      throw new RGBConversionException(g, "verde"); 
    if(b<0 || b > 255)
      throw new RGBConversionException(b, "azul"); 
              
    return new java.awt.Color(r,g,b); 
     
       
  }



}
