import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class JVentanaRuleta
{
    //COMO GENERAR JAR
    //cd dist
    //jar cfe ventana.jar es.icai.poo.clasejar.app.App .

    public static void main(String[] argv)
    {
        new JVentanaRuleta();
    }
    JVentanaRuleta (){
        File f = new File(".");
        System.out.println(f.getAbsolutePath());

        JFrame frame = new JFrame("EJEMPLO PANEL CON FONDO");
        ImagePanel panel = new ImagePanel();

        frame.add(panel);
        JTextField jtxt = new JTextField(4);
        jtxt.setText("130");
        panel.add(jtxt);
        JButton boton = new JButton("girar");
        panel.add(boton);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    panel.girarRuleta(Integer.parseInt(jtxt.getText()));
                }catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Hay que introducir un numero entero","ERROR",JOptionPane.ERROR_MESSAGE);
                }

            }
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}