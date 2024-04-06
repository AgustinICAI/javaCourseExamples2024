package domain;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Game {
    Image fondo;
    Mario mario;

    public static final int FPS = 30;

    public Game() {
        try {
            fondo = ImageIO.read(new File("background.png"));
            mario = new Mario();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-5);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(fondo,0,0,null);
        mario.paint(g);
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
    }

    public void checkCollisions() {
    }
}
