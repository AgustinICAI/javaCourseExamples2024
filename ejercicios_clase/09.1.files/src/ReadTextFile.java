import java.io.*;
import java.util.ArrayList;

public class ReadTextFile {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("fichero.txt")));
            /*
            String linea = br.readLine();
            while(linea!=null){
                a.add(linea);
                linea = br.readLine();
            }*/
            String linea;
            while ( (linea = br.readLine()) != null)
                a.add(linea);
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        a.forEach(e->System.out.println(e));

    }
}