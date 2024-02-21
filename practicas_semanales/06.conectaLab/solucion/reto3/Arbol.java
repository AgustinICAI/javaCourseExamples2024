public class Arbol
{
    public static void crear(int ancho, int pisos, String caracteres)
    {
        ancho++;
        int anchoMax = ancho * pisos;

        for(int i=0;i<pisos;i++)
        {
            for(int size=1;size<ancho;size++)
            {
                for(int rama=0;rama<(anchoMax - size);rama++)
                    System.out.print(" ");
                    
                for(int rama=0;rama<size;rama++)
                    System.out.print(caracteres);

                System.out.println();
            }
            ancho += 2;
        }
    }
}