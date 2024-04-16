import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JFrameHilos2 extends JFrame{

    JTextArea txtArea;
    int id;
    public JFrameHilos2(){
        super();
        txtArea = new JTextArea();
        JButton btnHilo = new JButton("CREAR HILO");
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(txtArea);
        this.add(jsp);
        this.add(btnHilo, BorderLayout.SOUTH);

        btnHilo.addActionListener( e -> {
            new Thread(()-> {
                while (true)
                    append("hilo " + id + ": Hola, num ");
            }).start();
            id+=1;
        } );



        HashMap<String,String> hm = new HashMap<>();
        hm.put("1","2");
        for(Map.Entry<String,String> m : hm.entrySet())
            System.out.println(m.getKey() + ";" + m.getValue());

        hm.forEach((k,v) -> System.out.println(k + ";" +v));

        hm.keySet().stream().filter(e -> e.contains("1")).forEach(e->System.out.println(e));

        Set<String> s = hm.keySet().stream().filter(e -> e.contains("1")).collect(Collectors.toSet());

        this.setSize(500,500);
        this.setVisible(true);

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public JTextArea getTxtArea() {
        return txtArea;
    }
    synchronized public void append(String texto) {
        this.getTxtArea().append(texto+"\n");
    }

    public static void main(String[] args) {
        new JFrameHilos2();
    }
}