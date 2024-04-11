package es.icai.gitt.juegos.shootingMario.dominio;

import java.io.IOException;

public class Mario extends Personaje{

    public Mario(int x, int y) throws IOException {
        super("Mario", x, y , true);
        super.setImage("./resources/mario.png");
        super.cargarShape("./resources/mario-points.txt");

    }
}
