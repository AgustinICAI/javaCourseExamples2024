package examen2023.util;

public class Funcion
{
    public static double[][] generarPuntos(int x, int y, int fps)
    {
        double puntos[][] = new double[fps][2];
        int longitudTransicion = 200;
        for(int i=0; i<fps; i++)
        {
            double un_x =  i*longitudTransicion/fps;
            un_x += x;
            double un_y =  0.002 * Math.pow(i*longitudTransicion/fps, 2) + i*longitudTransicion/fps;
            un_y += y;
            double punto[] = {un_x, un_y};
            puntos[i] = punto;
        }

        return puntos;
    }
}