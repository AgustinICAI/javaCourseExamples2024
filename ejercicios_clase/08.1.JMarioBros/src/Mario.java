import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mario extends Sprite {

    private static final int X_INITIAL_POSITION = 20;
    private static final int Y_INITIAL_POSITION = 490;
    private static final int INITIAL_SPEED = 30;
    private static final int INITIAL_HEIGHT = 40;

    Image[] walkingIcon;
    Image idleIcon;
    Image jumpIcon;
    int posWalking = 0;

    public Mario() throws IOException {
        super(X_INITIAL_POSITION, Y_INITIAL_POSITION-INITIAL_HEIGHT, INITIAL_SPEED);

        walkingIcon = new Image[3];
        walkingIcon[0] = readIconImage("walk1.png");
        walkingIcon[1] = readIconImage("walk2.png");
        walkingIcon[2] = readIconImage("walk3.png");
        jumpIcon = readIconImage("jump.png");
        idleIcon = readIconImage("idle.png");
    }
    private Image readIconImage(String path) throws IOException {
        return ImageIO.read(new File(path)).getScaledInstance(-1,INITIAL_HEIGHT,Image.SCALE_SMOOTH);
    }

    void moveX(int x){
        posWalking += 1;
        if(this.x + x < FondoPrincipal.WITDH && this.x + x > 0)
            this.x+=x;
    }
    void paint(Graphics g){
        if(posWalking==0)
            g.drawImage(idleIcon,x,y,null);
        else
            g.drawImage(walkingIcon[posWalking%3],x,y,null);
    }

}
