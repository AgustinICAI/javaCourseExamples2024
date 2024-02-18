import java.awt.Color;

public class Cuadrado extends Figura
{ 
	public final static int LADO_MIN = 2; 
	public final static int LADO_MAX = 600; 
	
	int lado;

	/** 
		Inicializa todos los atributos del objeto 
		@param lado Tamaño del cuadrado en pixels
	*/
	Cuadrado(int x, int y, boolean relleno, Color color, int lado)
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
		if(relleno)
			g.fillRect(x, y, lado, lado); 
		else
			g.drawRect(x, y, lado, lado); 
	}
}