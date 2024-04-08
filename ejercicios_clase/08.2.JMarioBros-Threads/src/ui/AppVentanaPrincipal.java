package ui;

import javax.swing.JFrame;

public class AppVentanaPrincipal extends JFrame {
    GameBackground fondo;
    AppVentanaPrincipal(){
        super("JMarioBros");
        fondo = new GameBackground();
        this.add(fondo);
        
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo.requestFocus();
        fondo.repaint();
    }



    public static void main(String[] args) {
        new AppVentanaPrincipal();
        System.out.println("Fin Hilo 1: Arrancado juego");
    }
}