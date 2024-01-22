import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	private Cuadrado cuadrado;

	public void pintar(Cuadrado c)
	{
		cuadrado = c;
	}

	public void paint(Graphics g)
	{
		if(cuadrado!=null)
		{
			g.setColor(Color.RED);
			g.drawRect(cuadrado.getX(), cuadrado.getY(), cuadrado.getLado(), cuadrado.getLado()); 
		}
	}
}