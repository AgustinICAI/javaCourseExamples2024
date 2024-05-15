import javax.swing.JFrame;
import java.awt.event.*;

public class Juego extends JFrame
{
    public final static int ANCHO = 600;
    public final static int ALTO = 400;
    
    boolean espacioPulsado = false;
    
    public boolean getEspacioPulsado(){
      return espacioPulsado;
    }

    public Juego()
    {
        this.add(new Tablero(this));

        this.setTitle("JManzanas");
        this.setSize(ANCHO, ALTO);
        
        
        
        this.addKeyListener(new KeyAdapter(){
          public void keyPressed​(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
              espacioPulsado = true;
              System.out.println("ESPACIO PULSADO");
            }
          }
          public void keyReleased​(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
              espacioPulsado = false;
              System.out.println("ESPACIO SOLTADO");
            }
          }
          
        });
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new Juego().setVisible(true);
    }
}
