public class Cuadrado
{
	int x;
	int y;
	int lado;

	/** 
		Inicializa todos los atributos del objeto 
		@param x Posición x de la ventana en pixels
		@param y Posición x de la ventana en pixels
		@param lado Tamaño del cuadrado en pixels
	*/
	Cuadrado(int x, int y, int lado)
	{
		this.setX(x);
		this.setY(y);
		this.setLado(lado);
	}

	int getX()
	{
		return x;
	}

	int getY()
	{
		return y;
	}

	int getLado()
	{
		return lado;
	}

	void setX(int x)
	{
		if(x>0 && x<800)
			this.x=x;
	}

	void setY(int y)
	{
		if(y>0 && y<600)
			this.y=y;
	}

	void setLado(int lado)
	{
		if(x>1 && x<600)
			this.lado=lado;
	}
}