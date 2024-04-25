package examen2023.domain;

import examen2023.ui.JBloques;

import java.awt.*;
import java.util.Random;

public class Bloque extends Sprite{
    public static final int WITDTH = 100;
    public static final int ALTURA = 100;

    public int alturaRebote;
    public int suelo;

    public Bloque(int x, double velocidad){
        super(x,ALTURA, velocidad);
        Random r = new Random();
        alturaRebote = (int) r.nextDouble(-10,10) + ALTURA;
        suelo = JBloques.GAME_HEIGHT;
    }


    public void pintar(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x,y,WITDTH,WITDTH);
        g.drawLine(x,y,x+WITDTH,y+WITDTH);
        g.drawLine(x+WITDTH,y,x,y+WITDTH);
    }

    @Override
    public Rectangle getShape() {
        return new Rectangle(x,y,WITDTH,WITDTH );
    }

    boolean bajando = true;
    public void recalcula() {
        if(bajando && y+velocidad+ALTURA >= suelo) {
            bajando = false;
            y = suelo - ALTURA;
        }
        else if(!bajando && y - velocidad <= alturaRebote) {
            bajando = true;
            y = alturaRebote;
        }
        else if(bajando)
            y+= velocidad;
        else
            y -= velocidad;

    }
}
