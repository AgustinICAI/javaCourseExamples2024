package dominio;

public class A
{
    private int a;

    public A(int a)
    {
        this.a = a;
    }

    public int getA()
    {
        return a;
    }

    public void setA(int a)
    {
        this.a = a;
    }

    public int m()
    {
        int x = this.m2() + this.m3();
        return x;
    }

    protected int m2()
    {
        return 1;
    }

    private int m3()
    {
        return 1;
    }

    public String toString()
    {
        return "" + a;
    }
}