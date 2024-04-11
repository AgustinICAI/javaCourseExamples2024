package domain;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Sprite {
    int x;
    int y;
    int speed;//PIXELES POR SEGUNDO

    Image icon;

    public Sprite(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public Rectangle getShape() {
        if(icon!=null)
            return new Rectangle(x,y,icon.getWidth(null),icon.getHeight(null));
        else
            return null;
    }

    public void paintShape(Graphics g) {
        Rectangle r = getShape();
        g.drawRect(r.x,r.y,r.width,r.height);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected Image readIconImage(String path, int height) throws IOException {
        return ImageIO.read(new File(path)).getScaledInstance(-1,height,Image.SCALE_SMOOTH);
    }
}
