package domain;

import java.awt.*;
import java.io.IOException;

public class Mushroom extends Sprite{

    private static final int X_INITIAL_POSITION = 300;
    private static final int Y_INITIAL_POSITION = 490;
    private static final int INITIAL_SPEED = 100; //PIXELS PER SECOND
    private static final int INITIAL_HEIGHT = 25;
    private Image icon;

    public Mushroom() throws IOException {
        super(X_INITIAL_POSITION, Y_INITIAL_POSITION, INITIAL_SPEED);
        icon = readIconImage("mushroom.png",INITIAL_HEIGHT);
    }
    public void paint(Graphics g){
        g.drawImage(icon, x,y-icon.getHeight(null), null);
    }

    public void update() {
        x -= INITIAL_SPEED/Game.FPS;
    }
}
