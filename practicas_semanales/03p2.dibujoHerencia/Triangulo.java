import java.awt.Color;

public class Triangulo extends Figura
{
	public final static int LADO_MIN = 2; 
	public final static int LADO_MAX = 600; 

	int lado;

	/** 
		Inicializa todos los atributos del objeto 
		@param x Posición x de la ventana en pixels
		@param y Posición x de la ventana en pixels
		@param lado Tamaño del cuadrado en pixels
	*/
	Triangulo(int x, int y, boolean relleno, Color color, int lado)
	{
		super(x, y, relleno, color);
		this.setLado(lado);
	}

	void setLado(int lado)
	{
		if(lado >= LADO_MIN && lado < LADO_MAX)
			this.lado = lado;
		else
			this.lado = LADO_MIN;
	}

	int getLado()
	{
		return lado;
	}

	@Override
	void pintar(java.awt.Graphics g)
	{
		super.pintar(g);
		
		int[] xs = new int[3];
	  int[] ys = new int[3];
		xs[0]=x;
		xs[1]=x+lado/2;
		xs[2]=x+lado;
		ys[0]=y;
		ys[1]= (int)(y - lado*Math.sqrt(3) / 2);
		ys[2]=y;
		
		if(relleno)
			g.fillPolygon(xs, ys, 3); 
		else
			g.drawPolygon(xs, ys, 3); 
	}

}
