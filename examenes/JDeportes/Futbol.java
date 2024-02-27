public class Futbol extends Deporte{
  int numJugadores;
  
  
  float calcularCalorias (Complexion complexion){
    return complexion.getValor() + numJugadores;
  }

}
