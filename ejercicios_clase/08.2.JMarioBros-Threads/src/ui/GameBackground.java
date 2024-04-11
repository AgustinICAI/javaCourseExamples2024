package ui;

import domain.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class GameBackground extends JPanel implements Runnable{

    final public static int HEIGHT = 640;
    final public static int WITDH = 426;

    Game game;

    Collection<Integer> keysPressed;

    GameBackground(){
        super();
        keysPressed = new HashSet<>();
        game = new Game();

        this.setPreferredSize(new Dimension(WITDH,HEIGHT));

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(!game.isFinJuego())
                    keysPressed.add(e.getKeyCode());
                else {
                    game = new Game();
                    Thread t = new Thread(GameBackground.this);
                    t.start();
                }

            }
            @Override
            public void keyReleased(KeyEvent e) {
                keysPressed.remove(e.getKeyCode());
            }
        });


        /*this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                keysPressed.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keysPressed.remove(e.getKeyCode());
            }
        });*/

        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        game.paint(g);
    }

    @Override
    public void run() {
        while (!game.isFinJuego()){
            long tsStart = System.nanoTime();
            game.recalculatePositions(keysPressed);
            game.checkCollisions();
            this.repaint();
            System.out.println("FPS: " + Game.FPS + ", Time Painting: " + (System.nanoTime()-tsStart)/1e6 );
            try {
                Thread.sleep((long) (1000/Game.FPS - (System.nanoTime()-tsStart)/1e6));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}