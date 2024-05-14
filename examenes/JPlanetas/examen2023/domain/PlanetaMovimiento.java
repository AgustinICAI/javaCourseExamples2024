package examen2023.domain;

import examen2023.ui.Fondo;
import examen2023.util.Funcion;

import java.awt.*;

public class PlanetaMovimiento extends Planeta{

    private double[][] puntosAnimacion;
    protected long inicio;

    public PlanetaMovimiento(int x, int y, boolean relleno, Color color) {
        super(x,y,relleno,color);
    }

    public void inicioAnimacion() {
        this.inicio = System.nanoTime();
        puntosAnimacion = Funcion.generarPuntos(x,y, Fondo.FPS);
    }

    public void actualizar(){
        if((System.nanoTime() - this.inicio)/1E9 < 1) {
            int posFrame = (int) (Fondo.FPS * (System.nanoTime() - this.inicio) / 1E9);
            setX((int) puntosAnimacion[posFrame][0]);
            setY((int) puntosAnimacion[posFrame][1]);
        }
    }

}
