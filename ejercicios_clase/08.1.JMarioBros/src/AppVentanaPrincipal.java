import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppVentanaPrincipal extends JFrame {
    FondoPrincipal fondo;
    AppVentanaPrincipal(){
        super("JMarioBros");
        fondo = new FondoPrincipal();
        this.add(fondo);
        
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo.requestFocus();
    }



    public static void main(String[] args) {
        new AppVentanaPrincipal();

    }
}