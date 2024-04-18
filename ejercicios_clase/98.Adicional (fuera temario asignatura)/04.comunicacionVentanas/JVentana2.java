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

public class JVentana2 extends JFrame
{

    private JVentana1 ventana1;
    private JVentana3 ventana3;

    public JVentana2(JVentana1 ventana1)
    {
        super("Ventana 2");
        this.ventana1 = ventana1;

        this.setLayout(new FlowLayout());

        JButton btnAtras = new JButton("Atrás");
        JButton btnSiguiente = new JButton("Siguiente");

        this.add(btnAtras);
        this.add(btnSiguiente);

        btnAtras.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ventana1.setVisible(true);
                JVentana2.this.setVisible(false);
            }
        });

        btnSiguiente.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(ventana3==null)
                    ventana3 = new JVentana3(JVentana2.this);
                ventana3.setVisible(true);
                JVentana2.this.setVisible(false);
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350, 100); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true); 
    }
}
