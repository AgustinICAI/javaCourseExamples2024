package ui;

import domain.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cifrador> cifradores = new ArrayList<>();
        cifradores.add(new CifradorMorse());
        cifradores.add(new CifradorAscii());
        cifradores.add(new CifradorBase64());
        cifradores.add(new CifradorCesar(10));

        String mensajes[] = new String[4];
        mensajes[0] = "ABCDEFGHIJKLMNOPQRSTVWXYZ abcdefghijklmnopqrstuvwxyz1234567890";
        mensajes[1] = "Per Aspera Ad Astra";
        mensajes[2] = "Me lo estoy pasando divino en este examen";
        mensajes[3] = "Estoy en el examen intercuatrimestral de POO";

        for(String m : mensajes ) {
            System.out.println("MENSAJE A CODIFICAR: " + m);
            for (Cifrador c : cifradores) {
                System.out.println(c.getClass() + ": " + c.cifra(m));
            }
        }


    }
}