public class ContainsObjetoTest extends Test{
  public ContainsObjetoTest(TipoLista tipoLista, int size){
    super(tipoLista,size);
    
    for(int i=0;i<size;i++)
      getLista().add(String.valueOf(i));
    
  }
  
  public void run(int valor){
    boolean x = getLista().contains(String.valueOf(valor));

  }

}
