package examen2023.domain;

import java.awt.*;

public class Pelota extends Sprite{
    public static final int SIZE = 90;
    public static final int X_INICIAL = 50;
    public static final int Y_INICIAL = 450;
    public static final int X_FINAL = 750;
    public static final int Y_FINAL = 450;



    public Color color;



    public Pelota(int velocidad){
        super(X_INICIAL,Y_INICIAL,velocidad);
        this.color = Color.RED;
    }
    public void setColor(Color color){
        this.color = color;
    }

    public void pintar(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y, SIZE,SIZE);
    }

    public boolean hayFin(){
        if(x+velocidad > X_FINAL)
            return true;
        else return false;

    }

    public void mueveIzquierda() {
        if(x-velocidad < X_INICIAL)
            x = X_INICIAL;
        else
            this.x -= velocidad;
    }

    public void mueveDerecha() {
        if(x+velocidad > X_FINAL)
            x = X_FINAL;
        else
            this.x += velocidad;
    }
    public Rectangle getShape() {
        return new Rectangle(x,y,SIZE,SIZE );
    }

}
