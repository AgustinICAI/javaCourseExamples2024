package dominio;

public class B extends A
{
    private int b;

    public B(int a, int b)
    {
        super(1);
        this.b = b;
    }

    public int getB()
    {
        return b;
    }

    public void setB(int b)
    {
        this.b = b;
    }

    public int m()
    {
        int x = this.m2() + this.m4();
    }

    private int m4()
    {
        return 1;
    }

    @Override
    public String toString()
    {
        return super.toString() + b;
    }

}