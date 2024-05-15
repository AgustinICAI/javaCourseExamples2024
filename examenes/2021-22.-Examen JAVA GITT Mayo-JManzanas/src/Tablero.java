import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class Tablero extends JPanel
{
    private int fps = 60; //Valor por defecto. El de cada ejecución, lo tomará del fichero.
    private boolean corriendo = true;
    private Personaje p = new Personaje();
    private Juego juego;
    
    public Tablero(Juego juego)
    {
        this.juego = juego;
        this.setBackground(Color.BLACK);        
        
        new Thread(() -> {
          while(corriendo){
            esperar(calcularDelay());
            moverTodosObjetosASuNuevaPosicion();
            checkPersonajePrincipalImpactaConObjetos();
            repintaTablero();  
            System.out.println("pintando");          
          }       
        }).start();
        
    }
    private void esperar(int delay){
      try{
          Thread.sleep(delay);
        }
        catch(Exception e){
          e.printStackTrace();
        }    
    }
    private void checkPersonajePrincipalImpactaConObjetos(){
      
    }
    
    private void repintaTablero(){
       this.repaint();
      
    }


    private void moverTodosObjetosASuNuevaPosicion(){
      if(juego.getEspacioPulsado()){
        p.moverArriba();
      }
      else
        p.moverAbajo();
      
    }


    /** En milisegundos */
    private int calcularDelay()
    {
        return (int) (1/(fps*1.)*1000);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        p.paint(g);
        
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 15));
        g.drawString("Vida: 1000", 50, 50);
    }
}
