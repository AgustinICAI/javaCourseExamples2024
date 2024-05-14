package examen2023.domain;

import examen2023.ui.Fondo;

import java.awt.*;

public class PlanetaZoom extends PlanetaMovimiento {

    private static final int INCREMENTO_ZOOM = 50;

    public PlanetaZoom(int x, int y, boolean relleno, Color color) {
        super(x, y, relleno, color);
    }

    @Override
    public void actualizar() {
        super.actualizar();
        if ((System.nanoTime() - this.inicio) / 1E9 < 1) {
            double incremento = (double) INCREMENTO_ZOOM / Fondo.FPS;
            this.ancho += incremento;
            setY((int) (y - incremento / 2));
            setX((int) (x - incremento / 2));

        }
    }

}
