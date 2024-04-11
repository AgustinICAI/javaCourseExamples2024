package es.icai.gitt.juegos.shootingMario.dominio;

import java.awt.*;
import java.awt.geom.Area;

public abstract class Sprite {
    int x;
    int y;
    boolean orientacionDerecha = false;

    public Sprite(int x, int y, boolean orientacionDerecha) {
        this.x = x;
        this.y = y;
        this.orientacionDerecha = orientacionDerecha;
    }
    public abstract Shape getShape();

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setOrientacionDerecha(boolean orientacionDerecha) {
        this.orientacionDerecha = orientacionDerecha;
    }
}
