package examenMayo.dominio;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IOFichero {

    
    public static int[][] leerCombinaciones(String filePath) throws IOException {
        List<int[]> combinaciones = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");  
                int[] combination = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    combination[i] = Integer.parseInt(parts[i]);
                }
                combinaciones.add(combination);
             
            }
        }
        return combinaciones.toArray(new int[combinaciones.size()][]);
    }
}
