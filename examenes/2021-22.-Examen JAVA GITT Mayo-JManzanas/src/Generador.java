public class Generador
{
    public static int generaX(int min, int max)
    {
        double d = Math.random();
        d = d * (max - min) + min;
        return (int) d;
    }

    public static int generaVelocidad()
    {
        return (int) generaX(1, 4);
    }
}
