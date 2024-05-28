package examenMayo.dominio;

import java.awt.*;

public class Casilla {
    Rectangle area;
    Letra letra;
    private boolean visible;

    public Casilla(Rectangle area) {
        this.area = area;
        this.visible = true;
    }

    public Letra getLetra() {
        return letra;
    }

    public boolean isVisible(){
        return visible;
    }


    public Rectangle getArea() {
        return area;
    }

    public void setArea(Rectangle area) {
        this.area = area;
    }

    public void setLetraX() {
        this.letra = new LetraX((int) area.getCenterX()-15, (int) area.getCenterY()+5);
    }
    public void setLetraY() {
        this.letra = new LetraO((int) area.getCenterX()-15, (int) area.getCenterY()+5);
    }

    public void resetLetra(){
        this.letra = null;
        this.visible = true;
    }
    public void setLetra(Letra letra) {
        this.letra = letra;
    }

    public void setVisible(boolean b) {
        this.visible = b;
    }
}
