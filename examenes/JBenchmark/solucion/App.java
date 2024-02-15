public class App{
  public static void main(String argv[]){
    
    new RunTest(new AddObjetoTest(TipoLista.ARRAYLIST,1000), Util.ITERACIONES,1000);
    new RunTest(new GetObjetoTest(TipoLista.ARRAYLIST,1000), Util.ITERACIONES,1000);
    new RunTest(new InsertObjetoTest(TipoLista.ARRAYLIST,1000), Util.ITERACIONES,1000); 
    new RunTest(new RemoveObjetoTest(TipoLista.ARRAYLIST,1000), Util.ITERACIONES,1000);
    new RunTest(new IterarObjetoTest(TipoLista.ARRAYLIST,1000), Util.ITERACIONES,1000); 
    new RunTest(new ContainsObjetoTest(TipoLista.ARRAYLIST,1000), Util.ITERACIONES,1000); 
  }

}
