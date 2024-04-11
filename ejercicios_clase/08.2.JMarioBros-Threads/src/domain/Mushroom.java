package domain;

import java.awt.*;
import java.io.IOException;

public class Mushroom extends Sprite{

    private static final int X_INITIAL_POSITION = 300;
    private static final int INITIAL_SPEED = 100; //PIXELS PER SECOND
    private static final int INITIAL_HEIGHT = 25;
    public Mushroom() throws IOException {
        super(X_INITIAL_POSITION, Game.Y_INITIAL_POSITION-INITIAL_HEIGHT, INITIAL_SPEED);
        icon = readIconImage("resources/mushroom.png",INITIAL_HEIGHT);
    }
    public void paint(Graphics g){
        g.drawImage(icon, x,y, null);
    }

    public void update() {
        x -= INITIAL_SPEED/Game.FPS;
    }

    public boolean isOutsideScreen(){
        return this.getX()  + icon.getWidth(null)  < 0;
    }


}
