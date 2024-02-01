public class AppDibujo01
{
	public static void main(String args[])
	{
		Cuadrado c1 = new Cuadrado(500, 50, 50);		
		Cuadrado c2 = new Cuadrado(300, 300, 100);
		Cuadrado c3 = new Cuadrado(10, 10, 200);

		Util util = new Util();
		Dibujo dibujo = new Dibujo();		

		dibujo.pintar(c1);
		util.wait(1);
		dibujo.pintar(c2);
		util.wait(1);
		dibujo.pintar(c3);
	}
}