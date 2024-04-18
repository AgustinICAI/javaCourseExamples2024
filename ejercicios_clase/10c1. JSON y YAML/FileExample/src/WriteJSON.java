import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteJSON {

    public static void main (String ... argv){
        Gson gson = new Gson();
        Preference p1 = new Preference();
        p1.setSize("pequeño");
        p1.setZoom("1");
        Preference p2 = new Preference();
        p2.setSize("mediano");
        p2.setZoom("2");
        Preference p3 = new Preference();
        p3.setSize("grande");
        p3.setZoom("3");
        List<Preference> preferencias = List.of(p1,p2,p3);

        String[] permisos = {"jefe","superJefe"};
        User u = new User();
        u.setName("PACO");
        u.setEmail("paco@gmail.com");
        u.setRoles(permisos);
        u.setPreferences(preferencias);
        u.setAdmin(false);

        File fOutput = new File("output");
        if (!fOutput.exists())
            fOutput.mkdir();

        try {
            FileWriter fw = new FileWriter(new File("output/prueba.json"));
            gson.toJson(u,fw);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
