package domain;

import ui.GameBackground;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Game {
    public static final int Y_INITIAL_POSITION = 490;
    private long lastMushroom;

    private int backGroundOffset;
    Image fondo;
    Mario mario;


    boolean finJuego = false;
    int monedas = 0;
    int vidas = 3;
    Collection<Mushroom> mushrooms;

    public static final int FPS = 30;

    public Game() {
        try {
            fondo = ImageIO.read(new File("resources/background.png"));
            mario = new Mario(this);
            mushrooms = new ArrayList<>();
            lastMushroom = System.nanoTime();
            mushrooms.add(new Mushroom());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-5);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(fondo,backGroundOffset%GameBackground.WITDH,0,null);
        g.drawImage(fondo, GameBackground.WITDH + backGroundOffset%GameBackground.WITDH,0,null);
        mario.paint(g);
        mushrooms.forEach(m -> m.paint(g));
        mario.paintShape(g);
        mushrooms.forEach(m -> m.paintShape(g));
        g.setFont(new Font(Font.MONOSPACED,Font.BOLD,30));
        g.setColor(Color.RED);
        g.drawString("Vidas: " + vidas, 200,50);
        g.drawString("Monedas: " + monedas, 200,100);
        if(finJuego) {
            g.setFont(new Font(Font.MONOSPACED,Font.BOLD,50));
            g.drawString("FIN JUEGO", 70, 300);
            g.setFont(new Font(Font.MONOSPACED,Font.BOLD,20));
            g.drawString("Pulse tecla para volver a empezar", 10, 330);

        }
    }

    public void recalculatePositions(Collection<Integer> keysPressed) {
        if(keysPressed.contains(KeyEvent.VK_RIGHT))
            mario.moveRight();
        else if (keysPressed.contains(KeyEvent.VK_LEFT))
            mario.moveLeft();
        else
            mario.stop();

        if(keysPressed.contains(KeyEvent.VK_UP))
            mario.jump();

        generateRandomMushroom();
        updateMovingElements();
    }


    private void generateRandomMushroom() {
        long timeLastMushroom = System.nanoTime() - lastMushroom;
        if(timeLastMushroom >= 3*1e9){
            lastMushroom = System.nanoTime();
            try {
                mushrooms.add(new Mushroom());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void updateMovingElements() {
        mario.update();
        //mushrooms.forEach(m -> m.update());
        mushrooms.forEach(Mushroom::update);

        //Limitación, no se puede borrar un elemento de una lista que se itera
        /*for(Mushroom m : mushrooms)
            if (m.getX() < -10)
                mushrooms.remove(m);
        Collection<Mushroom> mushroomsBorrar = new ArrayList<>();
        for(Mushroom m : mushrooms)
            if (m.getX() < -10)
                mushroomsBorrar.add(m);
        mushrooms.removeAll(mushroomsBorrar);*/

        Collection<Mushroom> mushroomsDelete = mushrooms.stream().filter(Mushroom::isOutsideScreen).collect(Collectors.toList());
        mushrooms.removeAll(mushroomsDelete);


    }

    HashMap<Mushroom,Long> ultimosImpactos = new HashMap<Mushroom, Long>();


    public void checkCollisions() {
        Collection<Mushroom> mushroomsABorrar = new ArrayList<>();
        for(Mushroom m : mushrooms)
        {
            if(m.getShape().intersects(mario.getShape())) {
                if (mario.getLastShape().getMaxY() <= m.getShape().getMinY()) {//Mario salta por encima
                    monedas += 1;
                    mushroomsABorrar.add(m);
                } else {
                    if (!ultimosImpactos.containsKey(m) ||
                            ultimosImpactos.containsKey(m) && System.nanoTime() - ultimosImpactos.get(m) > 1e9) {
                        vidas -= 1;
                        mario.startBlinking();
                        ultimosImpactos.put(m, System.nanoTime());
                    }
                }
            }
        }
        mushrooms.removeAll(mushroomsABorrar);
        if(vidas == 0)
            finJuego = true;

    }


    public void moveBackground(int offset) {
        backGroundOffset += offset;
    }
    public boolean isFinJuego() {
        return finJuego;
    }

}
