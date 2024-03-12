import javax.swing.*;
import java.awt.*;

public class AppVentanaFlow extends JFrame {

    public AppVentanaFlow(){
        super("MI PRIMERA VENTANA");
        this.setLayout(new FlowLayout());
        init();
        this.setVisible(true);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        //EL LAYOUT POR DEFECTO DE UN JFRAME ES EL BORDERLAYOUT

        this.add(new JButton("botón centro"));
        this.add(new JButton("botón norte"));
        this.add(new JButton("botón sur"));
        this.add(new JButton("botón este"));
        this.add(new JButton("botón oeste"));



    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new AppVentanaFlow();
    }



}