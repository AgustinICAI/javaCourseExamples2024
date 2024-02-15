public class AddObjetoTest extends Test{

  AddObjetoTest(TipoLista tipoLista,int size){
    super(tipoLista,size);
  }

  public void run(int int0){
    for(int i=0;i<getSize();i++)
       getLista().add(String.valueOf(i));
  }

}
