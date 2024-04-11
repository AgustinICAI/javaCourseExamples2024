package es.icai.gitt.juegos.shootingMario.dominio;

import java.io.IOException;

public class Luigi extends Personaje{

    public Luigi(int x, int y) throws IOException {
        super("Luigi", x, y, false);
        super.setImage("./resources/luigi.png");
        super.cargarShape("./resources/luigi-points.txt");
    }
}
