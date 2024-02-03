package fantasy.ui;
import fantasy.domain.*;

class AppFantasy4{

  public static void main (String argv[]){
    
    Jugador j1 = new Jugador("Rodrigo de Paul", "Atletico del Madrid", 5000000, Posicion.CENTROCAMPISTA);
    Jugador j2 = new Jugador("Koke", "Atletico del Madrid", 10000000, Posicion.CENTROCAMPISTA); 
    Jugador j3 = new Jugador("Rodrigo de Paul", "Real Madrid", 5000000, Posicion.CENTROCAMPISTA);
    Jugador j4 = j1;
    Entrenador e1 = new fantasy.domain.Entrenador("Cholo Simeone","Atletico del Madrid", 40000000,Miembro.Sexo.MASCULINO, "Argentino");

    System.out.println(j1==j3);
    System.out.println(j4==j1);
    
    System.out.println(j1.equals(j3));
    
    System.out.println(j4.toString());
    
    Miembro m1 = j4;
    
    System.out.println(m1.toString());
    
    
    
  }

}
