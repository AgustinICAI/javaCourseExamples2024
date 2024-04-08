package domain;

import ui.GameBackground;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mario extends Sprite {

    private static final int X_INITIAL_POSITION = 20;
    private static final int Y_INITIAL_POSITION = 490;
    private static final int INITIAL_SPEED = 200; //PIXELS PER SECOND
    private static final int INITIAL_HEIGHT = 40;

    private static final int INITIAL_JUMP_SPEED = 300; //PIXELS PER SECOND

    private static final double INITIAL_JUMP_TIME = 0.8; //SECONDS
    private Game game;

    Image[] walkingIcon;
    Image idleIcon;
    Image jumpIcon;
    int posWalking = 0;

    int lastDirection;

    long tsInitJump;
    int yInitJump;

    public Mario(Game game) throws IOException {
        super(X_INITIAL_POSITION, Y_INITIAL_POSITION-INITIAL_HEIGHT, INITIAL_SPEED);
        this.game = game;
        walkingIcon = new Image[3];
        walkingIcon[0] = readIconImage("walk1.png",INITIAL_HEIGHT);
        walkingIcon[1] = readIconImage("walk2.png",INITIAL_HEIGHT);
        walkingIcon[2] = readIconImage("walk3.png",INITIAL_HEIGHT);
        jumpIcon = readIconImage("jump.png",INITIAL_HEIGHT);
        idleIcon = readIconImage("idle.png",INITIAL_HEIGHT);
    }


    public void moveX(int x){
        if(this.x + x >= GameBackground.WITDH-80)
            game.moveBackground(-Mario.INITIAL_SPEED/Game.FPS);
        else if (this.x + x <= 10)
            game.moveBackground(Mario.INITIAL_SPEED/Game.FPS);
        else
            this.x+=x;
    }
    public void paint(Graphics g){
        if(posWalking==0) {
            if(lastDirection >= 0)
                g.drawImage(idleIcon, x, y, null);
            else
                g.drawImage(idleIcon, x+idleIcon.getWidth(null), y, -idleIcon.getWidth(null),idleIcon.getHeight(null) , null);

        }
        else if(posWalking > 0)
            g.drawImage(walkingIcon[posWalking % 3], x, y, null);
        else {//Reverse walking
            Image icon = walkingIcon[-posWalking % 3];
            g.drawImage(icon, x+icon.getWidth(null), y, -icon.getWidth(null),icon.getHeight(null) , null);
        }



    }



    public void stop() {
        if(posWalking!=0)
            lastDirection = posWalking;
        posWalking = 0;

    }

    public void moveLeft() {
        moveX( -INITIAL_SPEED / Game.FPS );
        if(posWalking>0)
            posWalking = -1;
        else
            posWalking -= 1;
    }

    public void moveRight() {
        moveX( INITIAL_SPEED / Game.FPS );
        if(posWalking<0)
            posWalking = 1;
        else
            posWalking += 1;
    }

    public void jump() {
        if(tsInitJump == 0) {
            tsInitJump = System.nanoTime();
            yInitJump = y;
        }
    }
    public void update() {
        if(tsInitJump > 0){
            double jumpTime = (double)(System.nanoTime() - tsInitJump)/1e9;
            if(jumpTime < INITIAL_JUMP_TIME/2)
                setY((int) (yInitJump - INITIAL_JUMP_SPEED * jumpTime));
            else if (jumpTime < INITIAL_JUMP_TIME){
                int jumpHeight = (int) (INITIAL_JUMP_TIME/2 * INITIAL_JUMP_SPEED);
                setY((int) (yInitJump - jumpHeight + ((jumpTime - INITIAL_JUMP_TIME / 2) * INITIAL_JUMP_SPEED)));
            }
            else{
                tsInitJump = 0;
                y = yInitJump;
            }
        }
    }
}
