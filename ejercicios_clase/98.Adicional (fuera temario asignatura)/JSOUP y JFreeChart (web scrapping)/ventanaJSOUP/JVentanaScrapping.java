import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.awt.event.*;

public class JVentanaScrapping extends JFrame
{

    private JTextArea txtWeb;
    private JButton btnAcceder;
    private JButton btnLimpiar;

    public static void main(String args[])
    {
        new JVentanaScrapping();
    }

    public JVentanaScrapping()
    {
        super("Noticias Deportivas");
        this.setLayout(new BorderLayout(5,5)); //Gaps entre zonas

        JLabel lblTitulo = new JLabel("Noticias Deportivas: Marca, As y Mundo Deportivo", new ImageIcon("java.png"), JLabel.CENTER); //Centra el componente en el área
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        //lblTitulo.setForeground(Color.BLUE);
        lblTitulo.setForeground(new Color(50, 90, 168));

        //Se utiliza el constructor que recibe un LayoutManager
        //Se incluyen GAPs entre celdas del Grid
        JPanel pnlCentro = new JPanel(new FlowLayout()); 
    
        txtWeb = new JTextArea(50, 50);
        pnlCentro.add(new JScrollPane(txtWeb));
        
        JPanel pnlSur = new JPanel();
        pnlSur.setLayout(new FlowLayout());

        btnAcceder = new JButton("Leer noticias de hoy");
        btnLimpiar = new JButton("Limpiar");
        pnlSur.add(btnAcceder);
        pnlSur.add(btnLimpiar);

        this.add(lblTitulo, BorderLayout.NORTH); //Si una zona del Layout solo tiene un componente, puede agregarse sin Panel
        this.add(pnlCentro, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH); //Al tener solo un componente, se podría agregar sin Panel. Se deja así para agregar más botones en el futuro.
        
        //this.setTitle("Un titulo");
        //this.setSize(400, 200);

        btnAcceder.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    WebScrappingMarca hiloMarca = new WebScrappingMarca(JVentanaScrapping.this);
                    hiloMarca.start();
                    WebScrappingAs hiloAs = new WebScrappingAs(JVentanaScrapping.this);
                    hiloAs.start();
                    WebScrappingMundoDeportivo hiloMD = new WebScrappingMundoDeportivo(JVentanaScrapping.this);
                    hiloMD.start();
                }
            });

        btnLimpiar.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    txtWeb.setText("");
                }
            });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack(); //Ajusta el tamaño de la ventana al tamaño de sus componentes.
        //this.setLocation(500, 10); //Posiciona la ventana en X, Y
        this.setLocationRelativeTo(null); //Posiciona la ventana en el centro de la pantalla
        
        this.setVisible(true); //Último método
    }

    public synchronized void actualizarNoticia(String noticia)
    {
        txtWeb.append(noticia + "\n");
    }

    public synchronized void mostrarError(String... errores)
    {
        for(String error:errores)
            javax.swing.JOptionPane.showMessageDialog(this, error);
    }

}
