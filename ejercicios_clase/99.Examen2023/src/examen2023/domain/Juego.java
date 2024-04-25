package examen2023.domain;

import examen2023.ui.JBloques;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Juego {
    String status;
    HashMap<String, String> config;
    ArrayList<Bloque> bloques;
    Pelota pelota;

    public Juego(HashMap<String,String> config){
        this.config = config;
        bloques = new ArrayList<>();
        int numBloques = Integer.parseInt(config.get("BLOQUES"));
        int xInicial = JBloques.GAME_WIDTH/2 - numBloques*Bloque.WITDTH/2;

        /*
        double velocidadInicial = Integer.parseInt(velocidades[0]) + Math.random()*(Integer.parseInt(velocidades[1])-Integer.parseInt(velocidades[0]));
        */
        String[] velocidades = config.get("VELOCIDAD").split("-");
        Random r = new Random();

        for(int i = 0; i < numBloques;i++){
            double velocidadInicial = r.nextDouble(Integer.parseInt(velocidades[0]),Integer.parseInt(velocidades[1]));
            bloques.add(new Bloque(xInicial,velocidadInicial));
            xInicial+=Bloque.WITDTH;
        }
        pelota =new Pelota(Integer.parseInt(config.get("PELOTA")));

    }

    public void paint(Graphics g) {
        bloques.forEach(b -> b.pintar(g));
        pelota.pintar(g);
        if(status!=null && status.equals("FIN")) {
            g.setFont(new Font(Font.MONOSPACED,Font.PLAIN,50));
            g.drawString(status, 200, 200);
        }
    }

    public String getStatus() {
        return status;
    }

    public void recalcula(HashSet<Integer> teclasPulsadas) {
        if(teclasPulsadas.contains(KeyEvent.VK_LEFT))
            pelota.mueveIzquierda();
        else if (teclasPulsadas.contains(KeyEvent.VK_RIGHT))
            pelota.mueveDerecha();

        bloques.forEach(Bloque::recalcula);


    }

    public void compruebaColisiones() {
        boolean hayColisiones = bloques.stream().anyMatch(b -> pelota.getShape().intersects(b.getShape()));
        if(hayColisiones) {
            status = "COLISIONADO";
            pelota.setColor(Color.YELLOW);
        }
        else if(pelota.hayFin()) {
            status = "FIN";
            pelota.setColor(Color.GREEN);
        }

    }

}
