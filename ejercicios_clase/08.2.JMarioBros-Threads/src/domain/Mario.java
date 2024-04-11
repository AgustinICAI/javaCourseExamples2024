package domain;

import ui.GameBackground;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mario extends Sprite {

    private static final int X_INITIAL_POSITION = 20;
    private static final int INITIAL_SPEED = 200; //PIXELS PER SECOND
    private static final int INITIAL_HEIGHT = 40;

    private static final double BLINK_TIME = 1;
    private static final double BLINK_FLASHING_TIME = 0.1;

    private static final int INITIAL_JUMP_SPEED = 300; //PIXELS PER SECOND

    private static final double INITIAL_JUMP_TIME = 0.8; //SECONDS
    private Game game;
    int lastDirection;

    Image[] walkingIcon;
    Image idleIcon;
    Image jumpIcon;
    int posWalking = 0;
    long tsInitJump;
    int yInitJump;

    boolean visible = true;
    Rectangle lastShape;

    public Mario(Game game) throws IOException {
        super(X_INITIAL_POSITION, Game.Y_INITIAL_POSITION-INITIAL_HEIGHT, INITIAL_SPEED);
        this.game = game;
        walkingIcon = new Image[3];
        walkingIcon[0] = readIconImage("resources/walk1.png",INITIAL_HEIGHT);
        walkingIcon[1] = readIconImage("resources/walk2.png",INITIAL_HEIGHT);
        walkingIcon[2] = readIconImage("resources/walk3.png",INITIAL_HEIGHT);
        jumpIcon = readIconImage("resources/jump.png",INITIAL_HEIGHT);
        idleIcon = readIconImage("resources/idle.png",INITIAL_HEIGHT);
        icon = idleIcon;
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
        if(visible)
            if(lastDirection >= 0)
                g.drawImage(icon, x, y, null);
            else
                g.drawImage(icon, x+idleIcon.getWidth(null), y, -idleIcon.getWidth(null),idleIcon.getHeight(null) , null);
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
        lastDirection = -this.x;
    }

    public void moveRight() {
        moveX( INITIAL_SPEED / Game.FPS );
        if(posWalking<0)
            posWalking = 1;
        else
            posWalking += 1;
        lastDirection = this.x;
    }
    public void jump() {
        if(tsInitJump == 0) {
            tsInitJump = System.nanoTime();
            yInitJump = y;
        }
    }

    public Rectangle getLastShape() {
        return lastShape;
    }

    public void update() {
        lastShape = this.getShape();
        //Calcular salto
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
        //Calcular el icono que toca para andar
        if(posWalking==0)
            icon = idleIcon;
        else
            icon =  walkingIcon[Math.abs(posWalking) % 3];

        //Calcular el flasheo de Mario
        if(System.nanoTime() - tsStartBlinking < BLINK_TIME*1e9){
            double timeBlinking = (System.nanoTime() - tsStartBlinking) / 1e9;
            double countParpadeos = timeBlinking / BLINK_FLASHING_TIME;
            System.out.println(timeBlinking + " - " + countParpadeos);
            if( (int)countParpadeos %2 == 0)
                visible = true;
            else
                visible = false;
        }
        else
            visible = true;
    }

    long tsStartBlinking;
    public void startBlinking() {
        tsStartBlinking = System.nanoTime();
    }
}
