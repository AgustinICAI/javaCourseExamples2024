package examenMayo.dominio;

import java.awt.*;

public abstract class  Letra {
    protected int x;
    protected int y;
    private java.awt.Color color;

    static final int tam = 30;
    char letra;
    public Letra(int x, int y, char letra, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.letra = letra;
    }
    public void pintar(Graphics g){
        g.setColor(color);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD,30));
        g.drawString(String.valueOf(letra),x,y);
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
