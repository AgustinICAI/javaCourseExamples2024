package examen2023.ui;

import examen2023.util.Config;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;


public class JBloques extends JFrame {

    public static final int GAME_WIDTH = 880;
    public static final int GAME_HEIGHT = 550;

    JBloques(){
        super("JBloques");
        HashMap<String,String> config = null;
        try {
            config = Config.LoadConfig();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }

        JFondo fondo = new JFondo(config);
        this.add(fondo);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        fondo.requestFocus();

    }

    public static void main(String[] args) {
        new JBloques();
    }
}