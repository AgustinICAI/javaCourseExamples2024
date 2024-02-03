package fantasy.domain;

public class Entrenador extends Miembro{
  private Sexo sexo;
  private String sistemaDeJuego;
  
  public Entrenador (String nombreCompleto, String equipo, double valor, Miembro.Sexo sexo, String sistemaDeJuego){
    super(nombreCompleto, equipo, valor);    
    this.sexo = sexo;
    this.sistemaDeJuego = sistemaDeJuego;

    //this.puntos = 0;  
  }
  
  public String celebrar(String estadoAnimo){
    return "Corriendo por la banda " +estadoAnimo;
  }


  public void setSexo(Miembro.Sexo sexo){
    this.sexo = sexo;
  }
  
  public Sexo getSexo(){
    return sexo;
  }
  
  
  public String toString(){
    return "ENTRENADOR " + super.toString() + "-" + sistemaDeJuego + "-" + sexo;
  }
  

}
