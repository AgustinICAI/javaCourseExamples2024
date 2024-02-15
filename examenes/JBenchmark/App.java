import java.util.ArrayList;

public class App
{
    private static int SIZE = 100;
    private static int ITERACIONES = Util.ITERACIONES;
 
    public static void main(String args[])
    {
        System.out.printf("\nIteraciones: %d.\n", ITERACIONES);
 
        long tiempo1 = 0;                                    // Inicializa el tiempo de cada agregación
        for(int i=0;i<ITERACIONES;i++)
            tiempo1 += App.addObjeto(Util.getRandom(SIZE));  //Acumula el tiempo de cada agregación
        tiempo1 /= ITERACIONES;                              // Calcula el tiempo medio empleado en una agregación
        System.out.printf("ADD: %.4f\n", tiempo1/1000.);     // Imprime el valor medio en microsegundos (nano/1000.) con 4 decimales (%.4f)
       
        tiempo1 = 0;
        for(int i=0;i<ITERACIONES;i++)
            tiempo1 += App.getObjeto(Util.getRandom(SIZE));         
        tiempo1 /= ITERACIONES;
        System.out.printf("GET: %.4f\n", tiempo1/1000.);
       
        tiempo1 = 0;
        for(int i=0;i<ITERACIONES;i++)
            tiempo1 += App.removeObjeto(Util.getRandom(SIZE));         
        tiempo1 /= ITERACIONES;
        System.out.printf("REMOVE: %.4f\n", tiempo1/1000.);
 
        tiempo1 = 0;
        for(int i=0;i<ITERACIONES;i++)
            tiempo1 += App.insertObjeto(Util.getRandom(SIZE));
        tiempo1 /= ITERACIONES;
        System.out.printf("INSERT: %.4f\n", tiempo1/1000.);
       
        tiempo1 = 0;
        for(int i=0;i<ITERACIONES;i++)
            tiempo1 += App.iterar();         
        tiempo1 /= ITERACIONES;
        System.out.printf("ITERATOR: %.4f\n", tiempo1/1000.);       
        
        tiempo1 = 0;
        for(int i=0;i<ITERACIONES;i++)
            tiempo1 += App.contains(Util.getRandom(SIZE));         
        tiempo1 /= ITERACIONES;
        System.out.printf("CONTAINS: %.4f\n", tiempo1/1000.);    
    }
 
    private static long addObjeto(int size)
    {
        ArrayList<String> lista = new ArrayList<String>();
        //LinkedList<String> lista = new LinkedList<String>(); 
       
        long inicioNano = System.nanoTime();

        for(int i=0;i<size;i++)
            lista.add(String.valueOf(i));
        
        long finNano = System.nanoTime();  
        long nanoTiempo = finNano - inicioNano;
        return nanoTiempo;
    }

    private static long insertObjeto(int posicion){
        ArrayList<String> lista = new ArrayList<String>();
        //LinkedList<String> lista = new LinkedList<String>();

        for(int i=0;i<SIZE;i++)
            lista.add(String.valueOf(i));
 
        long inicioNano = System.nanoTime();

        lista.add(posicion, String.valueOf(posicion));
        
        long finNano = System.nanoTime();  
        long nanoTiempo = finNano - inicioNano;
        return nanoTiempo;
    }
 
    static long removeObjeto(int posicion)
    {
        ArrayList<String> lista = new ArrayList<String>();
        //LinkedList<String> lista = new LinkedList<String>();
        
        for(int i=0;i<SIZE;i++)
            lista.add(String.valueOf(i));
 
        long inicioNano = System.nanoTime();
        lista.remove(posicion);
        long finNano = System.nanoTime();  
        long nanoTiempo = finNano - inicioNano;
        return nanoTiempo;
    }
 
    private static long getObjeto(int posicion)
    {
        ArrayList<String> lista = new ArrayList<String>();
        //LinkedList<String> lista = new LinkedList<String>();

        for(int i=0;i<SIZE;i++)
            lista.add(String.valueOf(i));
 
        long inicioNano = System.nanoTime();

        lista.get(posicion);
        
        long finNano = System.nanoTime();   
        long nanoTiempo = finNano - inicioNano;
        return nanoTiempo;
    }
   
    private static long iterar()
    {
        ArrayList<String> lista = new ArrayList<String>();
        //LinkedList<String> lista = new LinkedList<String>();

        for(int i=0;i<SIZE;i++)
            lista.add(String.valueOf(i));
 
        long inicioNano = System.nanoTime();

        String x;
        for(String s:lista)
            x = s;

        long finNano = System.nanoTime();  
        long nanoTiempo = finNano - inicioNano;
        return nanoTiempo;
    } 
    
    private static long contains(int valor)
    {
        ArrayList<String> lista = new ArrayList<String>();
        //LinkedList<String> lista = new LinkedList<String>();

        for(int i=0;i<SIZE;i++)
            lista.add(String.valueOf(i));
        
        long inicioNano = System.nanoTime();

        boolean x = lista.contains(String.valueOf(valor));
        
        long finNano = System.nanoTime();  
        long nanoTiempo = finNano - inicioNano;
        return nanoTiempo;
    }           
}



