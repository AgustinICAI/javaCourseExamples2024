public class App{
  public static void main(String argv[]){
    String s0 = "  hola   " + "      que  " + "  tal  ";
    
    StringBuilder sb = new StringBuilder();
    /*sb.append("hola");
    sb.append("que");
    sb.append("tal");*/
    
    sb.append("EJEMPLO APPEND: hola").append("que").append("tal");
    
    System.out.println(sb/*.toString()*/);
    System.out.println(s0);    
    String s1 = s0.trim();    
    String s2 = s1.replaceAll("\s+"," ");
    System.out.println(s2);
    
  
  }
  
  
}
