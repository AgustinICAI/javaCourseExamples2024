package fantasy.domain;

public abstract class Miembro {
  private String nombreCompleto;
  private String equipo;
  private double valor;
  private int puntos;
  
  public enum Sexo {FEMENINO,MASCULINO};
  
  public Miembro(String nombreCompleto, String equipo, double valor){
    this.nombreCompleto = nombreCompleto;
    this.equipo = equipo;
    this.valor = valor;
    puntos = 0;  
  }
  
  
  public boolean equals(Object o){
    if(o instanceof Miembro){
      Miembro m = (Miembro)o;
      return this.nombreCompleto.equals(m.getNombreCompleto()) &&
       this.equipo.equals(m.getEquipo());
    }
    else return false;
  }
  
  public abstract String celebrar(String estadoAnimo);
  /*
  String celebrarSinMetodoAbstracto(String estadoAnimo)
  {
    return "";
  }
  */
  
  public String getNombreCompleto(){
    return nombreCompleto;
  } 
  
  public String getEquipo(){
    return equipo;
  }  
  public int getPuntos(){
    return puntos;
  }
  
  void setValor(double valor){
    this.valor = valor;
  }

  void addPuntos(int puntos){
    //this.puntos = this.puntos + puntos;
    this.puntos += puntos;
  }
  
  public String toString(){
    return nombreCompleto + "-" + equipo + "-" + valor + "-" + puntos;
  }
  
  
  
}
