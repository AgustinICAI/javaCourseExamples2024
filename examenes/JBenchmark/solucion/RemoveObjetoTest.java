public class RemoveObjetoTest extends Test{
  public RemoveObjetoTest(TipoLista tipoLista,int size){
    super(tipoLista,size);
    
    for(int i=0;i<size;i++)
      getLista().add(String.valueOf(i));
    
  }
  
  public void run(int posicion){
     getLista().remove(posicion);

  }

}
