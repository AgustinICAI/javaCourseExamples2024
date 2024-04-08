package domain;

import ui.GameBackground;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private int backGroundOffset;
    Image fondo;
    Mario mario;

    Collection<Mushroom> mushrooms;

    public static final int FPS = 30;

    public Game() {
        try {
            fondo = ImageIO.read(new File("background.png"));
            mario = new Mario(this);
            mushrooms = new ArrayList<>();
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

        updateMovingElements();
    }

    private void updateMovingElements() {
        mario.update();
        //mushrooms.forEach(m -> m.update());
        mushrooms.forEach(Mushroom::update);
    }

    public void checkCollisions() {
    }


    public void moveBackground(int offset) {
        
        backGroundOffset += offset;
    }
}
