public class AppDibujo02
{
	public static void main( String[] args )
	{
		Dibujo dibujo = new Dibujo();

		Cuadrado.setRELLENO(true);

		dibujo.pintar(new Cuadrado(500, 50, 50));
		Util.wait(1);
		dibujo.pintar(new Cuadrado(300, 300, 100));
		Util.wait(1);
		dibujo.pintar(new Cuadrado(10, 10, 200));
	}
}