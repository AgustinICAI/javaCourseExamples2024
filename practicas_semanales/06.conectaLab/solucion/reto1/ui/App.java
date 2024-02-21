package ui;

import dominio.A;
import dominio.B;

public class App
{
    public static void main(String args[])
    {
        A a1 = new A(1);
        B b1 = new B(1, 1);
        a1.m();
        b1.m();
    }
}