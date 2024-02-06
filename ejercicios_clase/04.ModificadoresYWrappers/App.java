public class App{
  public static void main(String argv[]){
    //int a = 65 → Integer → float → char → String → devolver el primer carácter en
    //mayúsculas como char → int → byte
    
    int a = 65;
    //Integer i = new Integer(a);DEPRECADO
    Integer i = a;//ES LO MISMO, JAVA POR DETRÁS EJECUTA LAS MISMAS ACCIONES
    //float f = i.intValue(); o i.floatValue();
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
    
    
    
  
  }

}
