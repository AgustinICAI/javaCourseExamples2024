class App2{
  public static void main(String argv[]){

    /*
    int a = 65 → Integer → float →char → String → devolver el primer carácter en
mayúsculas como char → int → byte*/

    int a = 65;
    Integer a1 = a;
    float f = a1;
    char c = (char)f;
    
    //String s = new String(c);CONSTRUCTOR NO EXISTE
    char[] cs = new char[1];
    cs[0] = c;
    String s = new String(cs);
    
    char c1 = s.toUpperCase().charAt(0);
    
    int i0 = c1;
    
    byte b0 = (byte)i0;
    
    
    
    
    
    
    
    
    
    
    
    
  
  }

}
