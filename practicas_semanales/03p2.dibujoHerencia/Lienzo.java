import java.awt.Canvas;
import java.awt.Graphics;


public class Lienzo extends Canvas
{
	Figura figuras[] = new Figura[10];

	void addFigura(Figura c)
	{
		for(int i=0;i<figuras.length;i++)
			if(figuras[i] == null)
			{
				figuras[i] = c;
				i = figuras.length;
			}
	}

	@Override
	public void paint(Graphics g)
	{
		for(int i=0;i<figuras.length;i++)
			if(figuras[i] != null)
				figuras[i].pintar(g);
	}
}
