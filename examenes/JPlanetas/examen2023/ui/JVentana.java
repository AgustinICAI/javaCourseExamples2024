package examen2023.ui;

import examen2023.domain.Planeta;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class JVentana extends JFrame {

    private LinkedList<Planeta> planetas;

    public static void main(String[] args) {
        new JVentana();
    }
    private Fondo fondo;
    public JVentana(){
        super("JPlanetas");
        this.fondo = new Fondo(this);
        this.add(fondo);

        try {
            this.planetas = new LinkedList<>(Planeta.readPlanetas());

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-10);
        }

        this.pack();
        fondo.requestFocus();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public LinkedList<Planeta> getPlanetas() {
        return planetas;
    }


}
