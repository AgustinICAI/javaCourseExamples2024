import javax.swing.JOptionPane;

public class App
{
    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Esto es un ejemplo de Ventana de Diálogo", 
            "Ejemplo JOptionPane", JOptionPane.INFORMATION_MESSAGE);

        int opcion = JOptionPane.showConfirmDialog(null, "Esto es un ejemplo de Ventana de Diálogo", 
            "Ejemplo JOptionPane", JOptionPane.YES_NO_OPTION);

        switch(opcion)
        {
            case JOptionPane.YES_OPTION -> System.out.println("Sí");
            case JOptionPane.NO_OPTION -> System.out.println("No");
        }
    }
}