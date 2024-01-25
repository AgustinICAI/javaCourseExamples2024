class App2{

  public static void main(String argv[]){
        
    Movimiento m1 = new Movimiento("Cafeteria ICAI", 2, "22/01/2024");
    Movimiento m2 = new Movimiento("Cafeteria ICAI", 2, "22/01/2024");    
    
    
    
    System.out.println( m1 == m2 );
    System.out.println( m1 == m1 );
    
    int i1 = 5;
    int i2 = 5;
    
    System.out.println( i1 == i2 );
    
    String s1 = "akdsljñalejtñalrjaò`taoirsjtarìutas";
    
    System.out.println( m1.toString().equals(m2.toString()));

  }



}
