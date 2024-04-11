package es.icai.gitt.juegos.shootingMario.ui;

import es.icai.gitt.juegos.shootingMario.dominio.Juego;
import es.icai.gitt.juegos.shootingMario.dominio.Personaje;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;


public class Fondo extends JPanel implements Runnable {
    private JVentanaJuego ventana;
    private Image fondo;

    private Collection<Integer> teclasPulsadas = new HashSet<>();
    private boolean pulsarTeclaContinuar = false;

    public Fondo(JVentanaJuego ventana) {
        try {
            fondo = ImageIO.read(new File("./resources/fondo.png"));
        } catch (IOException exception) {

        }

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                teclasPulsadas.add(e.getKeyCode());
				if(pulsarTeclaContinuar) {
					new Thread(Fondo.this).start();
					pulsarTeclaContinuar = false;
					ventana.getJuego().volverAEmpezar();
				}
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasPulsadas.remove(e.getKeyCode());
            }
        });

        this.ventana = ventana;
        this.setPreferredSize(new Dimension(fondo.getWidth(null), fondo.getHeight(null)));
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, null);
        this.ventana.getJuego().getPersonajes().forEach(p -> p.paint(g));
        g.setColor(Color.BLUE);
        g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 30));

        //Pintando puntuacion personajes
        int i = 0;
        for(Personaje p : ventana.getJuego().getPersonajes()) {
            g.drawString(String.format("%s: %2d", p.getName(), p.getPuntos()), 820, 30 + i);
            i+=70;
        }
        //Pintando los mensajes del juego
        if (ventana.getJuego().getMessage() != null && System.nanoTime() - ventana.getJuego().getTsLastMessage() < 3 * 1e9) {
            g.drawString(ventana.getJuego().getMessage(), 30, 30);
        }
        //Viendo si es final de partida
        if (ventana.getJuego().getFinPartida() != null) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 100));
            g.drawString(ventana.getJuego().getFinPartida(), 140, 300);
			if(pulsarTeclaContinuar){
				g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 28));
				g.drawString("PULSE UNA TECLA PARA VOLVER A EMPEZAR ...", 140, 350);
			}
        }
    }

    @Override
    public void run() {
        try {
            while (ventana.getJuego().getFinPartida() == null) {
                long tiempo1 = System.nanoTime();
                ventana.getJuego().moverPersonajes(teclasPulsadas);
                ventana.getJuego().comprobarLogica();
                double tiempoTotal = System.nanoTime() - tiempo1;
                repaint();
                double refreshRate = (1.0 / Juego.FPS * 1000);
                int tiempoSleep = (int) (refreshRate - tiempoTotal / 1000000);
                if (tiempoSleep < 0)//Hemos perdido todo el tiempo calculando
                    tiempoSleep = 0;
                //Dormimos el tiempo que nos queda después del cálculo
                Thread.sleep(tiempoSleep);
            }
            Thread.sleep(1000);
            this.pulsarTeclaContinuar = true;
			repaint();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
