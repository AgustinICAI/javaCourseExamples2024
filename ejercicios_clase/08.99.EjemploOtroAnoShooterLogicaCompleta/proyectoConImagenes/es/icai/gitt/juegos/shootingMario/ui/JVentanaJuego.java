package es.icai.gitt.juegos.shootingMario.ui;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

import es.icai.gitt.juegos.shootingMario.dominio.Juego;

public class JVentanaJuego extends JFrame {
    private Juego juego;
    private Fondo fondo;

    public static void main(String[] args) {
        new JVentanaJuego();
    }

    public JVentanaJuego() {
        super("Killing super mario");
        try {
            this.juego = new Juego();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(99);
        }
        this.setLayout(new BorderLayout());
        init();
        new Thread(fondo).start();
    }

    private void init() {
        fondo = new Fondo(this);
        this.add(fondo);
        this.pack();
        this.setResizable(false);
        fondo.requestFocus();
        this.setLocationRelativeTo(null);//Ventana arranca centrada
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    public Juego getJuego() {
        return juego;
    }


}