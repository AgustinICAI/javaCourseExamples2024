package fantasy.domain;

class Usuario implements Expulsable{
  String alias;
  double presupuesto;
  int puntos;
  //Jugador [] plantilla;
  //Entrenador [] entrenador;
  Miembro[] plantilla;
  
  //Jugador[] plantilla; 
  int numEntrenadores;
  int numJugadores;
  final static int MAX_JUGADORES = 24;
  final static int MAX_ENTRENADORES = 3;
    
  Usuario (String alias){
    this.alias = alias;
    presupuesto = 100000000;
    puntos = 0;
    plantilla = new Miembro[MAX_JUGADORES + MAX_ENTRENADORES];
    numJugadores = 0;
    numEntrenadores = 0;
  }

  public String expulsar(){
    return "El USUARIO " + alias + " ha sido expulsado";
  }
  
  
  public int calcularNumeroPartidosSancion(){
    return 3;
  }
  

  void addMiembro(Miembro miembro){
    if(miembro instanceof Jugador && numJugadores >= MAX_JUGADORES){
        System.err.println("No caben más Jugadores. Máximo "+MAX_JUGADORES);
        return;
    }
    else if(miembro instanceof Entrenador && numEntrenadores >= MAX_ENTRENADORES){
        System.err.println("No caben más Entrenadores. Máximo "+MAX_ENTRENADORES);
        return;
    }
    
    plantilla[numJugadores + numEntrenadores] = miembro;    
    
    if(miembro instanceof Jugador)
      numJugadores+=1;      
    else if (miembro instanceof Entrenador)
      numEntrenadores+=1;
       
  }




  /*
  void addMiembro(Miembro miembro){
    if(miembro instanceof Jugador){
      if(numJugadores >= MAX_JUGADORES){
        System.err.println("No caben más Jugadores. Máximo "+MAX_JUGADORES);
        return;
      }
      else{
        plantilla[numJugadores + numEntrenadores] = miembro;
        numJugadores+=1;
      }
    }
    else if(miembro instanceof Entrenador){
      if(numEntrenadores >= MAX_ENTRENADORES){
        System.err.println("No caben más Entrenadores. Máximo "+MAX_ENTRENADORES);
        return;
      }
      else{
        plantilla[numJugadores + numEntrenadores] = miembro;
        numEntrenadores+=1;
      }
    }    
  }*/

  void addMiembro(Miembro[] miembros){

    for(Miembro miembro : miembros)
      this.addMiembro(miembro);
  }

  public String toString(){
    String cad = "USUARIO:" + alias + " - presupuesto: " + presupuesto + " - puntos: " + puntos;  
    cad += "\n  MIEMBROS ";
    for(int i = 0; i < (MAX_JUGADORES+MAX_ENTRENADORES) && plantilla[i] != null; i=i+1){
      cad += "\n    " + plantilla[i].toString();
    }
    return cad;  
  }

}
