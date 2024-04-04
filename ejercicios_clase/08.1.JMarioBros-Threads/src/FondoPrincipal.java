import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class FondoPrincipal extends JPanel {
    Image fondo;
    Mario mario;

    final static int HEIGHT = 640;
    final static int WITDH = 426;
    FondoPrincipal(){
        super();
        try {
            fondo = ImageIO.read(new File("background.png"));
            mario = new Mario();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-5);
        }
        this.setPreferredSize(new Dimension(fondo.getWidth(null),fondo.getHeight(null)));


        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    mario.moveX(-10);
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    mario.moveX(10);
                FondoPrincipal.this.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(fondo,0,0,null);
        mario.paint(g);
    }

}