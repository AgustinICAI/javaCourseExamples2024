import java.awt.*;
public class Personaje extends Sprite{
  int lado = 50;
  
  public Personaje(){
    this.x = 50;
    this.y = Y_PARTIDA;
  }
  
  void paint(Graphics g){
    g.drawRect(x,y,lado,lado);
  }
  void moverArriba(){
    this.y = Y_PARTIDA - 100;
  }
  
  void moverAbajo(){
    this.y = Y_PARTIDA;
  }

}
