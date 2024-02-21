import java.util.Date;

public class App
{
    private static double calculoPIMontecarlo(long iteraciones)
    {
        double x;
        double y;
        int exito = 0;
        for (int i=0;i<iteraciones;i++)
        {
            x = Math.random();
            y = Math.random();
            if ((Math.pow(x, 2) + Math.pow(y, 2)) <= 1)
                exito++;
        }
        return (double) (4*exito)/iteraciones;
    }  

    //4.0, 1, 0ms., 858407 error
    public static void main(String[] args) 
    {
        for(int iteraciones=0; iteraciones<9; iteraciones++)
        {
            long tiempo0 = new Date().getTime();
            double pi = App.calculoPIMontecarlo((long) Math.pow(10, iteraciones));
            long tiempo1 = new Date().getTime();
            System.out.println(pi + ", " + iteraciones + ", " + (tiempo1 - tiempo0) + "ms, " +  Math.abs(Math.PI - pi) + " error");
        }
    }
}


