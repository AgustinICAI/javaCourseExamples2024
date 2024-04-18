import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadYAML {
    public static void main(String argv[])
    {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("student_with_courses.yml"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Yaml yaml = new Yaml(new LoaderOptions());
        User user = yaml.load(inputStream);

        System.out.println(user);

    }
}
