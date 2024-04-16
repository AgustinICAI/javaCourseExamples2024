import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameHilos extends JFrame{

    JTextArea txtArea;
    int id;
    public JFrameHilos(){
        super();
        txtArea = new JTextArea();
        JButton btnHilo = new JButton("CREAR HILO");
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(txtArea);
        this.add(jsp);
        this.add(btnHilo, BorderLayout.SOUTH);

        btnHilo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HiloBoton hb = new HiloBoton(id, JFrameHilos.this);
                id += 1;
                hb.start();
            }
        });



        this.setSize(500,500);
        this.setVisible(true);

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrameHilos.this.dispose();
                System.exit(0);
            }
        });

    }
    public JTextArea getTxtArea() {
        return txtArea;
    }
    synchronized public void append(String texto) {
        this.getTxtArea().append(texto+"\n");
    }

    public static void main(String[] args) {
        new JFrameHilos();
    }
}