import javax.swing.*;
import java.awt.*;

public class AppVentana extends JFrame {

    public AppVentana(){
        super("MI PRIMERA VENTANA");
        init();
        this.setVisible(true);
        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {
        //EL LAYOUT POR DEFECTO DE UN JFRAME ES EL BORDERLAYOUT
        this.add(new JButton("botón centro")/*, BorderLayout.CENTER*/);
        this.add(new JButton("botón norte"), BorderLayout.NORTH);
        this.add(new JButton("botón sur"), BorderLayout.SOUTH);
        this.add(new JButton("botón este"), BorderLayout.EAST);
        this.add(new JButton("botón oeste"), BorderLayout.WEST);



    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new AppVentana();
    }



}