import java.util.Collection;
import java.util.ArrayList;

public class Persona implements Comparable{

  Collection<Tarjeta> tarjetas;
  String nombre;
  String apellido;
  String dni;
  
  Persona(String nombre, String apellido, String dni){
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    tarjetas = new ArrayList<>();
  }
  Persona(String dni){
    this.dni = dni;
  }  
  
  
  
  String getNombre(){
    return nombre;
  }
  String getApellido(){
    return apellido;
  }  
  String getDni(){
    return dni;
  }
    
  void addTarjeta(Tarjeta tarjeta){
    tarjetas.add(tarjeta);
  }
  
  @Override
  public boolean equals(Object o){
    if(o instanceof Persona)
      return this.dni.equals(((Persona)o).getDni());
    else
      return false;    
  }
  
  @Override
  public int hashCode(){
    return getDni().hashCode();
  }
  
  public int compareTo(Object o){
    
    if(o instanceof Persona p){
      int c = this.getNombreNormalizado().compareTo(p.getNombreNormalizado());
      if(c==0)
        return this.apellido.compareTo(p.getApellido());
      else
        return c;
              
    } else return -1;
  
  }
  
  private String getNombreNormalizado(){
    return this.nombre.toUpperCase().replaceAll("Á","A").replaceAll("É","E")
                                    .replaceAll("Í","I").replaceAll("Ó","O")
                                    .replaceAll("Ú","U");
  }
  
  
  public String toString(){
    
    StringBuilder sb = new StringBuilder();
    
    sb.append(nombre+" "+apellido);
    
    
    for(Tarjeta t : tarjetas)
      if(t!=null)
        sb.append(t);
    
    return sb.toString();
    
    
  }


}
