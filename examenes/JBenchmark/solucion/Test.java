import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Test{
  
  private List<String> lista;
  private int size;
  
  public Test(TipoLista tipoLista, int size){
      switch(tipoLista){
        case ARRAYLIST:
          lista = new ArrayList<>();
          break;
        case LINKEDLIST:
          lista = new LinkedList<>();
          break;
        
      //Otra opcion
      //lista = tipoLista.getLista();
        
      }
    this.size = size;
  
  }
  
  public abstract void run(int int0);

  public List<String> getLista(){
    return this.lista;
  }
  
  public int getSize(){
    return this.size;
  }


}
