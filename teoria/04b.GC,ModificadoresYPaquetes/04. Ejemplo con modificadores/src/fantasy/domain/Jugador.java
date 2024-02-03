package fantasy.domain;

public class Jugador extends Miembro implements Expulsable {
  private Posicion posicion; 
  public static final Sexo SEXO = Sexo.MASCULINO;
  
  public Jugador (String nombreCompleto, String equipo, double valor, Posicion posicion){
    super(nombreCompleto, equipo, valor);
    this.posicion = posicion;  
  }
  
  public String expulsar(){
    return "El jugador " + getNombreCompleto() + " ha sido expulsado";
  }
  
  
  public int calcularNumeroPartidosSancion(){
    return 2;
  }
  
  public String celebrar(String estadoAnimo){
    return "Bailando muy " +estadoAnimo;
  }
  /*
  public static void setSEXO(Sexo sexo){
    SEXO = sexo;
  }*/
  
  public static Sexo getSEXO(){
    return SEXO;
  }
  

  
  
  public String toString(){
  /*String cad = nombreCompleto + "-" + equipo + "-" + valor + "-" + puntos + "-" + posicion;
    return cad;*/
    return "JUGADOR "+ super.toString() + "-" + posicion + "-" + Jugador.SEXO;
  }
  

}
