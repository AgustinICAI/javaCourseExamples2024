import javax.swing.*;
import java.awt.*;

public class AppVentana extends JFrame {

    public AppVentana(){
        super("Mi primera ventana");

        init();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
    }

    private void init() {
        //Por defecto el add añade al CENTER en un borderlayout
        this.add(new JButton("Botón centro"));/*, BorderLayout.CENTER);*/
        //this.add(new JButton("Botón norte"), BorderLayout.NORTH);
        this.add(new JButton("Botón sur"), BorderLayout.SOUTH);
        this.add(new JButton("Botón este"), BorderLayout.EAST);
        this.add(new JButton("Botón oeste"), BorderLayout.WEST);

        //Layout por defecto flowlayout
        JPanel pnlNorte = new JPanel();
        pnlNorte.add(new JButton("1"));
        pnlNorte.add(new JButton("2"));
        JButton btn3 = new JButton("3");
        btn3.setPreferredSize(new Dimension(50,50));
        pnlNorte.add(btn3);
        this.add(pnlNorte, BorderLayout.NORTH);


    }

    public static void main(String[] args) {
        new AppVentana();
    }
}