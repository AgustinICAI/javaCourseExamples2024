import javax.swing.*;
import java.awt.*;

public class AppVentanaConPanel extends JFrame {

    public AppVentanaConPanel(){
        super("MI PRIMERA VENTANA");
        init();
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

    private void init() {
        //El layout por defecto de panel es el Flowlayout
        JPanel pnlSouth = new JPanel();
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        pnlSouth.add(btnAceptar);
        pnlSouth.add(btnBorrar);

        JPanel pnlNorth = new JPanel();
        pnlNorth.setLayout(new GridLayout(2,1));
        JLabel lblTitulo = new JLabel("Mi Calculadora de clase");
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        Font fontCutre = new Font(Font.MONOSPACED,Font.PLAIN,20);
        lblTitulo.setFont(fontCutre);
        pnlNorth.add(lblTitulo);
        JTextField txtCalculadora = new JTextField(30);
        txtCalculadora.setFont(fontCutre);
        txtCalculadora.setHorizontalAlignment(JTextField.RIGHT);
        pnlNorth.add(txtCalculadora);
        this.add(pnlNorth,BorderLayout.NORTH);

        JPanel pnlCentro = new JPanel();
        pnlCentro.setLayout(new GridLayout(4,3));
        String [] txtBotones = {"7","8","9","4","5","6","1","2","3","","0",""};
        for (String txtBoton : txtBotones)
            if(!txtBoton.equals("")) {
                JButton btn = new JButton(txtBoton);
                btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,20));
                pnlCentro.add(btn);
            }
            else
                pnlCentro.add(new JPanel());


        this.add(pnlCentro);
        this.add(pnlSouth, BorderLayout.SOUTH);



    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        new AppVentanaConPanel();
    }



}