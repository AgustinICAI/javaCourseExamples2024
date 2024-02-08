public class App{
  public static void main(String argv[]){
    //int a = 65 → Integer → float → char → String → devolver el primer carácter en
    //mayúsculas como char → int → byte
    
    int a = 65;
    //Integer i = new Integer(a);DEPRECADO
    Integer i = a;//ES LO MISMO, JAVA POR DETRÁS EJECUTA LAS MISMAS ACCIONES
    //float f = i.intValue(); o i.floatValue();
    //BOXING Y UNBOXING
    float f = i;
    
    char c = (char) f;
    //opcion1
    Character c1 = c;
    String s1 = c1.toString();
    
    //Opcion2
    char[] cs = new char[1];
    cs[0]=c;
    String s2 = new String(cs);
    
    //Opcion2.1
    char[] c1s = {c};
    String s3 = new String(c1s);
    
    //Opción1
    char c2 = s1.substring(0,1).toUpperCase().toCharArray()[0];
    //Opción2
    int i2 = Character.codePointAt(s1.substring(0,1).toUpperCase(),0);
    char c3 = (char)i2;
    
    int i3 = c2;
    
    byte b1 = (byte)i3;
    
    System.out.println(b1 + " - " + c3);
    
  
  }

}
