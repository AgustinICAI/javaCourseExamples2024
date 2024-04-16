import java.io.*;

public class WriteTextFile {
    public static void main(String[] args) {
        try {
            /*File f = new File("fichero.txt");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            */
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File("fichero.txt"))));
            //hm.forEach((k,v) -> pw.println(k+","+v));
            pw.println("hola");
            pw.println("que tal");
            pw.println("adios");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}