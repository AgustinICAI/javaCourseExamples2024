import java.util.Collection;
import java.util.ArrayList;

public class Persona{

  Collection<Tarjeta> tarjetas;
  String nombre;
  
  Persona(String nombre){
    this.nombre = nombre;
    tarjetas = new ArrayList<>();
  }
  
  String getNombre(){
    return nombre;
  }
  
  void addTarjeta(Tarjeta tarjeta){
    tarjetas.add(tarjeta);
  }
  
  public boolean equals(Object o){
    if(o instanceof Persona)
      return this.nombre.equals(((Persona)o).getNombre());
    else
      return false;    
  }
  
  
  public String toString(){
    
    StringBuilder sb = new StringBuilder();
    
    sb.append(nombre);
    
    
    for(Tarjeta t : tarjetas)
      if(t!=null)
        sb.append(t);
    
    sb.append("\n");
    
    return sb.toString();
    
    
  }


}
