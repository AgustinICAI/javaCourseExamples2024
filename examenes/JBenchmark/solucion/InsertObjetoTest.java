public class InsertObjetoTest extends Test{
  public InsertObjetoTest(TipoLista tipoLista,int size){
    super(tipoLista,size);
    
    for(int i=0;i<size;i++)
      getLista().add(String.valueOf(i));
    
  }
  
  public void run(int posicion){
    getLista().add(posicion, String.valueOf(posicion));
  }

}
