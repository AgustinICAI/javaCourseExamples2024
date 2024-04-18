import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.google.gson.Gson;
public class ReadJSON {

    public static void main(String[] args) {
        try {
            // create Gson instance
            Gson gson = new Gson();
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get("resources/user.json"));
            // convert JSON string to User object
            User user = gson.fromJson(reader,User.class);
            // print user object
            System.out.println(user);
            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
