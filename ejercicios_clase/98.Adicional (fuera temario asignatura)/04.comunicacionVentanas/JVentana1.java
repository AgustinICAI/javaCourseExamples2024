import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JVentana1 extends JFrame
{

    private JVentana2 ventana2;

    public static void main(String args[])
    {
        new JVentana1();
    }

    public JVentana1()
    {
        super("Ventana 1");
        this.setLayout(new FlowLayout());

        JButton btnAtras = new JButton("Atrás");
        JButton btnSiguiente = new JButton("Siguiente");

        this.add(btnAtras);
        this.add(btnSiguiente);

        btnAtras.setEnabled(false);

        btnSiguiente.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(ventana2==null)
                    ventana2 = new JVentana2(JVentana1.this);
                ventana2.setVisible(true);
                JVentana1.this.setVisible(false);
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350, 100); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true); 
    }
}
