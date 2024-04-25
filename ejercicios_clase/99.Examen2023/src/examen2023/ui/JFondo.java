package examen2023.ui;

import examen2023.domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.HashSet;

public class JFondo extends JPanel {
    HashSet<Integer> teclasPulsadas;
    Juego juego;
    public JFondo(HashMap<String,String> config){
        super();
        this.juego = new Juego(config);
        teclasPulsadas = new HashSet<>();
        this.setPreferredSize(new Dimension(JBloques.GAME_WIDTH,JBloques.GAME_HEIGHT));
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                teclasPulsadas.add(e.getKeyCode());
            }
            @Override
            public void keyReleased(KeyEvent e) {
                teclasPulsadas.remove(e.getKeyCode());
            }
        });

        new Thread(()->{
            while(true) {
                juego = new Juego(config);
                while (juego.getStatus() == null) {
                    juego.recalcula(teclasPulsadas);
                    juego.compruebaColisiones();
                    repaint();
                    try {
                        Thread.sleep(1000 / Integer.parseInt(config.get("FPS")));
                    } catch (Exception e) {

                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        juego.paint(g);
    }


}
