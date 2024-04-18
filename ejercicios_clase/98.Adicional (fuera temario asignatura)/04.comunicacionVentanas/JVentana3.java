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

public class JVentana3 extends JFrame
{
    private JVentana2 ventana2;

    public JVentana3(JVentana2 ventana2)
    {
        super("Ventana 3");
        this.ventana2 = ventana2;

        this.setLayout(new FlowLayout());

        JButton btnAtras = new JButton("Atrás");
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setEnabled(false);

        this.add(btnAtras);
        this.add(btnSiguiente);

        btnAtras.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ventana2.setVisible(true);
                JVentana3.this.setVisible(false);
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(350, 100); 
        this.setLocationRelativeTo(null); 
        this.setVisible(true); 
    }
}
