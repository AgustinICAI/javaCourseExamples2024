public class Persona{

  Tarjeta[] tarjetas;

  String nombre;
  
  Persona(String nombre){
    this.nombre = nombre;
    tarjetas = new Tarjeta[10];
  }
  
  String getNombre(){
    return nombre;
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
