package es.icai.gitt.juegos.shootingMario.dominio;

import java.awt.*;

public class Bala extends Sprite{

    static double VELOCIDAD_BALA = 250; //Pixeles/s
    private Rectangle areaRectangulo;

    public Bala(int x, int y, boolean orientacionDerecha) {
        super(x, y, orientacionDerecha);
        areaRectangulo = new Rectangle(x,y,20,10);
    }

    @Override
    public Rectangle getShape() {
        return areaRectangulo;
    }

    public void actualizar(){
        if (orientacionDerecha) {
            areaRectangulo.x += VELOCIDAD_BALA / Juego.FPS;
        }
        else
            areaRectangulo.x -= VELOCIDAD_BALA / Juego.FPS;
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(areaRectangulo.x,areaRectangulo.y, areaRectangulo.width, areaRectangulo.height);
    }
}
