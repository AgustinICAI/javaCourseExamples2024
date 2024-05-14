package examen2023.ui;

import examen2023.domain.Planeta;
import examen2023.domain.PlanetaMovimiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Fondo extends JPanel {

    private JVentana jVentana;
    public static int ANCHO_FONDO=1000;
    public static int ALTO_FONDO=1000;

    public static int FPS = 60;

    Collection<Planeta> planetasCargados = new ArrayList<>();
    Thread hiloAnimacion;

    public Fondo(JVentana jVentana){
        this.jVentana = jVentana;
        this.setPreferredSize(new Dimension(ANCHO_FONDO,ALTO_FONDO));
        this.setBackground(Color.BLACK);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE -> {
                        if(!jVentana.getPlanetas().isEmpty()) {
                            Planeta p = jVentana.getPlanetas().pop();
                            planetasCargados.add(p);
                            repaint();
                        }
                    }
                    case KeyEvent.VK_ENTER -> {
                        if(hiloAnimacion == null || !hiloAnimacion.isAlive()){
                            hiloAnimacion = new Thread(()->{
                                long inicio = System.nanoTime();
                                planetasCargados.stream().filter( PlanetaMovimiento.class::isInstance )
                                        .map(PlanetaMovimiento.class::cast)
                                        .forEach(PlanetaMovimiento::inicioAnimacion);
                                while ((System.nanoTime() - inicio)/1E9 < 1){
                                    planetasCargados.stream().forEach(p->{ if( p instanceof PlanetaMovimiento pm)
                                        pm.actualizar();
                                    });
                                    repaint();
                                    try {
                                        Thread.sleep(1000/FPS);
                                    } catch (InterruptedException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                }

                            });
                            hiloAnimacion.start();
                        }
                    }
                    case KeyEvent.VK_R -> {
                        setVisibles(Color.RED);
                        repaint();
                    }
                    case KeyEvent.VK_G -> {
                        setVisibles(Color.GREEN);
                        repaint();
                    }
                    case KeyEvent.VK_B -> {
                        setVisibles(Color.BLUE);
                        repaint();
                    }
                    case KeyEvent.VK_A -> {
                        planetasCargados.forEach(p -> p.setVisible(true));
                        repaint();
                    }
                    case KeyEvent.VK_S -> Planeta.GuardarPlanetas(planetasCargados.
                            stream().filter(p -> p.isVisible()).collect(Collectors.toList()));
                }
            }
        });
    }

    private void setVisibles(Color color) {
        planetasCargados.stream().forEach(p -> {
            if (p.getColor().equals(color))
                p.setVisible(true);
            else
                p.setVisible(false);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        planetasCargados.forEach(p -> p.paint(g));
    }


}
