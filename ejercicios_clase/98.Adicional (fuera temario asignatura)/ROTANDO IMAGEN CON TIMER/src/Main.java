import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main
{
    //COMO GENERAR JAR
    //cd dist
    //jar cfe ventana.jar es.icai.poo.clasejar.app.App .

    public static void main(String[] argv) throws IOException {
        File f = new File(".");
        System.out.println(f.getAbsolutePath());

        JFrame frame = new JFrame("EJEMPLO PANEL CON FONDO");
        JPanel panel = new ImagePanel();

        frame.add(panel);
        panel.add(new JButton("boton"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}