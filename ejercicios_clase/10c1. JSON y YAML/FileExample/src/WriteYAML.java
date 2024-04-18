import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteYAML {

    public static void main (String ... argv){
        Yaml yaml = new Yaml();
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
            PrintWriter pw = new PrintWriter(new FileWriter(new File("output/prueba.yaml")));
            yaml.dump(u,pw);
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
