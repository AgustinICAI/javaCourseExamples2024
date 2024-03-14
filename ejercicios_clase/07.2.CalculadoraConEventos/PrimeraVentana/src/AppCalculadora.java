import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class AppCalculadora extends JFrame implements ActionListener, KeyListener {

    HashMap<JButton, String> btnsCalculadora = new HashMap<>();
    JTextField txtCalculadora;
    Font fontBtns = new Font(Font.SANS_SERIF, Font.BOLD,20);

    public AppCalculadora(){
        super("");

        init();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(500,500);
        this.pack();
        //this.setResizable(false);
        this.setVisible(true);
    }

    private void init() {

        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridLayout(5,5));
        String[] labelButtons = {"<-","(",")","mod","pi",
                                     "7","8","9","div","sqrt",
                                     "4","5","6","x","x²",
                                     "1","2","3","-","",
                                     "0",",","%","+","="};


        for (String literal : labelButtons){
            if(literal.equals(""))
                pnlButtons.add(new JPanel());
            else {
                JButton btn = null;
                if(literal.equals("<-")){
                    btn = new JButton();
                    btn.setIcon(new ImageIcon("resources/backspace.png"));
                }
                else {
                    btn = new JButton(literal);
                }
                btnsCalculadora.put(btn,literal);
                btn.addActionListener(this);
                btn.setFont(fontBtns);
                pnlButtons.add(btn);
            }
        }
        txtCalculadora = new JTextField();
        txtCalculadora.setFont(fontBtns);
        txtCalculadora.setHorizontalAlignment(JTextField.RIGHT);

        this.add(txtCalculadora,BorderLayout.CENTER);
        this.add(pnlButtons,BorderLayout.SOUTH);

        this.addKeyListener(this);

    }

    public static void main(String[] args) {
        new AppCalculadora();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String accion =  btnsCalculadora.get(e.getSource());
        System.out.println("Acción producida: " + btnsCalculadora.get(e.getSource()));
        if(accion.equals("="))
        {
            String expression = txtCalculadora.getText();
            //expression = expression.replaceAll("pi", String.valueOf(Math.PI));
            try {
                double result = new ExpressionBuilder(expression)
                        .build()
                        .evaluate();
                System.out.println("Result: " + result);
                txtCalculadora.setText(String.valueOf(result));
            }catch (Exception ex){
                txtCalculadora.setText("EXPRESION NO VALIDA");
                txtCalculadora.selectAll();
                txtCalculadora.requestFocus();
            }
        }
        else if(accion.equals("<-"))
            this.borrarUltimaTecla();
        else {
            if (accion.equals("x"))
                accion = "*";
            txtCalculadora.setText(txtCalculadora.getText() + accion);
        }
        this.requestFocus();
    }

    private void borrarUltimaTecla(){
        String texto = txtCalculadora.getText();
        texto = texto.substring(0,texto.length()-1);
        txtCalculadora.setText(texto);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == '\b') {
            this.borrarUltimaTecla();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}