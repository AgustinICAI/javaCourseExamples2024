public enum TipoLista{
  ARRAYLIST,LINKEDLIST;
}


//OTRA FORMA
/*
public enum TipoLista{
  ARRAYLIST(new ArrayList<>()),LINKEDLIST(new LinkedList<>());
  
  List<String> lista;
  
  TipoLista(List lista){
    this.lista = lista;
  }
  
  List getLista(){
    return lista;
  }
  
}*/
