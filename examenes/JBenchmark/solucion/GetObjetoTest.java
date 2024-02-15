public class GetObjetoTest extends Test{
  public GetObjetoTest(TipoLista tipoLista,int size){
    super(tipoLista,size);
    
    for(int i=0;i<size;i++)
      getLista().add(String.valueOf(i));
    
  }
  
  public void run(int posicion){
     getLista().get(posicion);

  }

}
