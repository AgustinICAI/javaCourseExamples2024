package examen2023.domain;

import java.awt.*;

public abstract class Sprite {
    int x;
    int y;
    double velocidad;
    public Sprite(int x, int y, double velocidad){
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
    }
    public abstract void pintar(Graphics g);
    public abstract Rectangle getShape();

    }
