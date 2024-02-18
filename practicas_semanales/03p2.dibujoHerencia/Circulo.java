import java.awt.Color;

public class Circulo extends Figura
{
	public final static int RADIO_MIN = 2; 
	public final static int RADIO_MAX = 600; 

	int radio;

	/** 
		Inicializa todos los atributos del objeto 
		@param x Posición x de la ventana en pixels
		@param y Posición x de la ventana en pixels
		@param lado Tamaño del cuadrado en pixels
	*/
	Circulo(int x, int y, boolean relleno, Color color, int radio)
	{
		super(x, y, relleno, color);
		this.setRadio(radio);
	}

	void setRadio(int radio)
	{
		if(radio >= RADIO_MIN && radio < RADIO_MAX)
			this.radio = radio;
		else
			this.radio = RADIO_MIN;
	}

	int getRadio()
	{
		return radio;
	}

	@Override
	void pintar(java.awt.Graphics g)
	{
		super.pintar(g);
		if(relleno)
			g.fillOval(x, y, radio*2, radio*2); 
		else
			g.drawOval(x, y, radio*2, radio*2); 
	}

}
