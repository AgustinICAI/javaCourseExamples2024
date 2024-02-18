import java.awt.Color;

public class AppDibujo03
{
	public static void main( String[] args )
	{
		Dibujo dibujo = new Dibujo();

		Cuadrado c1 = new Cuadrado(500, 50, true, Color.RED, 200);		
		dibujo.pintar(c1);
		dibujo.pintar(new Circulo(100, 20, true, Color.BLUE, 100));
		dibujo.pintar(new Triangulo(100, 500, false, Color.PINK, 200));
		dibujo.pintar(new Circulo(300, 350, true, Color.GREEN, 100));
		dibujo.pintar(new Triangulo(550, 500, true, Color.PINK, 200));
	}
}
